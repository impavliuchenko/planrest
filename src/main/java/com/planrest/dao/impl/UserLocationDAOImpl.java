package com.planrest.dao.impl;

import com.planrest.dao.interfaces.UserLocationDAO;
import com.planrest.entities.Userlocation;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;
import java.util.List;

@Transactional
@Repository
public class UserLocationDAOImpl extends CrudDAOImpl<Userlocation, Integer> implements Serializable, UserLocationDAO {
    private static final long serialVersionUID = 1L;

    @Override
    public Userlocation getUserLocationByUserId(int id) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT ul FROM UserUserlocation uul INNER JOIN  uul.userId u " +
                        "INNER JOIN uul.locationId ul WHERE u.id = :id");
        query.setParameter("id", id);
        return (Userlocation) query.uniqueResult();
    }

    @Override
    public List<String> getAllUserLocations() {
        return (List<String>) sessionFactory.getCurrentSession()
                .createQuery("SELECT ul.locationName FROM Userlocation ul").list();
    }
}
