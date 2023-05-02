package Repository.Rent;

import com.datastax.oss.driver.api.mapper.annotations.*;
import model.Rent;

import java.util.List;
import java.util.UUID;

@Dao
public interface RentDao {
    @Insert
    void create(Rent rent);

    @Delete
    void delete(Rent rent);

    @QueryProvider(providerClass = FindRentQueryProvider.class, entityHelpers = {Rent.class})
    Rent findById(String id);

    @QueryProvider(providerClass = FindRentsQueryProvider.class, entityHelpers = {Rent.class})
    List<Rent> findAllRents();

    @Update
    void update(Rent rent);
}
