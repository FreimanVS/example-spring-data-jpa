package com.vfreiman.lessons.springdataexamples.builders;

import com.vfreiman.lessons.springdataexamples.entities.User;

public class UserBuilder {
    private long id;
    private String name;
    private String password;

    public UserBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public User build() {
        User user = new User();
        user.setName(this.name);
        user.setPassword(this.password);
        return user;
    }
}
