package ua.com.foxminded.service;

import java.util.List;

public interface CrudService<T, ID> {
    T add(T entity);

    T getById(ID id);

    List<T> getAll();

    T update(T entity);

    void remove(T entity);
}
