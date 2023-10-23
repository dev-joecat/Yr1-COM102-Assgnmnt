package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
//make a student class with name, date of birth, gender, study mode, year, number of modules
import java.util.Scanner;

  //create a course class with course name, number of students and an array of students
  public class Course{
      private String courseName;
      private int numStudents1;
      private Student[] students1;

      //create parameterized constructor
      Course(String a, int b, Student[] c)
      {
          courseName = a;
          numStudents1 = b;
          students1 = c;
      }

      //create getters and setters
      public String getCourseName() {
          return courseName;
      }

      public void setCourseName(String courseName) {
          this.courseName = courseName;
      }

      public int getNumStudents() {
          return numStudents1;
      }

      public void setNumStudents(int numStudents) {
          this.numStudents1 = numStudents;
      }

      public Student[] getStudents() {
          return students1;
      }

      public void setStudents(Student[] students) {
          this.students1 = students;
      }

      public void addStudent()
      {
    	  if(numStudents1 >= 20)
    	  {
    		  System.out.println("Max number of students");
    		  return;
    	  }
    	  Student a = new Student("", "", "" , "", 0,0);
    	    a.inputStudentDetails();
    	    numStudents1++;
    	    Student[] newarray = new Student[numStudents1];
    	    System.arraycopy(students1, 0, newarray, 0, numStudents1-1);
    	    newarray[numStudents1-1] = a;
    	    students1 = newarray;
    	    System.out.println("New student has been added");
    	  
      }
      
      public void removeStudentByName(String name) {
    	    for (int i = 0; i < numStudents1; i++) {
    	        if (students1[i].getName().equals(name)) { // check if the current student's name matches the specified name
    	            numStudents1--; // decrement the count of students
    	            Student[] newarray = new Student[numStudents1]; // create a new array with one less element
    	            System.arraycopy(students1, 0, newarray, 0, i); // copy the elements before the removed student
    	            System.arraycopy(students1, i+1, newarray, i, numStudents1-i); // copy the elements after the removed student
    	            students1 = newarray; // update the students array
    	            System.out.println("Student removed");
    	            return; // exit the method once the student has been removed
    	        }
    	    }
    	    // If the specified name was not found, print an error message
    	    System.out.println("Error: No student with name " + name + " was found.");
    	}
      //print the details of all the students in the course
      public void printdetails()
      {
          //print the course name
          System.out.println("Course Name: " + courseName);

          //total number of PT and FT students
          int numPT = 0;
          int i=0;
          while(i<numStudents1)
          {
              if(students1[i].getStudyMode().equals("part time") || students1[i].getStudyMode().equals("PT") || students1[i].getStudyMode().equals("Part Time"))
              {
                  numPT++;
              }
              i++;
          }

          int numFT = numStudents1 - numPT;

          //print the number of PT and FT students
          System.out.println("Number of Part Time Students: " + numPT);

          System.out.println("Number of Full Time Students: " + numFT);

          //print the percentage of male and female students
          double numM = 0;
          int j=0;
          while(j<numStudents1)
          {
              if(students1[j].getGender().equals("male")|| students1[j].getGender().equals("M")|| students1[j].getGender().equals("Male"))
              {
                  numM++;
              }
              j++;
          }

          double numF = numStudents1 - numM;
          
          double percentM = (double)(numM/numStudents1) * 100;

          double percentF = (double)(numF/numStudents1) * 100;

          //print

          System.out.println("Percentage of Male Students: " + percentM);

          System.out.println("Percentage of Female Students: " + percentF);

      }
      
      public void printallstudents()
      {
    	  int i=0;
    	  while(i<numStudents1)
    	  {
    		  students1[i].displayStudentDetails();
    		  i++;
    	  }
      }

      public void writeCourseDetailsToFile(String fileName) {
          try {
              FileWriter writer = new FileWriter(fileName);
              writer.write("Course Name: " + courseName + "\n");
              writer.write("Number of Students: " + numStudents1 + "\n");
              writer.close();
              System.out.println("Course details written to file successfully.");
          } catch (IOException e) {
              System.out.println("An error occurred while writing course details to file.");
              e.printStackTrace();
          }
      }

      public void readCourseDetailsFromFile(String fileName) {
          try {
              BufferedReader reader = new BufferedReader(new FileReader(fileName));
              String courseNameLine = reader.readLine();
              String numStudentsLine = reader.readLine();
              reader.close();
      
              // Parse course name and number of students from file
              String[] courseNameParts = courseNameLine.split(": ");
              String courseName = courseNameParts[1];
      
              String[] numStudentsParts = numStudentsLine.split(": ");
              int numStudents = Integer.parseInt(numStudentsParts[1]);
      
              // Set course name and number of students in object
              setCourseName(courseName);
              setNumStudents(numStudents);
      
              System.out.println("Course details read from file successfully.");
          } catch (IOException e) {
              System.out.println("An error occurred while reading course details from file.");
              e.printStackTrace();
          }
      }

      public void writeStudentstofile() {
    	  try (PrintWriter writer = new PrintWriter(new FileWriter("StudentsDetails.txt"))) {
              writer.println(numStudents1);

              for (int i = 0; i < numStudents1; i++) {
                  writer.println(students1[i].getName());
                  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                  String formattedDate = formatter.format(students1[i].getDob());
                  writer.println(formattedDate);
                  writer.println(students1[i].getGender());
                  writer.println(students1[i].getStudyMode());
                  writer.println(students1[i].getYear());
                  writer.println(students1[i].getNumModules());
              }
          } catch (IOException e) {
              System.err.println("Error writing students to file: " + e.getMessage());
          }
      }
      
      public void readStudents() {
          Student[] students = null;
          int numStudents = 0;

          try (Scanner scanner = new Scanner(new File("StudentsDetails.txt"))) {
        	  numStudents = scanner.nextInt();
              students = new Student [numStudents];
              scanner.nextLine(); // consume newline character

              for (int i = 0; i < numStudents; i++) {
                  String name = scanner.nextLine();
                  String dob = scanner.nextLine();
                  String gender = scanner.nextLine();
                  String studyMode = scanner.nextLine();
                  int year = scanner.nextInt();
                  int numModules = scanner.nextInt();
                  scanner.nextLine(); // consume newline character

                  students[i] = new Student(name, dob, gender, studyMode, year, numModules);
              }
          } catch (FileNotFoundException e) {
              System.err.println("Error: File not found (" + "StudentDetails.txt" + ")");
          }

          numStudents1 = numStudents;
          students1 = students;
      }
      
      public Student searchStudentByName(String name) {
    	    for (int i = 0; i < numStudents1; i++) {
    	        if (students1[i].getName().equals(name)) { // check if the current student's name matches the specified name
    	            students1[i].displayStudentDetails(); // return the student object if found
    	            return students1[i];
    	        }
    	    }
    	    // If the specified name was not found, return null
    	    System.out.println("Student not found!");
    	    return null;
    	}
  }

     



