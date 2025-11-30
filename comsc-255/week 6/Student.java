package as06;

public class Student 
{
    private int id;
    private String name;
    private double[] scores;
    
    public Student(int id, String name, double[] scores) 
    {
        super();
        this.id = id;
        this.name = name;
        this.scores = scores.clone();
    }
    
    public String findGrade() 
    {
        String grade = "";
        double sum = 0;
        for (int i = 0; i < scores.length; i++) 
        {
            sum = sum + scores[i];
        }
        double average = sum / scores.length;
        
        if (average >= 90.0)
            grade = "A";
        else if (average >= 80.0)
            grade = "B";
        else if (average >= 70.0)
            grade = "C";
        else if (average >= 60.0)
            grade = "D";
        else
            grade = "F";
        
        return grade;
    }
    
    public int getId() 
    {
        return id;
    }
    
    public String getName() 
    {
        return name;
    }
}
