package com.jokxker.spring.introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("personBean")
public class Person {
    @Autowired
    @Qualifier("catBean")
    private Pet pet;
    @Value("${person.name}")
    private String name;
    @Value("${person.age}")
    private int age;

    public Person() {

    }

//    @Autowired
    public Person(Pet pet) {
        this.pet = pet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    @Autowired
    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void callYourPet() {
        System.out.println("Hi my lovely pet");
        pet.say();
    }
}
