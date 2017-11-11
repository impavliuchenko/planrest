package com.planrest.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Restaurant implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String information;
    private String login;
    private String password;
    private String email;
    private byte[] image;
    private String address;
    private Collection<RestaurantRestaurantlocation> restaurantRestaurantlocationsById;
    private Collection<Restaurantrating> restaurantratingsById;
    private Collection<RestaurantRestauranttype> restaurantRestauranttypesById;
    private Collection<Restaurantwall> restaurantwallsById;
    private Collection<UserRestaurant> userRestaurantsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "information", nullable = true, length = 255)
    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Basic
    @Column(name = "login", nullable = false, length = 255)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "image", nullable = true)
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Basic
    @Column(name = "address", nullable = false)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Restaurant that = (Restaurant) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (information != null ? !information.equals(that.information) : that.information != null) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (!Arrays.equals(image, that.image)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (information != null ? information.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }

    @OneToMany(mappedBy = "restaurantId")
    public Collection<RestaurantRestaurantlocation> getRestaurantRestaurantlocationsById() {
        return restaurantRestaurantlocationsById;
    }

    public void setRestaurantRestaurantlocationsById(Collection<RestaurantRestaurantlocation> restaurantRestaurantlocationsById) {
        this.restaurantRestaurantlocationsById = restaurantRestaurantlocationsById;
    }

    @OneToMany(mappedBy = "restaurantId")
    public Collection<Restaurantrating> getRestaurantratingsById() {
        return restaurantratingsById;
    }

    public void setRestaurantratingsById(Collection<Restaurantrating> restaurantratingsById) {
        this.restaurantratingsById = restaurantratingsById;
    }

    @OneToMany(mappedBy = "restaurantId")
    public Collection<RestaurantRestauranttype> getRestaurantRestauranttypesById() {
        return restaurantRestauranttypesById;
    }

    public void setRestaurantRestauranttypesById(Collection<RestaurantRestauranttype> restaurantRestauranttypesById) {
        this.restaurantRestauranttypesById = restaurantRestauranttypesById;
    }

    @OneToMany(mappedBy = "restaurantId")
    public Collection<Restaurantwall> getRestaurantwallsById() {
        return restaurantwallsById;
    }

    public void setRestaurantwallsById(Collection<Restaurantwall> restaurantwallsById) {
        this.restaurantwallsById = restaurantwallsById;
    }

    @OneToMany(mappedBy = "restaurantId")
    public Collection<UserRestaurant> getUserRestaurantsById() {
        return userRestaurantsById;
    }

    public void setUserRestaurantsById(Collection<UserRestaurant> userRestaurantsById) {
        this.userRestaurantsById = userRestaurantsById;
    }
}
