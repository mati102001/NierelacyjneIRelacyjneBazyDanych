package repositories;

import com.mongodb.BasicDBObject;
import com.mongodb.ConnectionString;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ReplaceOptions;
import model.Client;
import com.mongodb.client.*;
import org.bson.Document;
import java.util.ArrayList;


public class ClientRepository extends AbstractMongoRepository {

    public ClientRepository() {
        initDbConnection();
    }

    public ClientRepository(String uri) {
        initDbConnectionWithUri(uri);
    }

    public Client get(String id) {
        MongoCollection<Client> collection = getDatabase().getCollection("clients", Client.class);
        Client client = collection.find(Filters.eq("_id", id)).first();
        return client;
    }

    public boolean remove(String id) {
        BasicDBObject searchQ = new BasicDBObject();
        searchQ.put("_id", id);
        MongoCollection<Client> collection = getDatabase().getCollection("clients", Client.class);
        collection.findOneAndDelete(searchQ);
        return true;
    }

    public ArrayList<Client> getAll() {
        MongoCollection<Client> collection = getDatabase().getCollection("clients", Client.class);
        ArrayList<Client> list = collection.find(new Document(), Client.class).into(new ArrayList<Client>());
        return list;
    }

    public Client update(Client client) {
        MongoCollection<Client> collection = getDatabase().getCollection("clients", Client.class);
        BasicDBObject searchQ = new BasicDBObject();
        searchQ.put("_id", client.getClientId());
        collection.replaceOne(searchQ, client, new ReplaceOptions().upsert(true));
        return client;
    }


    public Client add(Client client) {
        MongoCollection<Client> collection = getDatabase().getCollection("clients", Client.class);
        collection.insertOne(client);
        return client;
    }

    @Override
    public void close() throws Exception {

    }
}
