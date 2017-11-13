package com.planrest.objects;

import com.planrest.entities.User;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class UserSearchComponent implements Serializable{

    private static final long serialVersionUID = 1L;

    private String searchString;
    private List<byte[]> searchImages;
    private String selectedLocation;
    private String ratingFrom;
    private String ratingTo;
    private User user;


    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public List<byte[]> getSearchImages() {
        return searchImages;
    }

    public void setSearchImages(List<byte[]> searchImages) {
        this.searchImages = searchImages;
    }

    public String getSelectedLocation() {
        return selectedLocation;
    }

    public void setSelectedLocation(String selectedLocation) {
        this.selectedLocation = selectedLocation;
    }

    public String getRatingFrom() {
        return ratingFrom;
    }

    public void setRatingFrom(String ratingFrom) {
        this.ratingFrom = ratingFrom;
    }

    public String getRatingTo() {
        return ratingTo;
    }

    public void setRatingTo(String ratingTo) {
        this.ratingTo = ratingTo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
