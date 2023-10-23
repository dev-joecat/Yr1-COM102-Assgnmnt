package application;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StudentTest {
    @Test
    public void testCalculateFee() {
        // Create a new Student object
        Student student = new Student("John Doe", "01/01/2000", "male", "full time", 1, 4);

        // Calculate the fee and assert that it's equal to 5000
        assertEquals(5000, student.calculateFee());

        // Change the year to 3 and calculate the fee again
        student.setYear(3);
        assertEquals(2500, student.calculateFee());

        // Change the study mode to part time and the number of modules to 3
        student.setStudyMode("part time");
        student.setNumModules(3);

        // Calculate the fee and assert that it's equal to 2250
        assertEquals(2250, student.calculateFee());
    }
    
    public void testAddStudents() {
        // create a course object
        Course course = new Course("Computer Science", 5, new Student[5]);

        // add three students to the course
        Student student1 = new Student("John Doe", "01/02/2000", "male","full time",2,2);
        Student student2 = new Student("Jane Doe", "01/02/2001", "female","part time",2,2);
        Student student3 = new Student("Bob Smith", "01/02/2000", "male","full time",2,2);
        course.setNumStudents(5); // set initial number of students
        course.setStudents(new Student[]{student1, student2, student3}); // set initial students array
        course.addStudent(); // add first new student
        course.addStudent(); // add second new student
        course.addStudent(); // add third new student

        // check that the number of students is now 8
        int expectedNumStudents = 8;
        int actualNumStudents = course.getNumStudents();
        assertEquals(expectedNumStudents, actualNumStudents);
    }
    
    public void testSearchStudentByName() {
    	// add three students to the course
        Student s1 = new Student("John Doe", "01/02/2000", "male","full time",2,2);
        Student s2 = new Student("Jane Doe", "01/02/2001", "female","part time",2,2);
        Student s3 = new Student("Bob Smith", "01/02/2000", "male","full time",2,2);
        Student[] students = {s1, s2, s3};
        Course course = new Course("Java Programming", 3, students);

        // search for a student by name
        String searchedName = "Jane";
        Student foundStudent = course.searchStudentByName(searchedName);

        // check if the name of the found student matches the searched name
        String expectedName = "Jane";
        String actualName = foundStudent.getName();
        assertEquals(expectedName, actualName);
    }
}