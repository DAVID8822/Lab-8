package csci2020u.lab08;


public class StudentRecord {

    String SID;
    double assignmentGrade;
    double midtermGrade;
    double finalexamGrade;
    double finalmark;
    char letterGrade;

    public StudentRecord(String studentNumber,double assignmentGrade, double midtermGrade, double finalexamGrade) {
        this.SID = studentNumber;
        this.midtermGrade = midtermGrade;
        this.finalexamGrade = finalexamGrade;
        this.assignmentGrade = assignmentGrade;


        this.finalmark += finalexamGrade * 0.5;
        this.finalmark += assignmentGrade * 0.2;
        this.finalmark += midtermGrade * 0.3;
        if (this.finalmark >= 80) {
            letterGrade = 'A';
        } else if (this.finalmark <= 79 && this.finalmark >= 70) {
            letterGrade = 'B';
        } else if (this.finalmark <= 69 && this.finalmark >= 60) {
            letterGrade = 'C';
        } else if (this.finalmark <= 59 && this.finalmark >= 50) {
            letterGrade = 'D';
        } else if (this.finalmark < 50) {
            letterGrade = 'F';

        }


        }

    public String getStudentID() {
        return SID;
    }
    public double getAssignments(){
        return assignmentGrade;
    }
    public double getMidterm(){
        return midtermGrade;
    }
    public double getFinalExam(){
        return finalexamGrade;
    }
    public double getFinalMark(){
        return finalmark;
    }
    public char getLetterGrade(){
        return letterGrade;
    }


}