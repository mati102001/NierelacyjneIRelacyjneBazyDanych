package Repository.Rent;

import Repository.CassandraConnector;
import Repository.Client.ClientDao;
import Repository.Client.ClientMapper;
import Repository.Client.ClientMapperBuilder;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.datastax.oss.driver.api.core.type.DataTypes;
import com.datastax.oss.driver.api.querybuilder.SchemaBuilder;
import model.Client;
import model.Rent;

import java.util.List;
import java.util.UUID;

public class RentRepository extends CassandraConnector implements AutoCloseable {

    private RentMapper rentMapper;
    private RentDao rentDao;

    private SimpleStatement createTableIfNotExist;

    public RentRepository() {
        super.initSession();

        createTableIfNotExist =
                SchemaBuilder.createTable("rents")
                        .ifNotExists()
                        .withPartitionKey("id", DataTypes.UUID)
                        .withColumn("start", DataTypes.TIME)
                        .withColumn("end", DataTypes.TIME)
                        .withColumn("date", DataTypes.DATE)
                        .withColumn("client_id", DataTypes.TEXT)
                        .withColumn("field_id", DataTypes.TEXT)
                        .build();
        session.execute(createTableIfNotExist);

        rentMapper = new RentMapperBuilder(session).build();
        rentDao = rentMapper.rentDao();
    }

    public Rent add(Rent c) {
        rentDao.create(c);
        return c;
    }

    public Rent get(String id) {
        return rentDao.findById(id);
    }

    public Rent getRentById(String id) { return rentDao.findById(id);}

    public List<Rent> getAllRents() {
        return rentDao.findAllRents();
    }

    public void removeById(String id) {
        rentDao.delete(rentDao.findById(id));
    }

    public void update(Rent c) {
        rentDao.update(c);
    }

    @Override
    public void close() throws Exception {

    }
}
