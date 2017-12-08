package com.planrest.dao.interfaces;

import com.planrest.entities.Location;

import java.util.List;

public interface LocationDAO extends CrudDAO<Location, Integer> {
    List<String> getAllLocationNames();
    Location getLocationByLocationName(String locationName);
}
