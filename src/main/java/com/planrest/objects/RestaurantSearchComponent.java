package com.planrest.objects;

import com.planrest.entities.Restaurant;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class RestaurantSearchComponent implements Serializable {
    private static final long serialVersionUID = 1L;

    private String searchString;
    private List <byte[]> searchImages;
    private String selectedLocation;
    private String selectedType;
    private String ratingFrom;
    private String ratingTo;
    private Restaurant restaurant;

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

    public String getSelectedType() {
        return selectedType;
    }

    public void setSelectedType(String selectedType) {
        this.selectedType = selectedType;
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

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
