package com.besteco.models;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class GuestInstructor extends Instructor {

    private Double hourlySalary;

    public GuestInstructor() {
    }

    public GuestInstructor(Double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public GuestInstructor(String name, String phoneNumber, String email, Double hourlySalary) {
        super(name, phoneNumber, email);
        this.hourlySalary = hourlySalary;
    }

    public Double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(Double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    @Override
    public String toString() {
        return "GuestInstructor{" +
                "hourlySalary=" + hourlySalary +
                '}';
    }
}
