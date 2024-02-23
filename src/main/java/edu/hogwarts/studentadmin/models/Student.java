package edu.hogwarts.studentadmin.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.Optional;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnoreProperties
    private int id;

    private String firstName;
    private String middleName;
    private String lastName;


    @ManyToOne
    @JoinColumn(name = "house")
    private House house;
    private int schoolYear;
    private Integer graduationYear;



    public Student(String firstName, String middleName, String lastName, House house, int schoolYear, Integer graduationYear) {
        this.id = 0;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.house = house;
        this.schoolYear = schoolYear;
        this.graduationYear = graduationYear;


    }

    public Student(String fullName, House house, int schoolYear, Integer graduationYear) {
        String[] names = fullName.split(" ");
        this.id = 0;
        this.firstName = names[0];
        this.middleName = names.length > 2 ? names[1] : "";
        this.lastName = names[names.length - 1];
        this.house = house;
        this.schoolYear = schoolYear;
        this.graduationYear = graduationYear;

    }

    public Student() {
    }

    public Integer getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(Integer graduationYear) {
        this.graduationYear = graduationYear;
    }

    public boolean isGraduated() {
        return graduationYear != null;
    }

    public String getHouse() {

        return house.getName();
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(int schoolYear) {
        this.schoolYear = schoolYear;
    }
}
