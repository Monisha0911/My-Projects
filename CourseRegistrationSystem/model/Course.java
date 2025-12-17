package com.crs.model;

public class Course {
    public int courseId;
    String courseName;

    public Course(int courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public void displayCourse() {
        System.out.println(courseId + " → " + courseName);
    }
}

