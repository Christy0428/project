package PROJECT;

public class GpaCalculator {
    private int maxCourses;
    private int numCourses;
    private Course[] courses;
    
    public GpaCalculator(int maxCourses){
        this.maxCourses = maxCourses;
        this.numCourses = 0;
        this.courses = new Course[maxCourses];

    }

    public int getNumCourses(){
        return numCourses;
    }

    public int getNumAvailableCourses(){
        return maxCourses - numCourses;
    }

    public Course getCourse(int index){
        if(index >= 0 && index < maxCourses){
            return courses[index];
        }
        else return null;
    }

    public boolean addCourse(Course course){
        if(numCourses < maxCourses){
            courses[numCourses] = course;
            numCourses++;
            return true;
        }
        else return false;
    }

    public String coursesInfoAsString(){
        StringBuilder result = new StringBuilder();

        String headLine = String.format("%5s\t%8s\t%7s\t%15s\n","No.", "Credits", "Grade","Grade points");
        result.append(headLine);

        for(int i=0; i<numCourses; i++){
            Course course = courses [i];
            String letterGrade = course.getGrade();
            double points = GradeUtils.getPoints(letterGrade);
            String courseLine = String.format("%5d\t%8d\t%7s\t%15.3f\n",i+1,course.getCredits(),course.getGrade(),points);
            result.append(courseLine);
        }
        return result.toString();
    }
    
    public double computeGpa(){
        if(numCourses<0){
            return -1;
        }
        else{
            double sum = 0;
            for(int i=0; i<numCourses; i++){
                sum += GradeUtils.getPoints(courses[i].getGrade());
            }
            double average = sum/numCourses;
            return average;
        }
    } 
}
