/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Person;

import java.util.Date;
import java.util.Scanner;

public class Processor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentList studentList = new StudentList();

        while (true) {
            System.out.println("1. Add a new student");
            System.out.println("2. Delete a student by ID");
            System.out.println("3. Display all students");
            System.out.println("4. Find student by ID");
            System.out.println("5. Find top student");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Full Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Date of Birth (yyyy-MM-dd): ");
                    String dobStr = scanner.nextLine();
                    Date dob = java.sql.Date.valueOf(dobStr); // Simple parsing
                    System.out.print("Enter GPA: ");
                    float gpa = scanner.nextFloat();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Major: ");
                    String major = scanner.nextLine();
                    
                    Student student = new Student(id, name, dob, gpa, major);
                    studentList.addStudent(student);
                    break;

                case 2:
                    System.out.print("Enter ID to delete: ");
                    String deleteId = scanner.nextLine();
                    studentList.deleteStudentById(deleteId);
                    break;

                case 3:
                    studentList.displayAllStudents();
                    break;

                case 4:
                    System.out.print("Enter ID to find: ");
                    String findId = scanner.nextLine();
                    Student foundStudent = studentList.findStudentByID(findId);
                    if (foundStudent != null) {
                        foundStudent.displayInfo();
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    Student topStudent = studentList.findTopStudent();
                    if (topStudent != null) {
                        System.out.println("Top Student:");
                        topStudent.displayInfo();
                    } else {
                        System.out.println("No students available.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}