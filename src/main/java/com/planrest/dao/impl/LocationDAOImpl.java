package com.planrest.dao.impl;

import com.planrest.dao.interfaces.LocationDAO;
import com.planrest.entities.Location;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional
@Repository
public class LocationDAOImpl extends CrudDAOImpl<Location, Integer> implements Serializable, LocationDAO {
    private static final long serialVersionUID = 1L;


    @Override
    public List<String> getAllLocationNames() {
        return (List<String>) sessionFactory.getCurrentSession()
                .createQuery("SELECT rl.locationName FROM Location rl").list();
    }
}
