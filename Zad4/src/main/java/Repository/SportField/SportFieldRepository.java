package Repository.SportField;

import Repository.CassandraConnector;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.datastax.oss.driver.api.core.type.DataTypes;
import com.datastax.oss.driver.api.querybuilder.SchemaBuilder;
import model.SportField;

import java.util.List;

public class SportFieldRepository extends CassandraConnector implements AutoCloseable {

    private SportFieldMapper sportFieldMapper;
    private SportFieldDao sportFieldDao;

    private SimpleStatement createTableIfNotExist;

    public SportFieldRepository() {
        super.initSession();

        createTableIfNotExist =
                SchemaBuilder.createTable("fields")
                        .ifNotExists()
                        .withPartitionKey("id", DataTypes.TEXT)
                        .withColumn("type", DataTypes.TEXT)
                        .withColumn("surface", DataTypes.TEXT)
                        .build();
        session.execute(createTableIfNotExist);

        sportFieldMapper = new SportFieldMapperBuilder(session).build();
        sportFieldDao = sportFieldMapper.sportFieldDao();
    }

    public SportField add(SportField c) {
        sportFieldDao.create(c);
        return c;
    }

    public SportField getSportFieldById(String id) {
        return sportFieldDao.findById(id);
    }

    public SportField get(String id) {
        return sportFieldDao.findById(id);
    }

    public List<SportField> getAllFields() {
        return sportFieldDao.findAllFields();
    }

    public void removeById(String id) {
        sportFieldDao.delete(sportFieldDao.findById(id));
    }

    public void update(SportField c) {
        sportFieldDao.update(c);
    }

    @Override
    public void close() throws Exception {
        session.close();
    }
}
