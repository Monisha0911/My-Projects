package com.crs.model;

import com.crs.exception.AlreadyRegisteredException;

public class Student {
    int studentId;
    String studentName;
    Course registeredCourse;

    public Student(int studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public void registerCourse(Course course) throws AlreadyRegisteredException {
        if (registeredCourse != null) {
            throw new AlreadyRegisteredException(
                "⚠ You have already registered for a course!"
            );
        }
        registeredCourse = course;
        System.out.println("✅ Course registered successfully!");
    }

    public void displayDetails() {
        System.out.println("\n📘 Student Details");
        System.out.println("ID   : " + studentId);
        System.out.println("Name : " + studentName);

        if (registeredCourse != null) {
            System.out.println("Course: " + registeredCourse.courseName);
        } else {
            System.out.println("Course: Not registered yet");
        }
    }
}

