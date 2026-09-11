package com.example.model;

public class Grade {
    private Course course;
    private double score;

    public Grade(Course course, double score) {
        this.course = course;
        this.score = score;
    }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }

    public double getScore() { return score; }
    public void setScore(double score) { this.score = score; }

    @Override
    public String toString() {
        return String.format("%s: %.2f", course.getCourseName(), score);
    }
}