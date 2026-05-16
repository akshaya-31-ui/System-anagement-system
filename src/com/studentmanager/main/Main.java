package com.studentmanager.main;
import com.studentmanager.model.Student;
import com.studentmanager.service.StudentManager;
import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        StudentManager manager=new StudentManager(); 
        manager.loadFromFile(); 
        while(true){
            System.out.println("STUDENT MANAGEMENT SYSTEM");
            System.out.println("1.Add Student");
            System.out.println("2.View All Student Details");
            System.out.println("3.Search Student");
            System.out.println("4.Delete Student");
            System.out.println("5.Show Average Marks");
            System.out.println("6.Sort by Names");
            System.out.println("7.(Want to know ranks?) Sort by marks");
            System.out.println("8.Update the marks");
            System.out.println("9.Save Data");
            System.out.println("10.Top Performer");
            System.out.println("11.Lowest Performer");
            System.out.println("12.Show Statistics");
            System.out.println("13.Exit");
            System.out.println("Enter your choice:");
            int choice = -1;
        try {
            choice = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a number between 1-13.");
            sc.nextLine();  
            continue;        
        }
            switch(choice){
                case 1: System.out.println("Enter Student ID:");
                int id = -1;
                try {
                    id = sc.nextInt();
                    sc.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid ID! Must be a number.");
                    sc.nextLine();
                    break;
                }

                while(id <= 0) {
                    System.out.println("Invalid Id! Enter valid Id:");
                    try {
                        id = sc.nextInt();
                        sc.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid ID! Must be a number.");
                        sc.nextLine();
                    }
                }

                if (manager.studentExists(id)) {
                    System.out.println("Student with this ID already exists.");
                    break;
                }

                System.out.println("Enter Student Name:");
                String name = sc.nextLine().trim();
                while(!name.matches("[a-zA-Z ]+")) {
                    System.out.println("Invalid name! Enter only letters:");
                    name = sc.nextLine().trim();
                }

                System.out.println("Enter Student Marks (0-100):");
                double marks = -1;
                try {
                    marks = sc.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid marks! Must be a number.");
                    sc.nextLine();
                    break;
                }

                while(marks < 0 || marks > 100) {
                    System.out.println("Invalid! Enter marks between 0 and 100:");
                    try {
                        marks = sc.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid marks! Must be a number.");
                        sc.nextLine();
                    }
                }

                manager.addStudent(new Student(id, name, marks));
                break;
                case 2:manager.viewAllStudents();
                       break;
                case 3:System.out.println("Enter ID to Search:");
                try {
                    int searchId = sc.nextInt();
                    Student s = manager.searchStudent(searchId);
                    if(s != null) {
                        System.out.println(s);
                    } else {
                        System.out.println("Student not found.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid ID! Must be a number.");
                    sc.nextLine();
                }
                break;
                case 4:System.out.println("Enter ID to delete:");
                try {
                    int deleteId = sc.nextInt();
                    manager.deleteStudent(deleteId);
                } catch (InputMismatchException e) {
                    System.out.println("Invalid ID! Must be a number.");
                    sc.nextLine();
                }
                break;
                case 5:manager.showAverage();
                       break;
                case 6:manager.sortByName();
                       break;
                case 7:manager.sortByMarks();
                       break;
                case 8:System.out.println("Enter Student ID to update:");
                try {
                    int updateId = sc.nextInt();
                    Student existing = manager.searchStudent(updateId);

                    if(existing == null) {
                        System.out.println("Student not found.");
                        break;
                    }

                    System.out.println("Current Record: " + existing);
                    System.out.println("Enter new Marks (0-100):");

                    double newMarks = sc.nextDouble();
                    while(newMarks < 0 || newMarks > 100) {
                        System.out.println("Invalid! Enter marks between 0 and 100:");
                        newMarks = sc.nextDouble();
                    }
                    manager.updateStudent(updateId, newMarks);

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Must be a number.");
                    sc.nextLine();
                }
                break;
                case 9:manager.saveToFile();
                       break;
               case 10:manager.getTopPerformer();
                       break;
               case 11:manager.getLowestPerformer();
                       break;
               case 12:manager.showStatistics();
                       break;
                case 13:manager.saveToFile();
                        System.out.println("Exiting....");
                        sc.close();
                        return;
                default:System.out.println("Invalid choice!");
            }
        }

    }
}