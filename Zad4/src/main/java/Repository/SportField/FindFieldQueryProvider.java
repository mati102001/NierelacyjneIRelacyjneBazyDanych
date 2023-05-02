package Repository.SportField;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.mapper.MapperContext;
import com.datastax.oss.driver.api.mapper.entity.EntityHelper;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import com.datastax.oss.driver.api.querybuilder.relation.Relation;
import com.datastax.oss.driver.api.querybuilder.select.Select;
import model.Client;
import model.SportField;

import static com.datastax.oss.driver.api.querybuilder.QueryBuilder.literal;

public class FindFieldQueryProvider {
    private final CqlSession session;

    private EntityHelper<SportField> fieldEntityHelper;

    public FindFieldQueryProvider(MapperContext mapperContext, EntityHelper<SportField> fieldEntityHelper) {
        this.session = mapperContext.getSession();
        this.fieldEntityHelper = fieldEntityHelper;
    }

    SportField findById(String id) {
        Select selectField = QueryBuilder
                .selectFrom(CqlIdentifier.fromCql("fields"))
                .all()
                .where(Relation.column(CqlIdentifier.fromCql("id")).isEqualTo(literal(id)));

        Row row = session.execute(selectField.build()).one();

        return getField(row);
    }

    private SportField getField(Row row) {
        try {
            return new SportField(
                    row.getString(CqlIdentifier.fromCql("id")),
                    row.getString(CqlIdentifier.fromCql("type")),
                    row.getString(CqlIdentifier.fromCql("surface"))
            );
        } catch (Exception e) {
            throw e;
        }
    }
}
