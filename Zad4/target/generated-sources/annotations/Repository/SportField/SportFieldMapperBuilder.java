package Repository.SportField;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.mapper.MapperBuilder;
import com.datastax.oss.driver.internal.mapper.DefaultMapperContext;
import java.lang.Override;
import java.lang.SuppressWarnings;

/**
 * Builds an instance of {@link SportFieldMapper} wrapping a driver {@link CqlSession}.
 *
 * <p>Generated by the DataStax driver mapper, do not edit directly.
 */
@SuppressWarnings("all")
public class SportFieldMapperBuilder extends MapperBuilder<SportFieldMapper> {
  public SportFieldMapperBuilder(CqlSession session) {
    super(session);
  }

  @Override
  public SportFieldMapper build() {
    DefaultMapperContext context = new DefaultMapperContext(session, defaultKeyspaceId, defaultExecutionProfileName, defaultExecutionProfile, customState);
    return new SportFieldMapperImpl__MapperGenerated(context);
  }
}
