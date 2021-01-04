package com.asverma.core.services.impl;

import com.asverma.core.services.CRUDService;
import com.asverma.db.WrapperInterface;

import java.util.List;

public class AbstractService<T> implements CRUDService<T> {

    private final WrapperInterface wrapperInterface;

    public AbstractService(final WrapperInterface wrapperInterface) {
        this.wrapperInterface = wrapperInterface;
    }

    @Override public T retrieveEntity(final int id) {
        return null;
    }

    @Override public T createEntity(final T t) {
        return null;
    }

    @Override public T updateEntity(final T t, final int id) {
        return null;
    }

    @Override public void deleteEntity(final int id) {

    }

    @Override public List<T> retrieveAll() {
        return null;
    }
}
