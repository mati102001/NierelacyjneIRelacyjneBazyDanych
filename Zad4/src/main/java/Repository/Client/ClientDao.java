package Repository.Client;

import com.datastax.oss.driver.api.mapper.annotations.*;
import model.Client;

import java.util.List;

@Dao
public interface ClientDao {
    @Insert
    void create(Client client);

    @Delete
    void delete(Client client);

    @QueryProvider(providerClass = FindClientQueryProvider.class, entityHelpers = {Client.class})
    Client findById(String id);

    @QueryProvider(providerClass = FindClientsQueryProvider.class, entityHelpers = {Client.class})
    List<Client> findAllClients();

    @Update
    void update(Client client);
}
