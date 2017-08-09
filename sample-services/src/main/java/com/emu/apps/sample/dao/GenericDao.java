package com.emu.apps.sample.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by eric on 04/02/2017.
 */
public abstract class GenericDao<T> {

    @PersistenceContext(unitName = "sample-unit")
    protected EntityManager entityManager;

    public T merge(T e) {
        return entityManager.merge(e);
    }

    public void persist(T e) {
        entityManager.persist(e);
    }

    public void remove(T entity) {
        entityManager.remove(entity);
    }

}
