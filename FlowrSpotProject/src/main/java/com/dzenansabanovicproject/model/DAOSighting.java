package com.dzenansabanovicproject.model;

import javax.persistence.*;

@Entity
@Table(name="sighting")
public class DAOSighting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private long longitude;
    @Column
    private long latitude;
    @Column
    private String quote;

    @JoinColumn(name = "flower_id", unique = true)
    @OneToOne(cascade = CascadeType.ALL)
    private DaoFlower daoFlower;

    @JoinColumn(name="user_id")
    @OneToOne(cascade = CascadeType.ALL)
    private DAOUser daoUser;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public DaoFlower getDaoFlower() {
        return daoFlower;
    }

    public void setDaoFlower(DaoFlower daoFlower) {
        this.daoFlower = daoFlower;
    }

    public DAOUser getDaoUser() {
        return daoUser;
    }

    public void setDaoUser(DAOUser daoUser) {
        this.daoUser = daoUser;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
