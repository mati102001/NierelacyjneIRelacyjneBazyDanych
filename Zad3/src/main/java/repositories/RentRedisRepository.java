package repositories;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import model.Config;
import model.Rent;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;

public class RentRedisRepository extends DecoratorRentRepository implements Closeable {

    protected Repository<Rent> rentRepo;

    public RentRedisRepository(Repository<Rent> rentRepo) {
        super(rentRepo);
        this.rentRepo = rentRepo;
    }
    private Jsonb jsonb = JsonbBuilder.create();
    Config cfg = new Config();
    private JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), cfg.getProperty("redisUrl"));

    public Rent add(Rent rent) {
        try (Jedis jedis = jedisPool.getResource()) {
            String json = jsonb.toJson(rent);
            jedis.set(rent.getRentId(), json);
            jedis.disconnect();
        } catch (Exception e) {

        }
        return rent;
    }

    public Rent get(String id) {
        try (Jedis jedis = jedisPool.getResource()) {
            String json = jedis.get(id);
            jedis.disconnect();
            return jsonb.fromJson(json, Rent.class);
        } catch (Exception e) {
            return rentRepo.get(id);
        }
    }

    public void clearCache() {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.flushAll();
            jedis.disconnect();
        } catch (Exception e) {

        }
    }

    public void addAll() {
        ArrayList<Rent> rents = (ArrayList<Rent>) rentRepo.getAll();
        this.clearCache();
        for (Rent rent : rents) {
            this.add(rent);
        }
    }

    public void addBoth(Rent rent) {
        try (Jedis jedis = jedisPool.getResource()) {
            String json = jsonb.toJson(rent);
            rentRepo.add(rent);
            jedis.set(rent.getRentId(), json);
            jedis.disconnect();
        } catch (Exception e) {
            throw e;
        }
    }

    public JedisPool getJedisPool() {
        return jedisPool;
    }

    @Override
    public void close() throws IOException {
        jedisPool.close();
    }
}
