package edu.hogwarts.studentadmin.controllers;

import edu.hogwarts.studentadmin.models.Teacher;
import edu.hogwarts.studentadmin.repositories.TeacherRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TeacherController {
    private final TeacherRepository teacherRepository;

    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @GetMapping("/teachers/{id}")
    public ResponseEntity<Teacher> getTeacher(@PathVariable int id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);

        return ResponseEntity.of(teacher);
    }

    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();


        return teachers;
    }

    @PostMapping("/teachers")
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @PutMapping("/teachers/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable int id, @RequestBody Teacher teacher) {
        Optional<Teacher> original = teacherRepository.findById(id);

        if (original.isPresent() && teacher != null) {

            Teacher updatedTeacher = teacherRepository.save(teacher);
            return ResponseEntity.ok().body(updatedTeacher);
        } else {

            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/teachers/{id}")
    public ResponseEntity<Teacher> patchTeacher(@PathVariable int id, @RequestBody Teacher teacher) {
        Optional<Teacher> original = teacherRepository.findById(id);
        if (original.isPresent() && teacher != null) {
            if (teacher.isHeadOfHouse() != null) {
                original.get().setHeadOfHouse(teacher.isHeadOfHouse());
            }
            if (teacher.getEmploymentEnd() != null) {
                original.get().setEmploymentEnd(teacher.getEmploymentEnd());
            }
            if (teacher.getEmployment() != null) {
                original.get().setEmployment(teacher.getEmployment());
            }
            Teacher updatedTeacher = teacherRepository.save(original.get());
            return ResponseEntity.ok().body(updatedTeacher);
        }
        return ResponseEntity.notFound().build();
        }

    @DeleteMapping("/teachers/{id}")
    public ResponseEntity<Teacher> deleteTeacher(@PathVariable int id) {
        Optional<Teacher> teacherToDelete = teacherRepository.findById(id);

        if (teacherToDelete.isPresent()) {
            teacherRepository.delete(teacherToDelete.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
