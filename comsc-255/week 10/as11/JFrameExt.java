package as11;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JFrameExt extends JFrame implements ActionListener 
{
    private JPanel jpMain = new JPanel();
    private JPanel jpFrom = new JPanel();
    private JPanel jpTo = new JPanel();
    private JPanel jpOp = new JPanel();
    private JLabel jlbFrom = new JLabel("From");
    private JLabel jlbTo = new JLabel("To  ");
    private JTextField jtfFrom = new JTextField(10);
    private JTextField jtfTo = new JTextField(10);
    private JButton jbtFtoC = new JButton("FtoC");
    private JButton jbtCtoF = new JButton("CtoF");

    public JFrameExt() 
    {
        setTitle("Temperature Converter");
        setSize(400, 200);
        
        // Set jpMain layout
        GridLayout gl = new GridLayout(3, 1);
        jpMain.setLayout(gl);
        
        // Add panels to jpMain
        jpMain.add(jpFrom);
        jpMain.add(jpTo);
        jpMain.add(jpOp);
        
        // Set panel colors for visual distinction
        jpFrom.setBackground(Color.red);
        jpTo.setBackground(Color.green);
        jpOp.setBackground(Color.magenta);
        
        // Make jpMain as the content pane
        this.setContentPane(jpMain);
        
        // Add components to panels
        jpFrom.add(jlbFrom);
        jpFrom.add(jtfFrom);
        jpTo.add(jlbTo);
        jpTo.add(jtfTo);
        
        // Make the "To" text field read-only
        jtfTo.setEditable(false);
        
        // Add buttons to operation panel
        jpOp.add(jbtFtoC);
        jpOp.add(jbtCtoF);
        
        // Register this object as a listener with buttons
        jbtFtoC.addActionListener(this);
        jbtCtoF.addActionListener(this);
        
        // Set default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setVisible(true);
    }

    // Listener method for button clicks
    public void actionPerformed(ActionEvent ev) 
    {
        String sFrom, sTo;
        double dFrom, dTo;
        
        // Get input from text field
        sFrom = jtfFrom.getText().trim();
        
        // Validate input
        if (sFrom.isEmpty()) 
        {
            JOptionPane.showMessageDialog(this, "Please enter a temperature value", 
                                        "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            dFrom = Double.parseDouble(sFrom);
            
            if (ev.getSource() == jbtFtoC) 
            {
                // Convert Fahrenheit to Celsius
                dTo = 5.0 / 9.0 * (dFrom - 32.0);
                sTo = String.format("%.2f", dTo);
                jtfTo.setText(sTo);
            } else if (ev.getSource() == jbtCtoF) 
            {
                // Convert Celsius to Fahrenheit
                dTo = (9.0 / 5.0 * dFrom) + 32.0;
                sTo = String.format("%.2f", dTo);
                jtfTo.setText(sTo);
            }
        } catch (NumberFormatException e) 
        {
            JOptionPane.showMessageDialog(this, "Please enter a valid number", 
                                        "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}