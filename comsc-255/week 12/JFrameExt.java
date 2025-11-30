package as17;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameExt extends JFrame implements ActionListener {
    private JPanelExt jpe = new JPanelExt();
    private JPanel jp = new JPanel();
    
    private JButton jbtHappy = new JButton("Happy");
    private JButton jbtSad = new JButton("Sad");
    private JButton jbtPicture = new JButton("Picture");
    
    public JFrameExt() {
        super("Face and Picture Display");
        
        // Create main panel and set as content pane
        JPanel jpMain = new JPanel();
        jpMain.setLayout(new BorderLayout());
        setContentPane(jpMain);
        
        // Add panels to main panel
        jpMain.add(jpe, BorderLayout.CENTER);
        jpMain.add(jp, BorderLayout.SOUTH);
        
        // Add buttons to south panel
        jp.add(jbtHappy);
        jp.add(jbtSad);
        jp.add(jbtPicture);
        
        // Register action listeners
        jbtHappy.addActionListener(this);
        jbtSad.addActionListener(this);
        jbtPicture.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbtHappy) {
            jpe.setPictureType("Happy");
        } else if (e.getSource() == jbtSad) {
            jpe.setPictureType("Sad");
        } else if (e.getSource() == jbtPicture) {
            jpe.setPictureType("Picture");
        }
    }
}
