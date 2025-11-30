package as17;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JPanelExt extends JPanel {
    private String pictureType = "Happy";

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (pictureType.equalsIgnoreCase("Happy")) {
            // Happy face drawing code
            g.setColor(Color.YELLOW);
            g.fillOval(50, 50, getWidth() - 100, getHeight() - 100);
            g.setColor(Color.BLACK);
            g.fillOval(getWidth()/2 - 60, getHeight()/2 - 30, 30, 30);
            g.fillOval(getWidth()/2 + 30, getHeight()/2 - 30, 30, 30);
            g.drawArc(getWidth()/2 - 75, getHeight()/2, 150, 100, 0, -180);
            
        } else if (pictureType.equalsIgnoreCase("Sad")) {
            // Sad face drawing code
            g.setColor(Color.CYAN);
            g.fillOval(50, 50, getWidth() - 100, getHeight() - 100);
            g.setColor(Color.BLACK);
            g.fillOval(getWidth()/2 - 60, getHeight()/2 - 30, 30, 30);
            g.fillOval(getWidth()/2 + 30, getHeight()/2 - 30, 30, 30);
            g.drawArc(getWidth()/2 - 75, getHeight()/2 + 50, 150, 100, 0, 180);
            
        } else if (pictureType.equalsIgnoreCase("Picture")) {
            // Picture drawing code - display random picture
            displayRandomPicture(g);
        }
    }

    private void displayRandomPicture(Graphics g) {
        try {
            // Generate random number from 1 to 6
            int randomNum = (int)(Math.random() * 6) + 1;
            String imageName = "image" + randomNum + ".jpg"; // or .gif
            
            // Try to load the image
            ImageIcon imageIcon = new ImageIcon(getClass().getResource(imageName));
            
            if (imageIcon.getImageLoadStatus() == java.awt.MediaTracker.COMPLETE) {
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            } else {
                // If image not found, display a placeholder
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(0, 0, getWidth(), getHeight());
                g.setColor(Color.BLACK);
                g.drawString("Image " + imageName + " not found", getWidth()/2 - 80, getHeight()/2);
                g.drawString("Using random color instead", getWidth()/2 - 80, getHeight()/2 + 20);
                
                // Display a colorful pattern as fallback
                displayColorPattern(g);
            }
        } catch (Exception e) {
            // Fallback if images are not available
            displayColorPattern(g);
        }
    }
    
    private void displayColorPattern(Graphics g) {
        // Create a colorful pattern as fallback when images are not available
        int width = getWidth();
        int height = getHeight();
        
        // Draw colored rectangles
        g.setColor(Color.RED);
        g.fillRect(0, 0, width/2, height/2);
        
        g.setColor(Color.GREEN);
        g.fillRect(width/2, 0, width/2, height/2);
        
        g.setColor(Color.BLUE);
        g.fillRect(0, height/2, width/2, height/2);
        
        g.setColor(Color.ORANGE);
        g.fillRect(width/2, height/2, width/2, height/2);
        
        g.setColor(Color.WHITE);
        g.drawString("Random Pattern Display", width/2 - 60, height/2);
    }

    public void setPictureType(String pictureType) {
        this.pictureType = pictureType;
        this.repaint();
    }
}
