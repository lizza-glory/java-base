package com.lizza.Map.HashMap;

import java.util.*;

/**
 * @Desc: map中存储list
 * @author: lizza1643@gmail.com
 * @date: 2019-09-06
 */
public class MapList {

    public static void main(String[] args){
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User(i, "user_"+i);
            list.add(user);
            if(i%2!=0){
                list.add(user);
            }
        }
        System.out.println(list);
        Map<Integer, List<User>> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            Integer code = list.get(i).getCode();
            List<User> _list = map.get(code);
            if (_list == null) {
                _list = new ArrayList<>();
            }
            _list.add(list.get(i));
            map.put(code, _list);
        }
        System.out.println(map);
    }
}
class User{
    private Integer code;
    private String name;

    public User() {
    }

    public User(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }
}