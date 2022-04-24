package com.codeup.keglisterspring.models;

import javax.persistence.*;

@Entity
@Table(name = "breweries")
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private long userId;
    @Column(nullable = false, unique = true)
    private String name;
    @Column
    private String address;
    @Column
    private String website;
    @Column
    private String phone;
    @Column
    private String image;
    @Column
    private String type;

    @OneToOne
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Ad() {
    }

    public Ad(long id, long userId, String name, String address, String website, String phone, String image, String type) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.address = address;
        this.website = website;
        this.phone = phone;
        this.image = image;
        this.type = type;
    }

    public Ad(long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Ad(long id, long userId, String name, String address) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.address = address;
    }

    public Ad(long userId, String name, String address, String website, String phone, String image, String type) {
        this.userId = userId;
        this.name = name;
        this.address = address;
        this.website = website;
        this.phone = phone;
        this.image = image;
        this.type = type;
    }

    public Ad(long id, long userId, String name, String address, String website, String phone, String image, String type, User user) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.address = address;
        this.website = website;
        this.phone = phone;
        this.image = image;
        this.type = type;
        this.user = user;
    }
}
