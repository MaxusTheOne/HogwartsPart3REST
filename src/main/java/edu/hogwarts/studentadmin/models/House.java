package edu.hogwarts.studentadmin.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Entity
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnoreProperties
    private int id;

    // this is the id, ignore above
    private String name;
    private String founder;

    private String color1;
    private String color2;

    public House(String name, String founder, List<String> colors) {
        this.name = name;
        this.founder = founder;
        this.color1 = colors.get(0);
        this.color2 = colors.get(1);
    }

    public House() {
    }

    public String getName() {
        return name;
    }

    public String getFounder() {
        return founder;
    }

    public List<String> getColors() {
        return Arrays.asList(color1, color2);
    }


}
