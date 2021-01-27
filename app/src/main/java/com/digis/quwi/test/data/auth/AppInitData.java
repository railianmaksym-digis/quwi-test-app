package com.digis.quwi.test.data.auth;

import com.digis.quwi.test.domain.entities.User;

public class AppInitData {

    private final User user;

    public AppInitData(User user) {
        this.user = user;
    }


    public User getUser() {
        return user;
    }
}
