package com.example.service;

import com.example.exception.*;
import com.example.model.*;
import java.util.List;

public interface SystemOperations {
    void addStudent(Student student) throws DuplicateEntityException;
    void updateStudent(String id, String name, String email) throws EntityNotFoundException;
    void deleteStudent(String id) throws EntityNotFoundException;
    
    void addCourse(Course course) throws DuplicateEntityException;
    
    Student findStudentById(String id) throws EntityNotFoundException;
    Course findCourseById(String code) throws EntityNotFoundException;
    
    List<Student> getAllStudents();
    List<Course> getAllCourses();
}