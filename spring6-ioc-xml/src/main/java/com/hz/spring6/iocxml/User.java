package com.hz.spring6.iocxml;

public class User {

    private String name;
    private Integer age;

    public void run() {
        System.out.println("run.....");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
