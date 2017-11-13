package com.planrest.dao.interfaces;

import com.planrest.entities.Userlocation;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface UserLocationDAO extends CrudDAO<Userlocation, Integer> {
    Userlocation getUserLocationByUserId(int id);
    List<String> getAllUserLocations();
}
