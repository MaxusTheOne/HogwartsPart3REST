package edu.hogwarts.studentadmin.application;

import edu.hogwarts.studentadmin.controllers.TeacherController;
import edu.hogwarts.studentadmin.models.House;
import edu.hogwarts.studentadmin.models.Student;
import edu.hogwarts.studentadmin.models.Teacher;
import edu.hogwarts.studentadmin.models.EmploymentType;
import edu.hogwarts.studentadmin.repositories.HouseRepository;
import edu.hogwarts.studentadmin.repositories.StudentRepository;

import edu.hogwarts.studentadmin.repositories.TeacherRepository;
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
    private final TeacherRepository teacherRepository;


    public InitializeData(HouseRepository houseRepository, StudentRepository studentRepository,  TeacherRepository teacherRepository) {
        this.houseRepository = houseRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
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

    public void setTeacherData(){

        Teacher snape = new Teacher("Severus", "Prince", "Snape", LocalDate.of(1960, 1, 9), false, EmploymentType.TENURED, LocalDate.of(1981, 1, 1),null);
        Teacher mcGonagall = new Teacher("Minerva", "McGonagall", "McGonagall", LocalDate.of(1935, 10, 4), true, EmploymentType.TENURED, LocalDate.of(1956, 1, 1), LocalDate.of(2020, 6, 30));
        Teacher flitwick = new Teacher("Filius", "Flitwick", "Flitwick", LocalDate.of(1930, 10, 17), false, EmploymentType.TENURED, LocalDate.of(1958, 1, 1), null);

        teacherRepository.saveAll(List.of(snape, mcGonagall, flitwick));
    }


    @Override
    public void run(String... args) throws Exception {
        InitializeData data = new InitializeData(houseRepository, studentRepository, teacherRepository);
        data.initData();

    }


}
