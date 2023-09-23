import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestGradeUtils{

   @Test
   public void testGetPoints()
   {
      double points; 
      double expected;      

      points = GradeUtils.getPoints("A");
      expected = 4.0;
      assertEquals(expected, points);

      points = GradeUtils.getPoints("B");
      expected = 3.0;
      assertEquals(expected, points);

      points = GradeUtils.getPoints("C");
      expected = 2.0;
      assertEquals(expected, points);

      points = GradeUtils.getPoints("D");
      expected = 1.0;
      assertEquals(expected, points);

      points = GradeUtils.getPoints("F");
      expected = 0.0;
      assertEquals(expected, points);

      points = GradeUtils.getPoints("Z");
      expected = -1.;
      assertEquals(expected, points);

   }

}
