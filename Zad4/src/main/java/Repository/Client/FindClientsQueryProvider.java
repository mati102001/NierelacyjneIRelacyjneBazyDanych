package Repository.Client;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.mapper.MapperContext;
import com.datastax.oss.driver.api.mapper.entity.EntityHelper;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import com.datastax.oss.driver.api.querybuilder.select.Select;
import model.Client;

import java.util.List;

public class FindClientsQueryProvider {
    private final CqlSession session;

    private EntityHelper<Client> clientEntityHelper;

    public FindClientsQueryProvider(MapperContext mapperContext, EntityHelper<Client> clientEntityHelper) {
        this.session = mapperContext.getSession();
        this.clientEntityHelper = clientEntityHelper;
    }

    List<Client> findAllClients() {
        Select selectClient = QueryBuilder
                .selectFrom(CqlIdentifier.fromCql("clients"))
                .all();

        List<Row> rows = session.execute(selectClient.build()).all();

        return rows.stream().map(this::getClient).toList();
    }


    private Client getClient(Row row) {
        return new Client(
                row.getString(CqlIdentifier.fromCql("first_name")),
                row.getString(CqlIdentifier.fromCql("last_name")),
                row.getString(CqlIdentifier.fromCql("id")),
                row.getInt(CqlIdentifier.fromCql("age"))
        );
    }
}
