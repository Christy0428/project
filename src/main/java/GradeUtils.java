package PROJECT;

public class GradeUtils {
    
    public static double getPoints(String grade){

        if(grade.equalsIgnoreCase("A")){
            return 4.0;
            }
            else if (grade.equalsIgnoreCase("B")){
                return 3.0;
            }
            else if (grade.equalsIgnoreCase("C")){
                return 2.0;
            }
            else if (grade.equalsIgnoreCase("D")){
                return 1.0;
            }
            else return 0.0;
    }

}
