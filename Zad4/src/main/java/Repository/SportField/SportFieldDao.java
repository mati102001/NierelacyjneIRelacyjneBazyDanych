package Repository.SportField;

import com.datastax.oss.driver.api.mapper.annotations.*;
import model.SportField;

import java.util.List;

@Dao
public interface SportFieldDao {
    @Insert
    void create(SportField field);

    @Delete
    void delete(SportField field);

    @QueryProvider(providerClass = FindFieldQueryProvider.class, entityHelpers = {SportField.class})
    SportField findById(String id);

    @QueryProvider(providerClass = FindFieldsQueryProvider.class, entityHelpers = {SportField.class})
    List<SportField> findAllFields();

    @Update
    void update(SportField field);
}
