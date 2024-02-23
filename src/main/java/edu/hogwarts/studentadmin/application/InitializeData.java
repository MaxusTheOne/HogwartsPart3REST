package edu.hogwarts.studentadmin.application;

import edu.hogwarts.studentadmin.models.House;
import edu.hogwarts.studentadmin.models.Student;
import edu.hogwarts.studentadmin.repositories.HouseRepository;
import edu.hogwarts.studentadmin.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class InitializeData implements CommandLineRunner {


    private final HouseRepository houseRepository;
    private final StudentRepository studentRepository;


    public InitializeData(HouseRepository houseRepository, StudentRepository studentRepository) {
        this.houseRepository = houseRepository;
        this.studentRepository = studentRepository;
    }

    public void initData() {
        House gryffindor = new House("Gryffindor", "Godric Gryffindor", Arrays.asList("Red", "Gold"));
        House hufflepuff = new House("Hufflepuff", "Helga Hufflepuff", Arrays.asList("Yellow", "Black"));
        House ravenclaw = new House("Ravenclaw", "Rowena Ravenclaw", Arrays.asList("Blue", "Bronze"));
        House slytherin = new House("Slytherin", "Salazar Slytherin", Arrays.asList("Green", "Silver"));

        houseRepository.saveAll(List.of(gryffindor, hufflepuff, ravenclaw, slytherin));
        setStudentData();

    }

    public void setStudentData(){

        Student harry = new Student("Harry", "James", "Potter", houseRepository.findByName("Gryffindor").get(0),1980, null);

        studentRepository.save(harry);
    }


    @Override
    public void run(String... args) throws Exception {
        InitializeData data = new InitializeData(houseRepository, studentRepository);
        data.initData();

    }


}
