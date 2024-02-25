package edu.hogwarts.studentadmin.models;

import jakarta.persistence.*;


import java.time.LocalDate;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate dateOfBirth;

    @ManyToOne
    private House house;
    private Boolean headOfHouse;

    @Enumerated(EnumType.STRING)
    private EmploymentType employment;
    private LocalDate employmentStart;
    private LocalDate employmentEnd;


    public Teacher(String firstName, String middleName, String lastName, LocalDate dateOfBirth,
                   boolean headOfHouse, EmploymentType employment, LocalDate employmentStart, LocalDate employmentEnd) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.headOfHouse = headOfHouse;
        this.employment = employment;
        this.employmentStart = employmentStart;
        this.employmentEnd = employmentEnd;
    }
    // example of a teacher JSON object
    // {"firstName":"Minerva","middleName":"McGonagall","lastName":"McGonagall","dateOfBirth":"1935-10-04","headOfHouse":true,"employmentType":"FULL_TIME","employmentStart":"1956-01-01","employmentEnd":"2020-06-30"}

    public Teacher() {
    }

    public Teacher(String firstName){
        this.firstName = firstName;
    }

    public Teacher(Teacher otherTeacher) {
        this.id = otherTeacher.getId();
        this.firstName = otherTeacher.getFirstName();
        this.middleName = otherTeacher.getMiddleName();
        this.lastName = otherTeacher.getLastName();
        this.dateOfBirth = otherTeacher.getDateOfBirth();
        this.headOfHouse = otherTeacher.isHeadOfHouse();
        this.employment = otherTeacher.getEmployment();
        this.employmentStart = otherTeacher.getEmploymentStart();
        this.employmentEnd = otherTeacher.getEmploymentEnd();
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean isHeadOfHouse() {
        return headOfHouse;
    }

    public void setHeadOfHouse(Boolean headOfHouse) {
        this.headOfHouse = headOfHouse;
    }

    public EmploymentType getEmployment() {
        return employment;
    }

    public void setEmployment(EmploymentType employmentType) {
        this.employment = employmentType;
    }

    public LocalDate getEmploymentStart() {
        return employmentStart;
    }

    public void setEmploymentStart(LocalDate employmentStart) {
        this.employmentStart = employmentStart;
    }

    public LocalDate getEmploymentEnd() {
        return employmentEnd;
    }

    public void setEmploymentEnd(LocalDate employmentEnd) {
        this.employmentEnd = employmentEnd;
    }
}
