package Repository.Rent;

import Repository.Client.ClientDao;
import com.datastax.oss.driver.api.mapper.annotations.DaoFactory;
import com.datastax.oss.driver.api.mapper.annotations.DaoKeyspace;
import com.datastax.oss.driver.api.mapper.annotations.DaoTable;
import com.datastax.oss.driver.api.mapper.annotations.Mapper;

@Mapper
public interface RentMapper {
    @DaoFactory
    RentDao rentDao(@DaoKeyspace String keyspace, @DaoTable String table);

    @DaoFactory
    RentDao rentDao();
}
