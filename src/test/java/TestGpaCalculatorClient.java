import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

public class TestGpaCalculatorClient {

   @Test
   public void testDisplayMenu()
   {
     PrintStream originalOut = System.out;
     ByteArrayOutputStream bos = new ByteArrayOutputStream();
     System.setOut(new PrintStream(bos));

     // action
     GpaCalculatorClient.displayMenu();

    //  System.err.println("bos.toString() = " + bos.toString());

     // assertion
     String expected = "1. Add Course\n2. List Courses\n3. Display GPA\n0. Exit\n"
                       .replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
     String actual = bos.toString().replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
     assertEquals(expected, actual);


     // undo the binding in System
     System.setOut(originalOut);
   }


   @Test
   public void testMain13A3() {
    String userInput = "1\n3\nA\n3\n";
    String expectedOutput = "1. Add Course\n" +
                            "2. List Courses\n" +
                            "3. Display GPA\n" +
                            "0. Exit\n" +
                            "Enter Option: " +
                            "Enter credits: " +
                            "Enter grade: " +
                            "1. Add Course\n" +
                            "2. List Courses\n" +
                            "3. Display GPA\n" +
                            "0. Exit\n" +
                            "Enter Option: " +
                            "GPA is 4.000\n" +
                            "1. Add Course\n" +
                            "2. List Courses\n" +
                            "3. Display GPA\n" +
                            "0. Exit\n" +
                            "Enter Option: ";

    testMainInputOutput(userInput, expectedOutput);
   }

   @Test
   public void testMain13A2() {
    String userInput = "1\n3\nA\n2\n";
    String expectedOutput = "1. Add Course\n" +
                            "2. List Courses\n" +
                            "3. Display GPA\n" +
                            "0. Exit\n" +
                            "Enter Option: " +
                            "Enter credits: " +
                            "Enter grade: " +
                            "1. Add Course\n" +
                            "2. List Courses\n" +
                            "3. Display GPA\n" +
                            "0. Exit\n" +
                            "Enter Option: " +
                            String.format("%5s\t%8s\t%7s\t%15s\n", "No.", "Credits", "Grade", "Grade Points") + 
                            String.format("%5d\t%8d\t%7s\t%15.3f\n", 1, 3, "A", 4.0) + 
                            "1. Add Course\n" +
                            "2. List Courses\n" +
                            "3. Display GPA\n" +
                            "0. Exit\n" +
                            "Enter Option: ";

    testMainInputOutput(userInput, expectedOutput);
   }

   @Test
   public void testMain12B13A3() {
    String userInput = "1\n2\nB\n1\n3\nA\n3\n";
    String expectedOutput = "1. Add Course\n" +
                            "2. List Courses\n" +
                            "3. Display GPA\n" +
                            "0. Exit\n" +
                            "Enter Option: " +
                            "Enter credits: " +
                            "Enter grade: " +
                            "1. Add Course\n" +
                            "2. List Courses\n" +
                            "3. Display GPA\n" +
                            "0. Exit\n" +
                            "Enter Option: " +
                            "Enter credits: " +
                            "Enter grade: " +
                            "1. Add Course\n" +
                            "2. List Courses\n" +
                            "3. Display GPA\n" +
                            "0. Exit\n" +
                            "Enter Option: " +
                            "GPA is 3.600\n" +
                            "1. Add Course\n" +
                            "2. List Courses\n" +
                            "3. Display GPA\n" +
                            "0. Exit\n" +
                            "Enter Option: ";

    testMainInputOutput(userInput, expectedOutput);
  }

  @Test
   public void testMain12B13A2() {
    String userInput = "1\n2\nB\n1\n3\nA\n2\n";
    String expectedOutput = "1. Add Course\n" +
                            "2. List Courses\n" +
                            "3. Display GPA\n" +
                            "0. Exit\n" +
                            "Enter Option: " +
                            "Enter credits: " +
                            "Enter grade: " +
                            "1. Add Course\n" +
                            "2. List Courses\n" +
                            "3. Display GPA\n" +
                            "0. Exit\n" +
                            "Enter Option: " +
                            "Enter credits: " +
                            "Enter grade: " +
                            "1. Add Course\n" +
                            "2. List Courses\n" +
                            "3. Display GPA\n" +
                            "0. Exit\n" +
                            "Enter Option: " +
                            String.format("%5s\t%8s\t%7s\t%15s\n", "No.", "Credits", "Grade", "Grade Points") + 
                            String.format("%5d\t%8d\t%7s\t%15.3f\n", 1, 2, "B", 3.0) + 
                            String.format("%5d\t%8d\t%7s\t%15.3f\n", 2, 3, "A", 4.0) + 
                            "1. Add Course\n" +
                            "2. List Courses\n" +
                            "3. Display GPA\n" +
                            "0. Exit\n" +
                            "Enter Option: ";

    testMainInputOutput(userInput, expectedOutput);
  }


   @Test
   public void testMain2() {
    String userInput = "2\n";
    String expectedOutput = "1. Add Course\n" +
                            "2. List Courses\n" +
                            "3. Display GPA\n" +
                            "0. Exit\n" +
                            "Enter Option: " +
                            "No courses entered.\n" +
                            "1. Add Course\n" +
                            "2. List Courses\n" +
                            "3. Display GPA\n" +
                            "0. Exit\n" +
                            "Enter Option: ";

    testMainInputOutput(userInput, expectedOutput);
   }

   @Test
   public void testMain3() {
    String userInput = "3\n";
    String expectedOutput = "1. Add Course\n" +
                            "2. List Courses\n" +
                            "3. Display GPA\n" +
                            "0. Exit\n" +
                            "Enter Option: " +
                            "GPA is unavailable\n" +
                            "1. Add Course\n" +
                            "2. List Courses\n" +
                            "3. Display GPA\n" +
                            "0. Exit\n" +
                            "Enter Option: ";

    testMainInputOutput(userInput, expectedOutput);
   }




   private void testMainInputOutput(String userInput, String expectedOutput) {
    PrintStream originalOut = System.out;
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    System.setOut(new PrintStream(bos));

    InputStream originalIn = System.in;
    String input = userInput
                   .replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
    ByteArrayInputStream bis = new ByteArrayInputStream(input.getBytes());
    System.setIn(bis);


    // action
    try {
      GpaCalculatorClient.main(new String[] {});
    } catch (Exception e) {
    }
  

    // assertion
    String expected = expectedOutput
                      .replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));
    String actual = bos.toString().replaceAll("\\n|\\r\\n", System.getProperty("line.separator"));;
    assertEquals(expected, actual);


    // undo the binding in System
    System.setOut(originalOut);   
    System.setIn(originalIn);     
   }
}


