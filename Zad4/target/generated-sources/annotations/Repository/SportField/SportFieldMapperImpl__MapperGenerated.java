package Repository.SportField;

import com.datastax.oss.driver.internal.core.util.concurrent.LazyReference;
import com.datastax.oss.driver.internal.mapper.DaoCacheKey;
import com.datastax.oss.driver.internal.mapper.DefaultMapperContext;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Do not instantiate this class directly, use {@link SportFieldMapperBuilder} instead.
 *
 * <p>Generated by the DataStax driver mapper, do not edit directly.
 */
@SuppressWarnings("all")
public class SportFieldMapperImpl__MapperGenerated implements SportFieldMapper {
  private final DefaultMapperContext context;

  private final LazyReference<SportFieldDao> sportFieldDaoCache1;

  private final ConcurrentMap<DaoCacheKey, SportFieldDao> sportFieldDaoCache = new ConcurrentHashMap<>();

  public SportFieldMapperImpl__MapperGenerated(DefaultMapperContext context) {
    this.context = context;
    this.sportFieldDaoCache1 = new LazyReference<>(() -> SportFieldDaoImpl__MapperGenerated.init(context));
  }

  @Override
  public SportFieldDao sportFieldDao(String keyspace, String table) {
    DaoCacheKey key = new DaoCacheKey(keyspace, table, null, null);
    return sportFieldDaoCache.computeIfAbsent(key, k -> SportFieldDaoImpl__MapperGenerated.init(context.withDaoParameters(k.getKeyspaceId(), k.getTableId(), k.getExecutionProfileName(), k.getExecutionProfile())));
  }

  @Override
  public SportFieldDao sportFieldDao() {
    return sportFieldDaoCache1.get();
  }
}
