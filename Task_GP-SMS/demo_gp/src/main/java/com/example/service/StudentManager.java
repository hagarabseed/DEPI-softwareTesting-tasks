package com.example.service;

import com.example.exception.*;
import com.example.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentManager implements SystemOperations {
    private final List<Student> students = new ArrayList<>();
    private final List<Course> courses = new ArrayList<>();

    @Override
    public void addStudent(Student student) throws DuplicateEntityException {
        if (existsStudent(student.getId())) {
            throw new DuplicateEntityException("Student with ID '" + student.getId() + "' already exists.");
        }
        students.add(student);
    }

    @Override
    public void updateStudent(String id, String name, String email) throws EntityNotFoundException {
        Student student = findStudentById(id);
        student.setName(name);
        student.setEmail(email);
    }

    @Override
    public void deleteStudent(String id) throws EntityNotFoundException {
        Student student = findStudentById(id);
        students.remove(student);
    }

    @Override
    public void addCourse(Course course) throws DuplicateEntityException {
        if (existsCourse(course.getCourseCode())) {
            throw new DuplicateEntityException("Course with Code '" + course.getCourseCode() + "' already exists.");
        }
        courses.add(course);
    }

    @Override
    public Student findStudentById(String id) throws EntityNotFoundException {
        return students.stream()
                .filter(s -> s.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Student with ID '" + id + "' not found."));
    }

    @Override
    public Course findCourseById(String code) throws EntityNotFoundException {
        return courses.stream()
                .filter(c -> c.getCourseCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Course with Code '" + code + "' not found."));
    }

    @Override
    public List<Student> getAllStudents() {
        return Collections.unmodifiableList(students);
    }

    @Override
    public List<Course> getAllCourses() {
        return Collections.unmodifiableList(courses);
    }

    private boolean existsStudent(String id) {
        return students.stream().anyMatch(s -> s.getId().equalsIgnoreCase(id));
    }

    private boolean existsCourse(String code) {
        return courses.stream().anyMatch(c -> c.getCourseCode().equalsIgnoreCase(code));
    }
}