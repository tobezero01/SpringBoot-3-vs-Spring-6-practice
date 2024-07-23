package com.luv2code.springboot.thymeleafdemo.model;

public class Student {

    private String firstName;

    private String lastName ;

    private String country;

    private String favLanguage;
    public Student() {
    }

    public Student(String firstName, String lastName, String country, String favLanguage) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.favLanguage = favLanguage;
    }

    public String getFavLanguage() {
        return favLanguage;
    }

    public void setFavLanguage(String favLanguage) {
        this.favLanguage = favLanguage;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", favLanguage='" + favLanguage + '\'' +
                '}';
    }
}
