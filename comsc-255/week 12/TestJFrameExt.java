package as17;

import javax.swing.JFrame;

public class TestJFrameExt {
    public static void main(String[] args) {
        // Create JFrameExt object
        JFrameExt frame = new JFrameExt();
        
        // Set size and make visible
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
