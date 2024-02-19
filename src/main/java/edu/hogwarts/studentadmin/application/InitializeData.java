package edu.hogwarts.studentadmin.application;

import edu.hogwarts.studentadmin.models.House;
import edu.hogwarts.studentadmin.repositories.HouseRepository;
import edu.hogwarts.studentadmin.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class InitializeData implements CommandLineRunner {


    private final HouseRepository houseRepository;
    private final StudentRepository studentRepository;

    public InitializeData(HouseRepository houseRepository, StudentRepository studentRepository) {
        this.houseRepository = houseRepository;
        this.studentRepository = studentRepository;
    }


    @Override
    public void run(String... args) throws Exception {



        House gryffindor = new House("Gryffindor", "Godric Gryffindor", Arrays.asList("Red", "Gold"));
        House hufflepuff = new House("Hufflepuff", "Helga Hufflepuff", Arrays.asList("Yellow", "Black"));
        House ravenclaw = new House("Ravenclaw", "Rowena Ravenclaw", Arrays.asList("Blue", "Bronze"));
        House slytherin = new House("Slytherin", "Salazar Slytherin", Arrays.asList("Green", "Silver"));

        houseRepository.save(gryffindor);
        houseRepository.save(hufflepuff);
        houseRepository.save(ravenclaw);
        houseRepository.save(slytherin);

    }
}
