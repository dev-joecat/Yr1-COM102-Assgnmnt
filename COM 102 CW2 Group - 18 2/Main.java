package application;
import application.Student;

import java.util.Scanner;

import application.Course;
public class Main {

	 public static void main(String[] args) {

	        Scanner scanner = new Scanner(System.in);

	        Student[] students = new Student[0];
	        
	        Course course = new Course("Introduction to Java", 3, students);

	        course.readStudents();
	        
	        boolean quit = false;

	        do {
	            System.out.println("Please select an option:");
	            System.out.println("1. Print course details");
	            System.out.println("2. Write course details to file");
	            System.out.println("3. Read course details from file");
	            System.out.println("4. Write students to file (error if any null)");
	            System.out.println("5. Read students from file");
	            System.out.println("6. Add student");
	            System.out.println("7. Remove student");
	            System.out.println("8. Print all students");
	            System.out.println("9. Search for a student");
	            System.out.println("10. Quit");

	            int option = scanner.nextInt();

	            switch (option) {
	                case 1:
	                    course.printdetails();
	                    break;
	                case 2:
	                    course.writeCourseDetailsToFile("CourseDetails.txt");
	                    break;
	                case 3:
	                   	course.readCourseDetailsFromFile("CourseDetails.txt");
	                    break;
	                case 4:
	                    course.writeStudentstofile();
	                    break;
	                case 5:
	                    course.readStudents();
	                    break;
	                case 6:
	                	course.addStudent();
	                	break;
	                case 7:
	                	System.out.println("Please enter the student name:");
	                    scanner.nextLine();
	                    String s = scanner.nextLine();
	                	course.removeStudentByName(s);
	                	break;
	                case 8:
	                	course.printallstudents();
	                	break;
	                case 9:
	                	System.out.println("Please enter the student name:");
	                    scanner.nextLine();
	                	String na = scanner.nextLine();
	                	course.searchStudentByName(na);
	                	break;
	                case 10:
	                	course.writeStudentstofile();
	                    quit = true;
	                    break;
	                default:
	                    System.out.println("Invalid option, please try again.");
	            }
	        } while (!quit);

	        scanner.close();
	    }

}
