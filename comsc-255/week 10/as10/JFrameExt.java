package as10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JFrameExt extends JFrame implements ActionListener 
{
    // Declare and Create GUI objects
    private JTextField jtfMessage = new JTextField(10);
    private JButton jbtClickMe = new JButton("Click Me");
    private JButton jbtClickMeToo = new JButton("Click Me Too");
    private int count = 0;

    // Constructor to create the GUI
    public JFrameExt() 
    {
        super();
        
        // Get the container content pane
        Container container = getContentPane();
        
        // Create a FlowLayout object
        FlowLayout fl = new FlowLayout();
        
        // Call the container's setLayout method and pass it the FlowLayout object
        container.setLayout(fl);
        
        // Add the GUI components to the container
        container.add(jbtClickMe);
        container.add(jtfMessage);
        container.add(jbtClickMeToo);
        
        // Make the text field non-editable
        jtfMessage.setEditable(false);
        
        // Register this object as ActionListener with each button
        jbtClickMe.addActionListener(this);
        jbtClickMeToo.addActionListener(this);
        
        // Set default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Event handler for button click events
    public void actionPerformed(ActionEvent e) 
    {
        // Find out which button was clicked
        if (e.getSource() == jbtClickMe) 
        {
            // Increment count for "Click Me" button
            count++;
            jtfMessage.setText("Hello " + count);
        } else if (e.getSource() == jbtClickMeToo) 
        {
            // Decrement count for "Click Me Too" button
            count--;
            jtfMessage.setText("Hello " + count);
        }
    }
}
