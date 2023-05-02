package Repository.Client;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.mapper.MapperContext;
import com.datastax.oss.driver.api.mapper.entity.EntityHelper;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import com.datastax.oss.driver.api.querybuilder.relation.Relation;
import com.datastax.oss.driver.api.querybuilder.select.Select;
import model.Client;

import java.util.List;

import static com.datastax.oss.driver.api.querybuilder.QueryBuilder.literal;

public class FindClientQueryProvider {
    private final CqlSession session;

    private EntityHelper<Client> clientEntityHelper;

    public FindClientQueryProvider(MapperContext mapperContext, EntityHelper<Client> clientEntityHelper) {
        this.session = mapperContext.getSession();
        this.clientEntityHelper = clientEntityHelper;
    }

    Client findById(String id) {
        Select selectClient = QueryBuilder
                .selectFrom(CqlIdentifier.fromCql("clients"))
                .all()
                .where(Relation.column(CqlIdentifier.fromCql("id")).isEqualTo(literal(id)));

        Row row = session.execute(selectClient.build()).one();

        return getClient(row);
    }

    private Client getClient(Row row) {
        try {
            return new Client(
                    row.getString(CqlIdentifier.fromCql("first_name")),
                    row.getString(CqlIdentifier.fromCql("last_name")),
                    row.getString(CqlIdentifier.fromCql("id")),
                    row.getInt(CqlIdentifier.fromCql("age"))
            );
        } catch (Exception e) {
            throw e;
        }
    }
}
