package as09;

//File: Rectangle.java
import javax.swing.JOptionPane;

public class Rectangle implements Status 
{
 private double length;
 private double width;

 public Rectangle(double l, double w) 
 {
     length = l;
     width = w;
 }

 public double getLength() 
 {
     return length;
 }

 public double getWidth() 
 {
     return width;
 }

 public String getStatus() 
 {
     String status = "Rectangle\nLength=" + length + ", Width=" + width + "\n\n";
     return status;
 }

 public void displayStatus() 
 {
     String status = getStatus();
     JOptionPane.showMessageDialog(null, status);
 }
}
