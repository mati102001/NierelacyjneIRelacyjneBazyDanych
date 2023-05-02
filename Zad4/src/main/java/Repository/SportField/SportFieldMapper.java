package Repository.SportField;

import com.datastax.oss.driver.api.mapper.annotations.DaoFactory;
import com.datastax.oss.driver.api.mapper.annotations.DaoKeyspace;
import com.datastax.oss.driver.api.mapper.annotations.DaoTable;
import com.datastax.oss.driver.api.mapper.annotations.Mapper;

@Mapper
public interface SportFieldMapper {
    @DaoFactory
    SportFieldDao sportFieldDao(@DaoKeyspace String keyspace, @DaoTable String table);

    @DaoFactory
    SportFieldDao sportFieldDao();
}
