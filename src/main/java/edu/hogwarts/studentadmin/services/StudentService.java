package edu.hogwarts.studentadmin.services;


import edu.hogwarts.studentadmin.dtos.StudentDTO;
import edu.hogwarts.studentadmin.models.Student;
import edu.hogwarts.studentadmin.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Optional<Student> findById(int id) {
        return studentRepository.findById(id);
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Optional<Student> deleteById(int id) {
        Optional<Student> studentToDelete = studentRepository.findById(id);
        studentRepository.deleteById(id);
        return studentToDelete;
    }

    public boolean  sameYearAsCourse(List<Student> students, int courseId) {

        int courseYear = Objects.requireNonNull(studentRepository.findById(courseId).orElse(null)).getSchoolYear();
        for (Student student : students) {
            if (student.getSchoolYear() != courseYear) {
                return false;
            }
        }
        return true;
    }



}
