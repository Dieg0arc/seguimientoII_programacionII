package repository;

import java.sql.ResultSet;
import java.util.List;

public interface Repository <T>{
    List<T> list ();
    T byId(Integer id_practicas);
    void save (T t);
    void delete (Long id);
}
