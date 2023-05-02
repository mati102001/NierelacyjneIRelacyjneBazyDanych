package Repository.Client;

import Repository.CassandraConnector;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.datastax.oss.driver.api.core.type.DataTypes;
import com.datastax.oss.driver.api.querybuilder.SchemaBuilder;
import model.Client;

import java.util.List;

public class ClientRepository extends CassandraConnector implements AutoCloseable {

    private ClientMapper clientMapper;
    private ClientDao clientDao;

    private SimpleStatement createTableIfNotExist;

    public ClientRepository() {
        super.initSession();

        createTableIfNotExist =
                SchemaBuilder.createTable("clients")
                        .ifNotExists()
                        .withPartitionKey("id", DataTypes.TEXT)
                        .withColumn("first_name", DataTypes.TEXT)
                        .withColumn("last_name", DataTypes.TEXT)
                        .withColumn("age", DataTypes.INT)
                        .build();
        session.execute(createTableIfNotExist);

        clientMapper = new ClientMapperBuilder(session).build();
        clientDao = clientMapper.clientDao();
    }

    public Client add(Client c) {
        clientDao.create(c);
        return c;
    }

    public Client getClientByPersonalId(String personalId) {
        return clientDao.findById(personalId);
    }

    public Client get(String id) {
        return clientDao.findById(id);
    }

    public List<Client> getAllClients() {
        return clientDao.findAllClients();
    }

    public void removeById(String id) {
        clientDao.delete(clientDao.findById(id));
    }

    public void update(Client c) {
        clientDao.update(c);
    }

    @Override
    public void close() throws Exception {

    }
}
