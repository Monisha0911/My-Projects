package com.crs.main;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.crs.exception.*;
import com.crs.model.*;

public class CourseRegistrationSystem {

    static Course findCourse(Course[] courses, int id)
            throws InvalidCourseException {

        for (Course c : courses) {
            if (c.courseId == id) {
                return c;
            }
        }
        throw new InvalidCourseException("❌ Course ID not found!");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Course[] courses = {
            new Course(101, "Java Programming"),
            new Course(102, "Python Programming"),
            new Course(103, "Web Development")
        };

        try {
            System.out.print("Enter Student ID: ");
            int sid = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Student Name: ");
            String sname = sc.nextLine();

            Student student = new Student(sid, sname);

            int choice = 0;

            do {
                System.out.println("\n====== COURSE REGISTRATION MENU ======");
                System.out.println("1. View Courses");
                System.out.println("2. Register Course");
                System.out.println("3. View Student Details");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                try {
                    choice = sc.nextInt();

                    switch (choice) {

                        case 1:
                            System.out.println("\n📚 Available Courses:");
                            for (Course course : courses) {
                                course.displayCourse();
                            }
                            break;

                        case 2:
                            System.out.print("Enter Course ID: ");
                            int cid = sc.nextInt();

                            Course selectedCourse =
                                findCourse(courses, cid);

                            student.registerCourse(selectedCourse);
                            break;

                        case 3:
                            student.displayDetails();
                            break;

                        case 4:
                            System.out.println("👋 Thank you for using the system!");
                            break;

                        default:
                            System.out.println("⚠ Please enter a valid option (1–4)");
                    }

                } catch (InputMismatchException e) {
                    System.out.println("❌ Invalid input! Numbers only.");
                    sc.nextLine(); // clear buffer
                } catch (InvalidCourseException | AlreadyRegisteredException e) {
                    System.out.println(e.getMessage());
                }

            } while (choice != 4);

        } catch (InputMismatchException e) {
            System.out.println("❌ Student ID must be a number!");
        }

        sc.close();
    }
}

