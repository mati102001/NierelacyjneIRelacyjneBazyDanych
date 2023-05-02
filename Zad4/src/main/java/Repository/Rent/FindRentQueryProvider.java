package Repository.Rent;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.mapper.MapperContext;
import com.datastax.oss.driver.api.mapper.entity.EntityHelper;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import com.datastax.oss.driver.api.querybuilder.relation.Relation;
import com.datastax.oss.driver.api.querybuilder.select.Select;
import model.Client;
import model.Rent;

import java.util.UUID;

import static com.datastax.oss.driver.api.querybuilder.QueryBuilder.literal;

public class FindRentQueryProvider {

    private final CqlSession session;

    private EntityHelper<Rent> rentEntityHelper;

    public FindRentQueryProvider(MapperContext mapperContext, EntityHelper<Rent> rentEntityHelper) {
        this.session = mapperContext.getSession();
        this.rentEntityHelper = rentEntityHelper;
    }

    Rent findById(String id) {
        Select selectRent = QueryBuilder
                .selectFrom(CqlIdentifier.fromCql("rents"))
                .all()
                .where(Relation.column(CqlIdentifier.fromCql("id")).isEqualTo(literal(id)));

        Row row = session.execute(selectRent.build()).one();
        return getRent(row);
    }

    private Rent getRent(Row row) {
        try {
            return new Rent(
                    row.getString(CqlIdentifier.fromCql("id")),
                    row.getLocalTime(CqlIdentifier.fromCql("start")),
                    row.getLocalTime(CqlIdentifier.fromCql("end")),
                    row.getLocalDate(CqlIdentifier.fromCql("date")),
                    row.getString(CqlIdentifier.fromCql("client_id")),
                    row.getString(CqlIdentifier.fromCql("field_id"))
            );
        } catch (Exception e) {
            throw e;
        }
    }
}
