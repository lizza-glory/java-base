package com.lizza.HashCode;

import com.google.common.base.Objects;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2022-01-12
 */
public class User_2 {
    private int id;
    private String name;

    public User_2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User_2 user_2 = (User_2) o;
        return id == user_2.id &&
                Objects.equal(name, user_2.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name);
    }
}
