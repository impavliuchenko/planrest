package com.planrest.dao.impl;

import com.planrest.dao.interfaces.LocationDAO;
import com.planrest.entities.Location;
import org.hibernate.query.Query;
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

    @Override
    public Location getLocationByLocationName(String locationName) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("FROM Location l WHERE l.locationName LIKE :locationName");
        query.setParameter("locationName", locationName);
        return (Location) query.uniqueResult();
    }
}
