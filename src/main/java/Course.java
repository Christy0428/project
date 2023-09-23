package PROJECT;

public class Course{
    private int credits;
    private String grade;

public Course (int credits, String grade) {
    this.credits = credits;
    this.grade = grade;
}

public int getCredits (){
    return credits;
}

public String getGrade(){
    return grade;
}

public String toString(){
    return "Course [credits=" + credits + ",grade=" + grade + "]"; 
}

}