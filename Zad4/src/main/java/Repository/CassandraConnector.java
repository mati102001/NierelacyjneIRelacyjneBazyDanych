package Repository;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.auth.AuthProvider;
import com.datastax.oss.driver.api.core.auth.ProgrammaticPlainTextAuthProvider;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.datastax.oss.driver.api.querybuilder.SchemaBuilder;
import com.datastax.oss.driver.api.querybuilder.schema.CreateKeyspace;

import java.net.InetSocketAddress;

import static com.datastax.oss.driver.api.querybuilder.SchemaBuilder.createKeyspace;

public abstract class CassandraConnector {
    protected CqlSession session;
    public void initSession() {

        initSessionWithoutKeyspace();

        AuthProvider authProvider = new ProgrammaticPlainTextAuthProvider("cassandra", "cassandra");

        session = CqlSession.builder()
                .withAuthProvider(authProvider)
                .addContactPoint(new InetSocketAddress("localhost", 9042))
                .addContactPoint(new InetSocketAddress("localhost", 9043))
                .withLocalDatacenter("datacenter1")
                .withKeyspace(CqlIdentifier.fromCql("rent_orlik"))
                .build();

        CreateKeyspace keyspace = createKeyspace("rent_orlik")
                .ifNotExists()
                .withSimpleStrategy(2)
                .withDurableWrites(true);

        SimpleStatement createKeyspace = keyspace.build();

        session.execute(createKeyspace);

    }

    public void initSessionWithoutKeyspace() {

        AuthProvider authProvider = new ProgrammaticPlainTextAuthProvider("cassandra", "cassandra");
        CqlSession sessionWithoutKeyspace = CqlSession.builder()
                .withAuthProvider(authProvider)
                .addContactPoint(new InetSocketAddress("localhost", 9042))
                .addContactPoint(new InetSocketAddress("localhost", 9043))
                .withLocalDatacenter("datacenter1")
                .build();

        sessionWithoutKeyspace.execute(SchemaBuilder.createKeyspace(CqlIdentifier.fromCql("rent_orlik"))
                .ifNotExists()
                .withSimpleStrategy(2)
                .withDurableWrites(true)
                .build());

        sessionWithoutKeyspace.close();

    }
}
