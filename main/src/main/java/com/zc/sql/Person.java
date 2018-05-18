package com.zc.sql;

import android.content.ContentValues;

public class Person {

    private String name;
    private String sex;
    private int age;

    public Person(){
    }

    public Person(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCV(ContentValues cv){
        cv.put("_name",name);
        cv.put("_age",age);
        cv.put("_sex",sex);
    }
}
