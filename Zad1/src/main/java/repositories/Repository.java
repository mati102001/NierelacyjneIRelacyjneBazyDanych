package repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface Repository<T> {

    T get(Long id);
    boolean remove(T t);
    List<T> getAll();
    T update(T t);
    T add(T t);
}
