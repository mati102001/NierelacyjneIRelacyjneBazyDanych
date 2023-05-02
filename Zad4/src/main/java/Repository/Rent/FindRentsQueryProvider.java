package Repository.Rent;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.mapper.MapperContext;
import com.datastax.oss.driver.api.mapper.entity.EntityHelper;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import com.datastax.oss.driver.api.querybuilder.select.Select;
import model.Client;
import model.Rent;

import java.util.List;

public class FindRentsQueryProvider {
    private final CqlSession session;

    private EntityHelper<Rent> rentEntityHelper;

    public FindRentsQueryProvider(MapperContext mapperContext, EntityHelper<Rent> rentEntityHelper) {
        this.session = mapperContext.getSession();
        this.rentEntityHelper = rentEntityHelper;
    }

    List<Rent> findAllRents() {
        Select selectRent = QueryBuilder
                .selectFrom(CqlIdentifier.fromCql("rents"))
                .all();

        List<Row> rows = session.execute(selectRent.build()).all();

        return rows.stream().map(this::getRent).toList();
    }


    private Rent getRent(Row row) {
        return new Rent(
                row.getString(CqlIdentifier.fromCql("id")),
                row.getLocalTime(CqlIdentifier.fromCql("start")),
                row.getLocalTime(CqlIdentifier.fromCql("end")),
                row.getLocalDate(CqlIdentifier.fromCql("date")),
                row.getString(CqlIdentifier.fromCql("client_id")),
                row.getString(CqlIdentifier.fromCql("field_id"))
        );
    }
}
