package as09;

//File: TestStatus.java
import javax.swing.JOptionPane;

public class TestStatus 
{
 public static void main(String[] args) 
 {
     String in, out;
     // Create an array of 6 Status references
     Status[] status = new Status[6];
     int statusIndex = 0;
     
     // Create three Rectangle objects
     for (int i = 0; i < 3; i++) 
     {
         in = JOptionPane.showInputDialog("Enter length");
         double length = Double.parseDouble(in);
         in = JOptionPane.showInputDialog("Enter width");
         double width = Double.parseDouble(in);
         status[statusIndex] = new Rectangle(length, width);
         statusIndex++;
     }
     
     // Create two Sibling objects
     for (int i = 0; i < 2; i++) 
     {
         in = JOptionPane.showInputDialog("Enter name");
         String name = in;
         in = JOptionPane.showInputDialog("Enter age");
         int age = Integer.parseInt(in);
         in = JOptionPane.showInputDialog("Enter weight");
         int weight = Integer.parseInt(in);
         status[statusIndex] = new Sibling(name, age, weight);
         statusIndex++;
     }
     
     // Create one Student object
     for (int i = 0; i < 1; i++) 
     {
         in = JOptionPane.showInputDialog("Enter student id");
         int id = Integer.parseInt(in);
         in = JOptionPane.showInputDialog("Enter student name");
         String name = in;
         in = JOptionPane.showInputDialog("Enter number of scores");
         int numScores = Integer.parseInt(in);
         double[] scores = new double[numScores];
         for (int j = 0; j < numScores; j++) 
         {
             in = JOptionPane.showInputDialog("Enter score " + (j + 1));
             scores[j] = Double.parseDouble(in);
         }
         status[statusIndex] = new Student(id, name, scores);
         statusIndex++;
     }
     
     // First Polymorphic Loop - Call displayStatus()
     for (int index = 0; index < status.length; index++) 
     {
         status[index].displayStatus();
     }
     
     // Second Polymorphic Loop - Call getStatus() and accumulate output
     out = "";
     for (int index = 0; index < status.length; index++) 
     {
         out = out + status[index].getStatus();
     }
     JOptionPane.showMessageDialog(null, out);
 }
}
