package com.planrest.dao.impl;

import com.planrest.dao.interfaces.UserRatingDAO;
import com.planrest.entities.Userrating;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

@Transactional
@Repository
public class UserRatingDAOImpl extends CrudDAOImpl<Userrating, Integer> implements Serializable, UserRatingDAO {
    private static final long serialVersionUID = 1L;

    @Override
    public Userrating getUserRatingByUserId(int id) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT ur FROM Userrating ur INNER JOIN ur.userReceivingId u WHERE u.id = :id");
        query.setParameter("id", id);
        return (Userrating) query.uniqueResult();
    }

    @Override
    public double getAverageRatingByUserId(int id) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT AVG(ur.rating) FROM Userrating ur INNER JOIN ur.userReceivingId u " +
                        "WHERE u.id = :id GROUP BY u.id");
        query.setParameter("id", id);
        return (double) query.uniqueResult();
    }
}
