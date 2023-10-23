package application;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Student{
    private String name;
    private java.util.Date dob;
    private String gender;
    private String studyMode;
    private int year;
    private int numModules;

    //create constructor
    public Student(String name, String dobString, String gender, String studyMode, int year, int numModules) {
        this.name = name;
        this.gender = gender;
        this.studyMode = studyMode;
        this.year = year;
        this.numModules = numModules;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.dob =  dateFormat.parse(dobString);
        } catch (ParseException e) {
            System.out.println(" ");
        }
    }

    //create getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public java.util.Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void SetGender(String g)
    {
        gender = g;
    }
    
    public String getStudyMode() {
        return studyMode;
    }

    public void setStudyMode(String studyMode) {
        this.studyMode = studyMode;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumModules() {
        return numModules;
    }

    public void setNumModules(int numModules) {
        this.numModules = numModules;
    }

    //create a method to display student details
    public void displayStudentDetails()
    {
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + dob);
        System.out.println("Gender: " + gender);
        System.out.println("Study Mode: " + studyMode);
        System.out.println("Year: " + year);
        System.out.println("Number of Modules: " + numModules);
    }

    //take input from user
	public void inputStudentDetails()
    {
        //create a scanner object
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

        System.out.println("Enter name: ");
        name = sc.nextLine();

        System.out.println("Enter date of birth: ");
        String let = sc.nextLine();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date = null;

        try {
            date = dateFormat.parse(let);
        } catch (Exception e) {
            e.printStackTrace();
        }

        dob = date;
        
        
        System.out.println("Enter gender: ");
        gender = sc.nextLine();
        //ensure that gender is either male or female or M or F or Male or Female
        while(!gender.equals("male") && !gender.equals("female") && !gender.equals("M") && !gender.equals("F") && !gender.equals("Male") && !gender.equals("Female"))
        {
            System.out.println("Invalid gender. Enter gender again: ");
            gender = sc.nextLine();
        }

        System.out.println("Enter study mode: ");
        studyMode = sc.nextLine();

        //ensure that study mode is either full time or part time or FT or PT or Full Time or Part Time
        while(!studyMode.equals("full time") && !studyMode.equals("part time") && !studyMode.equals("FT") && !studyMode.equals("PT") && !studyMode.equals("Full Time") && !studyMode.equals("Part Time"))
        {
            System.out.println("Invalid study mode. Enter study mode again: ");
            studyMode = sc.nextLine();
        }

        System.out.println("Enter year: ");
        year = sc.nextInt();

        //ensure that year is greater than 0 and less than 5
        while(year<0 || year>5)
        {
            System.out.println("Invalid year. Enter year again: ");
            year = sc.nextInt();
        }

        System.out.println("Enter number of modules: ");
        numModules = sc.nextInt();

        //ensure that number of modules is greater than 0 and less than 6
        while(numModules<0 || numModules>6)
        {
            System.out.println("Invalid number of modules. Enter number of modules again: ");
            numModules = sc.nextInt();
        }

    }

    //calculate the fee for the student based on the number of modules and study mode and year
    //for a full time student, the fee is 5000 for year 1, year 2, year 4 and 2500 for year 3
    //for a part time student, fee is calculated based on the number of modules (750 per module)

    public int calculateFee()
    {
        int fee = 0;

        if(studyMode == "full time" || studyMode == "FT" || studyMode == "Full Time")
        {
            if(year == 1 || year == 2 || year == 4)
            {
                fee = 5000;
            }
            else if(year == 3)
            {
                fee = 2500;
            }
        }
        else if(studyMode == "part time" || studyMode == "PT" || studyMode == "Part Time")
        {
            fee = numModules * 750;
        }

        return fee;
    }
    
    public String toString() {
        return "Name: " + name +
               "\nDate of Birth: " + dob +
               "\nGender: " + gender +
               "\nStudy Mode: " + studyMode +
               "\nYear: " + year +
               "\nNumber of Modules: " + numModules;
    }
}