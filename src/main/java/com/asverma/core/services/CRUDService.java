package com.asverma.core.services;

import java.util.List;

public interface CRUDService<T> {

    T retrieveEntity(int id);

    T createEntity(T t);

    T updateEntity(T t, int id);

    void deleteEntity(int id);

    List<T> retrieveAll();
}
