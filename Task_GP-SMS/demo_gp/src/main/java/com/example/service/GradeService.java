package com.example.service;

import com.example.model.*;

public class GradeService {

    public void assignGrade(Student student, Course course, double score) {
        Grade grade = new Grade(course, score);
        student.addGrade(grade);
    }

    public double calculateAverageGrade(Student student) {
        if (student.getGrades().isEmpty()) return 0.0;
        double total = 0.0;
        for (Grade g : student.getGrades()) {
            total += g.getScore();
        }
        return total / student.getGrades().size();
    }
}