package as14;

//JFrameExt.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JFrameExt extends JFrame implements ActionListener {
 private JPanel jpMain = new JPanel();
 private JPanel jpn = new JPanel();
 private JPanel jpc = new JPanel();
 
 private JLabel jlbGuess = new JLabel("Enter guess between 1 and 7");
 private JTextField jtfGuess = new JTextField(10);
 
 private JTextArea jtaMessage = new JTextArea(10, 40);
 private JScrollPane jspMessage;
 private Guess guess = null;

 public JFrameExt() {
     // Create GUI
     this.setContentPane(jpMain);
     
     // Set jpMain's layout to border layout
     BorderLayout bl = new BorderLayout();
     jpMain.setLayout(bl);
     
     // Put panels in jpMain
     jpMain.add(jpn, BorderLayout.NORTH);
     jpMain.add(jpc, BorderLayout.CENTER);
     
     // Set background colors
     jpn.setBackground(Color.green);
     jpc.setBackground(Color.yellow);
     
     // Add label and text field to panel jpn
     jpn.add(jlbGuess);
     jpn.add(jtfGuess);
     
     // Create scroll pane containing text area with scroll bars
     jspMessage = new JScrollPane(jtaMessage);
     jspMessage.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
     jspMessage.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
     
     // Add scroll pane to panel jpc
     jpc.add(jspMessage);
     
     // Make text area non-editable and set font
     jtaMessage.setEditable(false);
     jtaMessage.setFont(new Font("Monospaced", Font.PLAIN, 12));
     
     // Register with text field to receive enter key press events
     jtfGuess.addActionListener(this);
     
     // Create Guess object for starting the game first time
     guess = new Guess();
     
     // Display initial message
     jtaMessage.append("Game Started, Enter Your Guess\n");
     autoScroll();
 }
 
 public void actionPerformed(ActionEvent e) {
     String userGuess;
     if (e.getSource() == jtfGuess) {
         // Extract user guess from text field
         userGuess = jtfGuess.getText().trim();
         jtfGuess.setText("");
         
         // Call checkGuess and pass it user guess
         try {
             guess.checkGuess(userGuess);
             
             // If we get here, guess was correct
             jtaMessage.append(userGuess + " - Correct Guess\n\n");
             
             // Display summary report
             displaySummaryReport();
             
             // Start new game
             jtaMessage.append("New Game Started. Enter your guess\n");
             guess = new Guess();
             
         } catch (GuessOutOfRangeException ex) {
             jtaMessage.append(userGuess + " - " + ex.getMessage() + "\n");
         } catch (GuessNotWholeNumberException ex) {
             jtaMessage.append(userGuess + " - " + ex.getMessage() + "\n");
         } catch (GuessTooLargeException ex) {
             jtaMessage.append(userGuess + " - " + ex.getMessage() + "\n");
         } catch (GuessTooSmallException ex) {
             jtaMessage.append(userGuess + " - " + ex.getMessage() + "\n");
         }
         
         autoScroll();
     }
 }
 
 private void displaySummaryReport() {
     jtaMessage.append("=== SUMMARY REPORT ===\n");
     jtaMessage.append("Total Guesses: " + Guess.getTotalGuesses() + "\n");
     jtaMessage.append("Total Games: " + Guess.getTotalGames() + "\n");
     jtaMessage.append(String.format("Average Guesses: %.2f\n", Guess.getAverageGuesses()));
     jtaMessage.append("=====================\n\n");
 }
 
 private void autoScroll() {
     jtaMessage.setCaretPosition(jtaMessage.getDocument().getLength());
 }
}