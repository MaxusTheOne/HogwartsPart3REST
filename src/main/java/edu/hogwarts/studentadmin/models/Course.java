package edu.hogwarts.studentadmin.models;

import jakarta.persistence.*;

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String subject;
    private int schoolYear;
    private boolean current;

    @OneToOne
    private Teacher teacher;

    @ManyToOne
    private Student[] students;
}
