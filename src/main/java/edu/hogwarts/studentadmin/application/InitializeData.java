package edu.hogwarts.studentadmin.application;

import edu.hogwarts.studentadmin.models.House;
import org.springframework.boot.CommandLineRunner;

import java.util.Arrays;
import java.util.List;

public class InitializeData implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        House gryffindor = new House("Gryffindor", "Godric Gryffindor", Arrays.asList("Red", "Gold"));
        House hufflepuff = new House("Hufflepuff", "Helga Hufflepuff", Arrays.asList("Yellow", "Black"));
    }
}
