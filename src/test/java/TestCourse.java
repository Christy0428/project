import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestCourse{

   @Test
   public void testConstructor()
   {
    Course course = new Course(3, "A");

    assertEquals(3, course.getCredits());
    assertEquals("A", course.getGrade());

   }

   @Test
   public void testGetCredits() {
    Course course = new Course(4, "B");

    assertEquals(4, course.getCredits());

  }

   @Test
   public void testGetGrade() {
    Course course = new Course(2, "C");

    assertEquals("C", course.getGrade());

   }

   @Test
   public void testToString() {

    Course course = new Course(1, "D");

    assertEquals("Course[credits=1,grade=D]", course.toString());

    course = new Course(4, "F");

    assertEquals("Course[credits=4,grade=F]", course.toString());

   }

}
