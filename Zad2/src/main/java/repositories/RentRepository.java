package repositories;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ReplaceOptions;
import model.Client;
import model.Rent;
import org.bson.Document;
import java.util.ArrayList;

public class RentRepository extends AbstractMongoRepository {

    public RentRepository() {
        initDbConnection();
    }

    public RentRepository(String uri) {
        initDbConnectionWithUri(uri);
    }

    public Rent get(String id) {
        MongoCollection<Rent> collection = getDatabase().getCollection("rents", Rent.class);
        Rent rent = collection.find(Filters.eq("_id", id)).first();
        return rent;
    }

    public boolean remove(String id) {
        BasicDBObject searchQ = new BasicDBObject();
        searchQ.put("_id", id);
        MongoCollection<Rent> collection = getDatabase().getCollection("rents", Rent.class);
        collection.findOneAndDelete(searchQ);
        return true;
    }


    public ArrayList<Rent> getAll() {
        MongoCollection<Rent> collection = getDatabase().getCollection("rents", Rent.class);
        ArrayList<Rent> list = collection.find(new Document(), Rent.class).into(new ArrayList<Rent>());
        return list;
    }


    public Rent update(Rent rent) {
        MongoCollection<Rent> collection = getDatabase().getCollection("rents", Rent.class);
        BasicDBObject searchQ = new BasicDBObject();
        searchQ.put("_id", rent.getRentId());
        collection.replaceOne(searchQ, rent, new ReplaceOptions().upsert(true));
        return rent;
    }


    public Rent add(Rent rent) {
        MongoCollection<Rent> collection = getDatabase().getCollection("rents", Rent.class);
        collection.insertOne(rent);
        return rent;
    }

    @Override
    public void close() throws Exception {

    }
}
