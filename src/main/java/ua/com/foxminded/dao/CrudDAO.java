package ua.com.foxminded.dao;

import java.util.List;

public interface CrudDAO<T, ID> {
    T add(T entity);

    T getById(ID id);

    List<T> getAll();

    T update(T entity);

    void remove(T entity);
}
