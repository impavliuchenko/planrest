package com.planrest.dao.interfaces;

import java.io.Serializable;
import java.util.List;

public interface CrudDAO <T, PK extends Serializable> {

    T add(T newInstance);

    T getUniqueById(PK id);

    List<T> getAll();

    void update(T transientObject);

    void delete(T persistentObject);

}
