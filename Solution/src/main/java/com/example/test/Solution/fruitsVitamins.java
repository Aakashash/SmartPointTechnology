package com.example.test.Solution;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "fruitsvitamins")
public class fruitsVitamins {
    public fruitsVitamins(String fruits, String vitamins) {
        this.fruits = fruits;
        this.vitamins = vitamins;
    }
    public fruitsVitamins(){}

    @Id
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String fruits;
    private String vitamins;

    public String getFruits() {
        return fruits;
    }

    public void setFruits(String fruits) {
        this.fruits = fruits;
    }

    public String getVitamins() {
        return vitamins;
    }

    public void setVitamins(String vitamins) {
        this.vitamins = vitamins;
    }

    @Override
    public String toString() {
        return "fruitsVitamins{" +
                "fruits='" + fruits + '\'' +
                ", vitamins='" + vitamins + '\'' +
                '}';
    }
}
