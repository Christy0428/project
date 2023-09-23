import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class TestGpaCalculator{

   @Test
   public void testConstructor()
   {
      Random rng = new Random();
      int maxCourses = rng.nextInt(10) + 1;

      GpaCalculator gpaCalculator = new GpaCalculator(maxCourses);

      assertEquals(0, gpaCalculator.getNumCourses());
      assertEquals(maxCourses, gpaCalculator.getNumAvailableCourses());

   }

   
   @Test
   public void testAddCourse() {
      Course course;
      boolean success;

      Random rng = new Random();
      int maxCourses = rng.nextInt(10) + 1;

      GpaCalculator gpaCalculator = new GpaCalculator(maxCourses);

      success = gpaCalculator.addCourse(new Course(3, "A"));
      assertEquals(true, success);
      assertEquals(1, gpaCalculator.getNumCourses());
      assertEquals(maxCourses - 1, gpaCalculator.getNumAvailableCourses());
      course = gpaCalculator.getCourse(0);
      assertEquals("Course[credits=3,grade=A]", course.toString());

      if (maxCourses > 1) {
         success = gpaCalculator.addCourse(new Course(4, "F"));
         assertEquals(true, success);
         assertEquals(2, gpaCalculator.getNumCourses());
         assertEquals(maxCourses - 2, gpaCalculator.getNumAvailableCourses());
         course = gpaCalculator.getCourse(1);
         assertEquals("Course[credits=4,grade=F]", course.toString());
      }

      for (int i=gpaCalculator.getNumCourses(); i<maxCourses; i++) {
         success = gpaCalculator.addCourse(new Course(2, "B"));
         assertEquals(true, success);
         assertEquals(i+1, gpaCalculator.getNumCourses());
         assertEquals(maxCourses - (i+1), gpaCalculator.getNumAvailableCourses());
         course = gpaCalculator.getCourse(i);
         assertEquals("Course[credits=2,grade=B]", course.toString());         
      }

      success = gpaCalculator.addCourse(new Course(2, "B"));
      assertEquals(false, success);
   }

   @Test
   public void testGetCourse() {
      GpaCalculator gpaCalculator;

      gpaCalculator = new GpaCalculator(3);
      Course course = gpaCalculator.getCourse(0);
      assertEquals(null, course);

      gpaCalculator.addCourse(new Course(3, "A"));
      gpaCalculator.addCourse(new Course(4, "B"));
      course = gpaCalculator.getCourse(0);
      String actual = course.toString();
      String expected = "Course[credits=3,grade=A]";
      assertEquals(expected, actual);

      course = gpaCalculator.getCourse(1);
      actual = course.toString();
      expected = "Course[credits=4,grade=B]";
      assertEquals(expected, actual);

      course = gpaCalculator.getCourse(2);
      assertEquals(null, course);

      Course newCourse = new Course(1, "F");
      gpaCalculator.addCourse(newCourse);
      course = gpaCalculator.getCourse(2);
      assertEquals(newCourse.toString(), course.toString());
      assertFalse(course == newCourse);

   }

   @Test
   public void testCoursesInfoAsStringNoCoursesAdded() {
      GpaCalculator gpaCalculator;

      // action
      gpaCalculator = new GpaCalculator(2);
      String actual = gpaCalculator.coursesInfoAsString().replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
 

      // assertion
      String expected = "No courses entered.\n"
                        .replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
      assertEquals(expected, actual);
   }

   @Test
   public void testCoursesInfoAsStringOneCoursesAdded() {
      GpaCalculator gpaCalculator;

      // action
      gpaCalculator = new GpaCalculator(2);
      gpaCalculator.addCourse(new Course(3, "A"));
      String actual = gpaCalculator.coursesInfoAsString().replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));



      String output = String.format("%5s\t%8s\t%7s\t%15s\n", "No.", "Credits", "Grade", "Grade Points");
      output += String.format("%5d\t%8d\t%7s\t%15.3f\n", 
                              1, 
                              3, 
                              "A",
                              4.0);

      // assertion
      String expected = output
                        .replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
      assertEquals(expected, actual);
 
   }

   @Test
   public void testCoursesInfoAsStringTwoCoursesAdded() {
      GpaCalculator gpaCalculator;

      // action
      gpaCalculator = new GpaCalculator(2);
      gpaCalculator.addCourse(new Course(3, "A"));
      gpaCalculator.addCourse(new Course(4, "F"));
      String actual = gpaCalculator.coursesInfoAsString().replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));


      String output = String.format("%5s\t%8s\t%7s\t%15s\n", "No.", "Credits", "Grade", "Grade Points");
      output += String.format("%5d\t%8d\t%7s\t%15.3f\n", 
                              1, 
                              3, 
                              "A",
                              4.0);
      output += String.format("%5d\t%8d\t%7s\t%15.3f\n", 
                              2, 
                              4, 
                              "F",
                              0.0);

      // assertion
      String expected = output
                        .replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
      assertEquals(expected, actual);
   }


   @Test
   public void testComputeGpa() {
      GpaCalculator gpaCalculator;

      // action
      gpaCalculator = new GpaCalculator(3);
      gpaCalculator.addCourse(new Course(3, "A"));
      gpaCalculator.addCourse(new Course(4, "F"));
      double actual = gpaCalculator.computeGpa();



      double expected = (3 * 4.0 + 4 * 0.0)/(3.0 + 4.0);

      assertEquals(expected, actual);

      gpaCalculator.addCourse(new Course(2, "B"));
      actual = gpaCalculator.computeGpa();

      expected = (3 * 4.0 + 4 * 0.0 + 2 * 3.0)/(3.0 + 4.0 + 2.0);

      
      // assertion
      assertEquals(expected, actual);
   }

}
