package com.planrest.dao.interfaces;

import com.planrest.entities.Userrating;

public interface UserRatingDAO extends CrudDAO<Userrating, Integer> {
    Userrating getUserRatingByUserId(int id);
    double getAverageRatingByUserId(int id);
}
