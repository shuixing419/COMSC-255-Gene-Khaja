package as12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class JFrameExt extends JFrame implements ActionListener 
{
    private JPanel jpMain = new JPanel(); //mainPanel is the content Panel
    
    private JPanel jpNumber1 = new JPanel();
    private JPanel jpNumber2 = new JPanel();
    private JPanel jpResult = new JPanel();
    private JPanel jpOption = new JPanel();
    
    private JLabel jlbNumber1 = new JLabel("Number 1");
    private JLabel jlbNumber2 = new JLabel("Number 2");
    private JLabel jlbResult = new JLabel("Result");
    
    private JTextField jtfNumber1 = new JTextField(10);
    private JTextField jtfNumber2 = new JTextField(10);
    private JTextField jtfResult = new JTextField(10);
    
    private JButton jbtAdd = new JButton("Add");
    private JButton jbtSub = new JButton("Sub");
    private JButton jbtMult = new JButton("Mult");
    private JButton jbtDiv = new JButton("Div");
    private JButton jbtClear = new JButton("Clear");
    
    public JFrameExt() 
    {
        //make the panel jpMain as the content pane
        //so that everything in jpMain will show up in the frame
        //setContentPane is method inherited from JFrame
        this.setContentPane(jpMain);
        
        //Create grid layout manager object for rows and one column
        GridLayout g1 = new GridLayout(4, 1);
        
        //set the layout manager for jpMain to be above grid layout manager
        //a panel's default layout manager is FlowLayout
        jpMain.setLayout(g1);
        
        //add four panels in jpMain
        jpMain.add(jpNumber1); // add separated panels to main panel
        jpMain.add(jpNumber2);
        jpMain.add(jpResult);
        jpMain.add(jpOption);
        
        //set the background color of the four small panels
        jpNumber1.setBackground(Color.green);
        jpNumber2.setBackground(Color.red);
        jpResult.setBackground(Color.blue);
        jpOption.setBackground(Color.yellow);
        
        //add label, text field to the first two panels
        jpNumber1.add(jlbNumber1);
        jpNumber1.add(jtfNumber1);
        
        jpNumber2.add(jlbNumber2);
        jpNumber2.add(jtfNumber2);
        
        //add code to add the label and textfield to the third panel
        jpResult.add(jlbResult);
        jpResult.add(jtfResult);
        
        //add buttons to the fourth panel
        jpOption.add(jbtAdd);
        jpOption.add(jbtSub);
        jpOption.add(jbtMult);
        jpOption.add(jbtDiv);
        jpOption.add(jbtClear);
        
        //make the result text field to non-modifiable by the user
        jtfResult.setEditable(false);
        
        //enable input on each button by registering your reference with each one
        //by calling its method addActionListener and giving it your reference
        jbtAdd.addActionListener(this);
        jbtSub.addActionListener(this);
        jbtMult.addActionListener(this);
        jbtDiv.addActionListener(this);
        jbtClear.addActionListener(this);
        
        //Set default close operation
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    //The button event handler
    //This method is invoked when a button (whose input is enabled) is clicked
    public void actionPerformed(ActionEvent ev) 
    {
        String sNum1, sNum2, sResult;
        double dNum1, dNum2, dResult;
        
        if(ev.getSource() == jbtClear) 
        {
            sNum1 = "";
            sNum2 = "";
            sResult = "";
            jtfNumber1.setText(sNum1);
            jtfNumber2.setText(sNum2);
            jtfResult.setText(sResult);
            return;
        }
        
        //Get the input values
        sNum1 = jtfNumber1.getText().trim();
        sNum2 = jtfNumber2.getText().trim();
        
        //Check if inputs are empty
        if(sNum1.isEmpty() || sNum2.isEmpty()) 
        {
            JOptionPane.showMessageDialog(this, "Please enter both numbers", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try 
        {
            dNum1 = Double.parseDouble(sNum1);
            dNum2 = Double.parseDouble(sNum2);
            
            if(ev.getSource() == jbtAdd) 
            {
                dResult = dNum1 + dNum2;
                sResult = "" + dResult;
                jtfResult.setText(sResult);
            }
            else if(ev.getSource() == jbtSub) 
            {
                dResult = dNum1 - dNum2;
                sResult = "" + dResult;
                jtfResult.setText(sResult);
            }
            else if(ev.getSource() == jbtMult) 
            {
                dResult = dNum1 * dNum2;
                sResult = "" + dResult;
                jtfResult.setText(sResult);
            }
            else if(ev.getSource() == jbtDiv) 
            {
                if(dNum2 == 0) 
                {
                    JOptionPane.showMessageDialog(this, "Cannot divide by zero", "Math Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                dResult = dNum1 / dNum2;
                sResult = "" + dResult;
                jtfResult.setText(sResult);
            }
        } catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}