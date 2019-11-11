package com.dzenansabanovicproject.model;

import javax.persistence.*;

@Entity
@Table(name="likes")
public class DAOLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name="user_id")
    @OneToOne(cascade = CascadeType.ALL)
    private DAOUser daoUser;

    @JoinColumn(name="sighting_id")
    @OneToOne(cascade = CascadeType.ALL)
    private DAOSighting daoSighting;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DAOUser getDaoUser() {
        return daoUser;
    }

    public void setDaoUser(DAOUser daoUser) {
        this.daoUser = daoUser;
    }

    public DAOSighting getDaoSighting() {
        return daoSighting;
    }

    public void setDaoSighting(DAOSighting daoSighting) {
        this.daoSighting = daoSighting;
    }
}
