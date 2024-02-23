package edu.hogwarts.studentadmin.application;

import edu.hogwarts.studentadmin.models.House;
import edu.hogwarts.studentadmin.repositories.HouseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class InitializeData implements CommandLineRunner {


    private final HouseRepository houseRepository;

    public InitializeData(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    public void initData() {
        House gryffindor = new House("Gryffindor", "Godric Gryffindor", Arrays.asList("Red", "Gold"));
        House hufflepuff = new House("Hufflepuff", "Helga Hufflepuff", Arrays.asList("Yellow", "Black"));
        House ravenclaw = new House("Ravenclaw", "Rowena Ravenclaw", Arrays.asList("Blue", "Bronze"));
        House slytherin = new House("Slytherin", "Salazar Slytherin", Arrays.asList("Green", "Silver"));



        houseRepository.saveAll(List.of(gryffindor, hufflepuff, ravenclaw, slytherin));
    }


    @Override
    public void run(String... args) throws Exception {
        InitializeData data = new InitializeData(houseRepository);
        data.initData();

    }

    private House gryffindor;
    private House hufflepuff;
    private House ravenclaw;
    private House slytherin;


}
