package as14;

//TestJFrameExt.java
import javax.swing.*;

public class TestJFrameExt {
 public static void main(String[] args) {
     // Create JFrameExt object
     JFrameExt frame = new JFrameExt();
     
     // Set frame properties
     frame.setSize(400, 300);
     frame.setTitle("Guessing Game");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setVisible(true);
 }
}