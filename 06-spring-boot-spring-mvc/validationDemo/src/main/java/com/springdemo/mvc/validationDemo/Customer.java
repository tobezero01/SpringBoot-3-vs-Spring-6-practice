package com.springdemo.mvc.validationDemo;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Customer {

    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName ="";

    @Min(value = 0 , message = " freePasses >= 0")
    @Max(value = 10, message = " freePasses <= 10")
    private int freePasses;

    public Customer(){}

    public Customer(String firstName, String lastName, int freePasses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.freePasses = freePasses;
    }

    public int getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(int freePasses) {
        this.freePasses = freePasses;
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
        return "Customer : " +
                "firstName='" + firstName + '\'' + "\n" +
                ", lastName='" + lastName + '\'' +"\n" +
                ", freePasses=" + freePasses
                ;
    }
}
