package com.dzenansabanovicproject.model;

public class LikeDTO {

    private long sighting_id;
    private long user_id;

    public long getSighting_id() {
        return sighting_id;
    }

    public void setSighting_id(long sighting_id) {
        this.sighting_id = sighting_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
}
