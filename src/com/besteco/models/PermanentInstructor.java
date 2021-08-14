package com.besteco.models;

import javax.persistence.Entity;

@Entity
public class PermanentInstructor extends Instructor{

    private Double fixedSalary;

    public PermanentInstructor() {
    }

    public PermanentInstructor(Double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public PermanentInstructor(String name, String phoneNumber, String email) {
        super(name, phoneNumber, email);
    }

    public Double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(Double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    @Override
    public String toString() {
        return "PermanentInstructor{" +
                "fixedSalary=" + fixedSalary +
                '}';
    }
}
