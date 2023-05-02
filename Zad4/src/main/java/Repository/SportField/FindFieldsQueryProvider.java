package Repository.SportField;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.mapper.MapperContext;
import com.datastax.oss.driver.api.mapper.entity.EntityHelper;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import com.datastax.oss.driver.api.querybuilder.select.Select;
import model.Client;
import model.SportField;

import java.util.List;

public class FindFieldsQueryProvider {
    private final CqlSession session;

    private EntityHelper<SportField> fieldEntityHelper;

    public FindFieldsQueryProvider(MapperContext mapperContext, EntityHelper<SportField> fieldEntityHelper) {
        this.session = mapperContext.getSession();
        this.fieldEntityHelper = fieldEntityHelper;
    }

    List<SportField> findAllFields() {
        Select selectField = QueryBuilder
                .selectFrom(CqlIdentifier.fromCql("fields"))
                .all();

        List<Row> rows = session.execute(selectField.build()).all();

        return rows.stream().map(this::getField).toList();
    }


    private SportField getField(Row row) {
        return new SportField(
                row.getString(CqlIdentifier.fromCql("type")),
                row.getString(CqlIdentifier.fromCql("surface")),
                row.getString(CqlIdentifier.fromCql("id"))
        );
    }
}
