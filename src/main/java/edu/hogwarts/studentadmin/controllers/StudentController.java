package edu.hogwarts.studentadmin.controllers;

import edu.hogwarts.studentadmin.models.Student;
import edu.hogwarts.studentadmin.repositories.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id) {
        Optional<Student> student = studentRepository.findById(id);

        return ResponseEntity.of(student);
    }

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
        Optional<Student> original = studentRepository.findById(id);
        if (original.isPresent() && student != null) {

            Student updatedStudent = studentRepository.save(student);
            return ResponseEntity.ok().body(updatedStudent);
        } else {

            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/students/{id}")
    public ResponseEntity<Student> patchStudent(@PathVariable int id, @RequestBody Student student) {
        Optional<Student> original = studentRepository.findById(id);
        if (original.isPresent() && student != null) {
            if (student.isPrefect() != null) {
                original.get().setPrefect(student.isPrefect());
            }
            if (student.getSchoolYear() != null) {
                original.get().setSchoolYear(student.getSchoolYear());
            }
            if (student.getGraduationYear() != null) {
                original.get().setGraduationYear(student.getGraduationYear());
            }
            // Graduated is already calculated automatically, so we don't need to update it. Suck it.
            Student updatedStudent = studentRepository.save(original.get());
            return ResponseEntity.ok().body(updatedStudent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable int id) {
        Optional<Student> studentToDelete = studentRepository.findById(id);
        return ResponseEntity.of(studentToDelete);
    }


}
