package com.planrest.services;

import com.planrest.dao.interfaces.LocationDAO;
import com.planrest.dao.interfaces.UserRatingDAO;

import com.planrest.entities.User;
import com.planrest.objects.UserSearchComponent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserSearchService {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private UserSearchComponent userSearchComponent;

    @Autowired
    private LocationDAO locationDAO;

    @Autowired
    private UserRatingDAO userRatingDAO;



    @Transactional
    public List<Double> getAverageUserRating(List<User> users){
        List<Double> averageRatings = new ArrayList<>();

        for (User u: users) {
            averageRatings.add(userRatingDAO.getAverageRatingByUserId(u.getId()));
        }

        return averageRatings;
    }

    @Transactional
    public List<User> searchUsers(String name, String location, String ratingFrom, String ratingTo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session
                .createQuery("SELECT u FROM User u " +
                        "WHERE u.name LIKE :name " +
                        "AND u.locationId.locationName LIKE :locationName ");

        query.setParameter("name", "%" + name + "%");
        if (location.equals("<all locations>")) {
            query.setParameter("locationName", "%%");
        } else {
            query.setParameter("locationName", location);
        }

        double from = 0.0;
        double to = 5.0;

        List<User> list = (List<User>) query.list();
        List<User> finalList = new ArrayList<>();

        if (!ratingFrom.equals("<rating from>")){
            from = Double.parseDouble(ratingFrom);
        }

        if (!ratingTo.equals("<rating to>")){
            to = Double.parseDouble(ratingTo);
        }

        for (User u: list) {
            Query innerQuery = session
                    .createQuery("SELECT AVG(ur.rating) FROM Userrating ur INNER JOIN ur.userReceivingId r " +
                            "WHERE r.id = :id GROUP BY r.id");
            innerQuery.setParameter("id", u.getId());
            double avrRating = (double) innerQuery.uniqueResult();
            if (avrRating >= from && avrRating <= to){
                finalList.add(u);
            }
        }
        return finalList;
    }


    public List<byte[]> getSearchImages(List<User> users){
        List<byte[]> searchImages = new ArrayList<>();

        for (User u: users) {
            searchImages.add(u.getImage());
        }

        return searchImages;
    }

    public List<String> getAllLocations(){
        List<String> list = new ArrayList<>();
        list.add("<all locations>");
        list.addAll(locationDAO.getAllLocationNames());
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
        userSearchComponent.setSearchString("");
        userSearchComponent.setSelectedLocation("<all locations>");
        userSearchComponent.setRatingFrom("<rating from>");
        userSearchComponent.setRatingTo("<rating to>");
    }
}
