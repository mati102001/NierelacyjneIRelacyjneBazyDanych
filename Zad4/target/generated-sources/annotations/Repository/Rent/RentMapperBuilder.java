package Repository.Rent;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.mapper.MapperBuilder;
import com.datastax.oss.driver.internal.mapper.DefaultMapperContext;
import java.lang.Override;
import java.lang.SuppressWarnings;

/**
 * Builds an instance of {@link RentMapper} wrapping a driver {@link CqlSession}.
 *
 * <p>Generated by the DataStax driver mapper, do not edit directly.
 */
@SuppressWarnings("all")
public class RentMapperBuilder extends MapperBuilder<RentMapper> {
  public RentMapperBuilder(CqlSession session) {
    super(session);
  }

  @Override
  public RentMapper build() {
    DefaultMapperContext context = new DefaultMapperContext(session, defaultKeyspaceId, defaultExecutionProfileName, defaultExecutionProfile, customState);
    return new RentMapperImpl__MapperGenerated(context);
  }
}