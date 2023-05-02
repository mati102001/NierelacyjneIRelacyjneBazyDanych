package repositories;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ReplaceOptions;
import model.Client;
import model.SportField;
import org.bson.Document;
import java.util.ArrayList;

public class SportCentreRepository extends AbstractMongoRepository {

    public SportCentreRepository() {
        initDbConnection();
    }

    public SportCentreRepository(String uri) {
        initDbConnectionWithUri(uri);
    }

    public SportField get(String id) {

        MongoCollection<SportField> collection = getDatabase().getCollection("fields", SportField.class);
        SportField field = collection.find(Filters.eq("_id", id)).first();
        return field;
    }


    public boolean remove(String id) {

        BasicDBObject searchQ = new BasicDBObject();
        searchQ.put("_id", id);
        MongoCollection<SportField> collection = getDatabase().getCollection("fields", SportField.class);
        collection.findOneAndDelete(searchQ);
        return true;
    }


    public ArrayList<SportField> getAll() {

        MongoCollection<SportField> collection = getDatabase().getCollection("fields", SportField.class);
        ArrayList<SportField> list = collection.find(new Document(), SportField.class).into(new ArrayList<SportField>());
        return list;
    }


    public SportField update(SportField sportField) {
        MongoCollection<SportField> collection = getDatabase().getCollection("fields", SportField.class);
        BasicDBObject searchQ = new BasicDBObject();
        searchQ.put("_id", sportField.getSportFieldId());
        collection.replaceOne(searchQ, sportField, new ReplaceOptions().upsert(true));
        return sportField;
    }


    public SportField add(SportField field) {

        MongoCollection<SportField> collection = getDatabase().getCollection("fields", SportField.class);
        collection.insertOne(field);
        return field;
    }


    @Override
    public void close() throws Exception {

    }
}
