package as09;

//File: Student.java
import javax.swing.JOptionPane;

public class Student implements Status 
{
 private int id;
 private String name;
 private double[] scores;

 public Student(int id, String n, double[] s) 
 {
     this.id = id;
     name = n;
     scores = new double[s.length];
     System.arraycopy(s, 0, scores, 0, s.length);
 }

 public int getId() 
 {
     return id;
 }

 public String getName() 
 {
     return name;
 }

 public double[] getScores() 
 {
     return scores.clone();
 }

 public String getStatus() 
 {
     String status = "Student\nid=" + id + ", name=" + name + ", scores= ";
     for (int i = 0; i < scores.length; i++) {
         status = status + scores[i] + " ";
     }
     status = status + "\n\n";
     return status;
 }

 public void displayStatus() 
 {
     String status = getStatus();
     JOptionPane.showMessageDialog(null, status);
 }
}
