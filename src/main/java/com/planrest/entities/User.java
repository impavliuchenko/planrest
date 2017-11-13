package com.planrest.entities;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String login;
    private String password;
    private String email;
    private String sex;
    private Date birthday;
    private byte[] image;
    private Collection<Dialogue> dialoguesById;
    private Collection<Friend> usersByUserId;
    private Collection<Friend> usersByFriendId;
    private Collection<Restaurantrating> restaurantratingsById;
    private Collection<UserDialogue> userDialoguesById;
    private Collection<UserRestaurant> userRestaurantsById;
    private Collection<UserRole> userRolesById;
    private Collection<UserUserlocation> userUserlocationsById;
    private Collection<Userrating> userratingsById;
    private Collection<Userrating> userratingsById_0;
    private Collection<Userwall> userwallsById;
    private Collection<RestaurantwallUser> restaurantwallUsersById;

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
    @Column(name = "email", nullable = true, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "sex", nullable = false, length = 255)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "birthday", nullable = true)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "image", nullable = true)
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (sex != null ? !sex.equals(user.sex) : user.sex != null) return false;
        if (birthday != null ? !birthday.equals(user.birthday) : user.birthday != null) return false;
        if (!Arrays.equals(image, user.image)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }

    @OneToMany(mappedBy = "userCompanionId")
    public Collection<Dialogue> getDialoguesById() {
        return dialoguesById;
    }

    public void setDialoguesById(Collection<Dialogue> dialoguesById) {
        this.dialoguesById = dialoguesById;
    }

    @OneToMany(mappedBy = "userId")
    public Collection<Friend> getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(Collection<Friend> friendsById) {
        this.usersByUserId = friendsById;
    }

    @OneToMany(mappedBy = "friendId")
    public Collection<Friend> getUsersByFriendId() {
        return usersByFriendId;
    }

    public void setUsersByFriendId(Collection<Friend> friendsById_0) {
        this.usersByFriendId = friendsById_0;
    }

    @OneToMany(mappedBy = "userId")
    public Collection<Restaurantrating> getRestaurantratingsById() {
        return restaurantratingsById;
    }

    public void setRestaurantratingsById(Collection<Restaurantrating> restaurantratingsById) {
        this.restaurantratingsById = restaurantratingsById;
    }

    @OneToMany(mappedBy = "userId")
    public Collection<UserDialogue> getUserDialoguesById() {
        return userDialoguesById;
    }

    public void setUserDialoguesById(Collection<UserDialogue> userDialoguesById) {
        this.userDialoguesById = userDialoguesById;
    }

    @OneToMany(mappedBy = "userId")
    public Collection<UserRestaurant> getUserRestaurantsById() {
        return userRestaurantsById;
    }

    public void setUserRestaurantsById(Collection<UserRestaurant> userRestaurantsById) {
        this.userRestaurantsById = userRestaurantsById;
    }

    @OneToMany(mappedBy = "userId")
    public Collection<UserRole> getUserRolesById() {
        return userRolesById;
    }

    public void setUserRolesById(Collection<UserRole> userRolesById) {
        this.userRolesById = userRolesById;
    }

    @OneToMany(mappedBy = "userId")
    public Collection<UserUserlocation> getUserUserlocationsById() {
        return userUserlocationsById;
    }

    public void setUserUserlocationsById(Collection<UserUserlocation> userUserlocationsById) {
        this.userUserlocationsById = userUserlocationsById;
    }

    @OneToMany(mappedBy = "userReceivingId")
    public Collection<Userrating> getUserratingsById() {
        return userratingsById;
    }

    public void setUserratingsById(Collection<Userrating> userratingsById) {
        this.userratingsById = userratingsById;
    }

    @OneToMany(mappedBy = "userSendingId")
    public Collection<Userrating> getUserratingsById_0() {
        return userratingsById_0;
    }

    public void setUserratingsById_0(Collection<Userrating> userratingsById_0) {
        this.userratingsById_0 = userratingsById_0;
    }

    @OneToMany(mappedBy = "userId")
    @LazyCollection(LazyCollectionOption.FALSE)
    public Collection<Userwall> getUserwallsById() {
        return userwallsById;
    }

    public void setUserwallsById(Collection<Userwall> userwallsById) {
        this.userwallsById = userwallsById;
    }

    @OneToMany(mappedBy = "userId")
    public Collection<RestaurantwallUser> getRestaurantwallUsersById() {
        return restaurantwallUsersById;
    }

    public void setRestaurantwallUsersById(Collection<RestaurantwallUser> restaurantwallUsersById) {
        this.restaurantwallUsersById = restaurantwallUsersById;
    }
}
