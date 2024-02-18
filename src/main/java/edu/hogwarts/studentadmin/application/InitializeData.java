package edu.hogwarts.studentadmin.application;

import edu.hogwarts.studentadmin.models.House;
import org.springframework.boot.CommandLineRunner;

public class InitializeData implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        House gryffindor = new House("Gryffindor", "Godric Gryffindor", new String[]{"Red", "Gold"});
        House hufflepuff = new House("Hufflepuff", "Helga Hufflepuff", new String[]{"Yellow", "Black"});
    }
}
