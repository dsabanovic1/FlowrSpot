package com.dzenansabanovicproject.model;

import javax.persistence.*;

@Entity
@Table(name= "flower")
public class DaoFlower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String description;
    @Column
    private String name;
    @Column
    private String url;
    @JoinColumn(name="user_id")
    @OneToOne(cascade = CascadeType.ALL)
    private DAOUser daoUser;

    public DAOUser getDaoUser() {
        return daoUser;
    }

    public void setDaoUser(DAOUser daoUser) {
        this.daoUser = daoUser;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
