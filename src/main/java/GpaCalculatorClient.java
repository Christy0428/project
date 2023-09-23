package PROJECT;
import java.util.Scanner;

public class GpaCalculatorClient {
    
    public static void main(String [] args){
        
        System.out.println("$ java GpacalculatorClient\n");

        Scanner input = new Scanner(System.in);
        int maxCourses = input.nextInt();

        System.out.println();

        GpaCalculator gpa = new GpaCalculator(maxCourses);

        int credits;
        String letter = "";

        int currentCourse = 0;

        char choice;
        do{
            printchoice();
            System.out.print("Enter Option: ");

            choice = input.next().charAt(0);
            switch(choice) {
            case '1':
                if(currentCourse<maxCourses){

                    System.out.print("Enter credits: ");
                    credits = input.nextInt();

                    System.out.print("Enter grade:");
                    letter = input.next().toUpperCase();

                    Course course = new Course(credits, letter);
                    gpa.addCourse(course);

                    currentCourse++;
                }
                break;
            case '2':
                System.out.println(gpa.coursesInfoAsString());
                break;

            case'3':
                double valueOfGpa = gpa.computeGpa();
                String formatedGpa = String.format("%.3f", valueOfGpa);
                System.out.println("GPA is " + formatedGpa);
                break;

            case'0':
            default:
                System.out.println("Exit.");
                break;
            }
        } while (choice != '0');
        input.close();
    }

    public static void printchoice(){
        System.out.println("1. Add Course");
        System.out.println("2. List Course");
        System.out.println("3. Display GPA");
        System.out.println("0. Exit");
    }

    }

