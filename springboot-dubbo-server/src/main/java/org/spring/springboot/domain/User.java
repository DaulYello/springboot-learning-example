package org.spring.springboot.domain;

import java.io.Serializable;

/**
 * 用户实体类
 *
 * created by hs on 15/01/2018
 */
public class User implements Serializable {

    private static final long serialVersionUID = -1L;

    private long id;

    private String name;

    private long age;

    public User(){}

    public User(long id,String name,long age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }
}
