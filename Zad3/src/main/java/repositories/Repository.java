package repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface Repository<T> {

    T get(String id);
    boolean remove(String id);
    List<T> getAll();
    T update(T t);
    T add(T t);
}
