package com.example.lostpets;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

enum Status {LOST, FOUND}

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @NotEmpty
    @Size(min=2, max=16, message="Enter a 2 to 16 charachters name.")
    private String name;

    @NotNull
    @Digits(integer=3, fraction=0)
    @Min(1)
    @Max(500)
    private String age;

    @NotNull
    @NotEmpty
    @Size(min=2, max=25, message="Enter a 2 to 25 charachter type.")
    private String type;


    private String breed;

    @NotNull
    @NotEmpty(message="You have to enter the pet color.")
    private String color;

    private String features;

    @NotNull
    @NotEmpty
    @Digits(integer=10, fraction=0)
    private String phone;

    private  Status currentStatus;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Status getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(Status currentStatus) {
        this.currentStatus = currentStatus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

 }
