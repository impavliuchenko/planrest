package com.planrest.dao.interfaces;

import com.planrest.entities.Userlocation;

import javax.persistence.criteria.CriteriaBuilder;

public interface UserLocationDAO extends CrudDAO<Userlocation, Integer> {
    Userlocation getUserLocationByUserId(int id);
}
