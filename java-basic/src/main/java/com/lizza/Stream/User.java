package com.lizza.Stream;

import lombok.Builder;

import java.time.ZoneId;
import java.util.Date;

@Builder
public class User {

    String name;

    Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() +
                '}';
    }
}
