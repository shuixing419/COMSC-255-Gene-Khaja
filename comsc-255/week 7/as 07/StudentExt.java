package as07;

public class StudentExt extends Student 
{
    private String gradeType;

    public StudentExt(int id, String name, double[] scores, String gradeType) 
    {
        super(id, name, scores);
        this.gradeType = gradeType;
    }

    public String getGradeType() 
    {
        return gradeType;
    }

    // This method over-rides the same method in the parent class
    public String findGrade() 
    {
        // call the parent method findGrade for determine letter grade
        String grade = super.findGrade();
        
        // if the gradeType is Credit, change the grade
        if (gradeType.equalsIgnoreCase("Credit")) 
        {
            if ((grade.equalsIgnoreCase("A")) ||
                (grade.equalsIgnoreCase("B")) || 
                (grade.equalsIgnoreCase("C")))
                grade = "CR";
            else
                grade = "NCR";
        }
        return grade;
    }
}
