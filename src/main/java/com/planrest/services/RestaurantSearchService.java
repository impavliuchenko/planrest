package com.planrest.services;

import com.planrest.dao.impl.RestaurantLocationDAOImpl;
import com.planrest.dao.interfaces.RestaurantLocationDAO;
import com.planrest.dao.interfaces.RestaurantRatingDAO;
import com.planrest.dao.interfaces.RestaurantTypeDAO;
import com.planrest.entities.Restaurant;
import com.planrest.entities.Restaurantlocation;
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
    private RestaurantLocationDAO restaurantLocationDAO;

    @Autowired
    private RestaurantTypeDAO restaurantTypeDAO;

    @Autowired
    private RestaurantRatingDAO restaurantRatingDAO;

    @Transactional
    public List<Restauranttype> getTypesByRestaurants(List<Restaurant> restaurants){
        List<Restauranttype> restaurantTypes = new ArrayList<>();

        for (Restaurant r: restaurants) {
            Query query = sessionFactory.getCurrentSession()
                    .createQuery("SELECT rt FROM RestaurantRestauranttype rrt " +
                            "INNER JOIN rrt.restaurantTypeId rt " +
                            "INNER JOIN rrt.restaurantId r " +
                            "WHERE r.id = :id");
            query.setParameter("id", r.getId());

            restaurantTypes.add((Restauranttype) query.uniqueResult());
        }

        return restaurantTypes;
    }

    @Transactional
    public List<Restaurantlocation> getLocationsByRestaurants(List<Restaurant> restaurants){
        List<Restaurantlocation> restaurantTypes = new ArrayList<>();

        for (Restaurant r: restaurants) {
            Query query = sessionFactory.getCurrentSession()
                    .createQuery("SELECT rl FROM RestaurantRestaurantlocation rrl " +
                            "INNER JOIN rrl.restaurantLocationId rl " +
                            "INNER JOIN rrl.restaurantId r " +
                            "WHERE r.id = :id");
            query.setParameter("id", r.getId());

            restaurantTypes.add((Restaurantlocation) query.uniqueResult());
        }

        return restaurantTypes;
    }

    @Transactional
    public List<Double> getAverageRestaurantRating(List<Restaurant> restaurants){
        List<Double> averageRatings = new ArrayList<>();

        for (Restaurant r: restaurants) {
            Query query = sessionFactory.getCurrentSession()
                    .createQuery("SELECT AVG(rr.rating) FROM Restaurantrating rr INNER JOIN rr.restaurantId r " +
                            "WHERE r.id = :id GROUP BY r.id");
            query.setParameter("id", r.getId());

            averageRatings.add((double) query.uniqueResult());
        }

        return averageRatings;
    }

    @Transactional
    public List<Restaurant> searchRestaurantsByName(String name, String location, String type, String ratingFrom, String ratingTo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session
                .createQuery("SELECT r FROM Restaurant r " +
                        "INNER JOIN RestaurantRestaurantlocation rrl ON r.id = rrl.restaurantId.id " +
                        "INNER JOIN Restaurantlocation rl ON rrl.restaurantLocationId.id = rl.id " +
                        "INNER JOIN RestaurantRestauranttype rrt ON r.id = rrt.restaurantId.id " +
                        "INNER JOIN Restauranttype rt ON rrt.restaurantTypeId.id = rt.id " +
                        "WHERE r.name LIKE :name " +
                        "AND rl.locationName LIKE :locationName " +
                        "AND rt.typeName LIKE :typeName ");

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
            Query innerQuery = session
                    .createQuery("SELECT AVG(rr.rating) FROM Restaurantrating rr INNER JOIN rr.restaurantId r " +
                            "WHERE r.id = :id GROUP BY r.id");
            innerQuery.setParameter("id", r.getId());
            double avrRating = (double) innerQuery.uniqueResult();
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
        list.addAll(restaurantLocationDAO.getAllRestaurantLocations());
        return list;
    }

    public List<String> getAllTypes(){
        List<String> list = new ArrayList<>();
        list.add("<all types>");
        list.addAll(restaurantTypeDAO.getAllRestaurantTypes());
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
