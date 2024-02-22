package edu.hogwarts.studentadmin.controllers;

import edu.hogwarts.studentadmin.models.Student;
import edu.hogwarts.studentadmin.models.Teacher;
import edu.hogwarts.studentadmin.repositories.CourseRepository;
import jakarta.persistence.Entity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.hogwarts.studentadmin.models.Course;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CourseController {

    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @GetMapping("/courses/{id}")
    public Course getCourse(@PathVariable int id) {
        return courseRepository.findById(id).orElse(null);
    }

    @GetMapping("/courses/{id}/students")
    public List<Student> getStudents(@PathVariable int id) {
        return Objects.requireNonNull(courseRepository.findById(id).orElse(null)).getStudents();
    }

    @GetMapping("/courses/{id}/teacher")
    public Teacher getTeacher(@PathVariable int id) {
        return Objects.requireNonNull(courseRepository.findById(id).orElse(null)).getTeacher();
    }

    @PostMapping("/courses")
    public Course createCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable int id, @RequestBody Course course) {
        Optional<Course> original = courseRepository.findById(id);

        if (original.isPresent() && course != null) {

            Course updatedCourse = courseRepository.save(course);
            return ResponseEntity.ok().body(updatedCourse);
        } else {

            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/courses/{id}/teacher")
    public ResponseEntity<Course> updateTeacher(@PathVariable int id, @RequestBody Teacher teacher) {
        Optional<Course> original = courseRepository.findById(id);

        if (original.isPresent() && teacher != null) {
            Course course = original.get();
            course.setTeacher(teacher);
            Course updatedCourse = courseRepository.save(course);
            return ResponseEntity.ok().body(updatedCourse);
        } else {

            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/courses/{id}/students")
    public ResponseEntity<Course> updateStudents(@PathVariable int id, @RequestBody List<Student> students) {
        Optional<Course> original = courseRepository.findById(id);

        if (original.isPresent() && students != null) {
            Course course = original.get();
            course.setStudents(students);
            Course updatedCourse = courseRepository.save(course);
            return ResponseEntity.ok().body(updatedCourse);
        } else {

            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Course> deleteCourse(@PathVariable int id) {
        Optional<Course> courseToDelete = courseRepository.findById(id);
        courseRepository.deleteById(id);
        return ResponseEntity.of(courseToDelete);
    }

    @DeleteMapping("/courses/{id}/teacher")
    public ResponseEntity<Course> deleteTeacher(@PathVariable int id) {
        Optional<Course> original = courseRepository.findById(id);

        if (original.isPresent()) {
            Course course = original.get();
            course.setTeacher(null);
            Course updatedCourse = courseRepository.save(course);
            return ResponseEntity.ok().body(updatedCourse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/courses/{id}/students")
    public ResponseEntity<Course> deleteStudents(@PathVariable int id) {
        Optional<Course> original = courseRepository.findById(id);

        if (original.isPresent()) {
            Course course = original.get();
            course.setStudents(null);
            Course updatedCourse = courseRepository.save(course);
            return ResponseEntity.ok().body(updatedCourse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
