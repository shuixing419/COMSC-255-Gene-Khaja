package as09;

//File: Sibling.java
import javax.swing.JOptionPane;

public class Sibling implements Status 
{
 private String name;
 private int age;
 private int weight;

 public Sibling(String n, int a, int w) 
 {
     name = n;
     age = a;
     weight = w;
 }

 public String getName() 
 {
     return name;
 }

 public int getAge() 
 {
     return age;
 }

 public int getWeight() 
 {
     return weight;
 }

 public String getStatus() 
 {
     String status = "Sibling\nname=" + name + ", age=" + age + ", weight=" + weight + "\n\n";
     return status;
 }

 public void displayStatus() 
 {
     String status = getStatus();
     JOptionPane.showMessageDialog(null, status);
 }
}
