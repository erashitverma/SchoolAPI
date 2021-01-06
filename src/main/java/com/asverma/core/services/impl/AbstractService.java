package com.asverma.core.services.impl;

import com.asverma.core.services.CRUDService;

import java.util.List;

// Unused at the moment due to time restriction //
public class AbstractService<T> implements CRUDService<T> {

    @Override public T retrieveEntity(final int id) {
        return null;
    }

    @Override public T createEntity(final T t) {
        return null;
    }

    @Override public T updateEntity(final T t, final int id) {
        return null;
    }

    @Override public void deleteEntity(final int id) { }

    @Override public List<T> retrieveAll() {
        return null;
    }
}
