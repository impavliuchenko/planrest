package com.planrest.dao.impl;

import com.planrest.dao.interfaces.CrudDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Transactional
public class CrudDAOImpl<T, PK extends Serializable> implements Serializable, CrudDAO<T,PK> {

    private static final long serialVersionUID = 1L;

    @Autowired
    protected SessionFactory sessionFactory;

    protected Class<T> entityClass;

    public CrudDAOImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass()
                .getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }

    @Override
    public T add(T newInstance) {
        this.sessionFactory.getCurrentSession().persist(newInstance);
        return newInstance;
    }

    @Override
    public T readUniqueById(PK id) {
        return this.sessionFactory.getCurrentSession().get(entityClass, id);
    }


    @Override
    public void update(T transientObject) {
        this.sessionFactory.getCurrentSession().merge(transientObject);
    }

    @Override
    public void delete(T persistentObject) {
        this.sessionFactory.getCurrentSession().delete(persistentObject);
    }
}
