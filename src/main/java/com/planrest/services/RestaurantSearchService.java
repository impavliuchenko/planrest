package com.planrest.services;

import com.planrest.dao.interfaces.LocationDAO;
import com.planrest.dao.interfaces.RestaurantRatingDAO;
import com.planrest.dao.interfaces.RestaurantTypeDAO;
import com.planrest.entities.Restaurant;
import com.planrest.entities.Location;
import com.planrest.entities.Restauranttype;
import com.planrest.objects.RestaurantSearchComponent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantSearchService {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private RestaurantSearchComponent restaurantSearchComponent;

    @Autowired
    private LocationDAO locationDAO;

    @Autowired
    private RestaurantTypeDAO restaurantTypeDAO;

    @Autowired
    private RestaurantRatingDAO restaurantRatingDAO;


    @Transactional
    public List<Double> getAverageRestaurantRating(List<Restaurant> restaurants){
        List<Double> averageRatings = new ArrayList<>();

        for (Restaurant r: restaurants) {
            averageRatings.add(restaurantRatingDAO.getAverageRestaurantRatingByRestaurantId(r.getId()));
        }

        return averageRatings;
    }

    @Transactional
    public List<Restaurant> searchRestaurantsByName(String name, String location, String type, String ratingFrom, String ratingTo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session
                .createQuery("SELECT r FROM Restaurant r " +
                        "WHERE r.name LIKE :name " +
                        "AND r.locationId.locationName LIKE :locationName " +
                        "AND restaurantTypeId.typeName LIKE :typeName ");

        query.setParameter("name", "%" + name + "%");
        if (location.equals("<all locations>")) {
            query.setParameter("locationName", "%%");
        } else {
            query.setParameter("locationName", location);
        }
        if (type.equals("<all types>")){
            query.setParameter("typeName", "%%");
        } else {
            query.setParameter("typeName", type);
        }

        double from = 0.0;
        double to = 5.0;

        List<Restaurant> list = (List<Restaurant>) query.list();
        List<Restaurant> finalList = new ArrayList<>();

        if (!ratingFrom.equals("<rating from>")){
            from = Double.parseDouble(ratingFrom);
        }

        if (!ratingTo.equals("<rating to>")){
            to = Double.parseDouble(ratingTo);
        }

        for (Restaurant r: list) {
            double avrRating = restaurantRatingDAO.getAverageRestaurantRatingByRestaurantId(r.getId());
            if (avrRating >= from && avrRating <= to){
                finalList.add(r);
            }
        }
        return finalList;
    }


    public List<byte[]> getSearchImages(List<Restaurant> restaurants){
        List<byte[]> searchImages = new ArrayList<>();

        for (Restaurant r: restaurants) {
            searchImages.add(r.getImage());
        }
        return searchImages;
    }

    public List<String> getAllLocations(){
        List<String> list = new ArrayList<>();
        list.add("<all locations>");
        list.addAll(locationDAO.getAllLocationNames());
        return list;
    }

    public List<String> getAllTypes(){
        List<String> list = new ArrayList<>();
        list.add("<all types>");
        list.addAll(restaurantTypeDAO.getAllRestaurantTypeNames());
        return list;
    }

    public List<String> getRatingListFrom(){
        List<String> list = new ArrayList<>();
        list.add("<rating from>");
        for (int i = 0; i<=5; i++){
            list.add(Integer.toString(i));
        }
        return list;
    }

    public List<String> getRatingListTo(){
        List<String> list = new ArrayList<>();
        list.add("<rating to>");
        for (int i = 0; i<=5; i++){
            list.add(Integer.toString(i));
        }
        return list;
    }

    public void setDefaultVariables(){
        restaurantSearchComponent.setSearchString("");
        restaurantSearchComponent.setSelectedLocation("<all locations>");
        restaurantSearchComponent.setSelectedType("<all types>");
        restaurantSearchComponent.setRatingFrom("<rating from>");
        restaurantSearchComponent.setRatingTo("<rating to>");
    }
}
