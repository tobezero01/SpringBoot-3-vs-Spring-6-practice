package com.luv2code.cruddemo;

public class Student {
    private Integer id;
    private String name;
    private float GPA;

    public Student() {
    }

    public Student(Integer id, String name, float GPA) {
        this.id = id;
        this.name = name;
        this.GPA = GPA;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getGPA() {
        return GPA;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
    }
}
