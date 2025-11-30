package as16;

import javax.swing.*;
import java.awt.*;

public class PieChart extends JFrame{
	int x0 = 50, y0 = 50, x = 300, y = 300;
	String[] regionLabels = { "North", "South", "East", "West", "Midwest" };
	double[] regions;
	double[] angles;
	Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.YELLOW};
	JPanel jpMain = new JPanel();
	GridLayout gl = new GridLayout(1, 3);
	
	public PieChart(double n, double s, double e, double w, double mw) {
		int sum = 0;
		regions = new double[5]; //{NORTH, SOUTH, EAST, WEST, MIDWEST}
		angles = new double[5];
		
		regions[0] = n;
		regions[1] = s;
		regions[2] = e;
		regions[3] = w;
		regions[4] = mw;
		
		for(double d : regions) //compute a sum for percentages
			sum += d;
		
		for(int i = 0; i < 5; ++i) //compute percentages
			angles[i] = 360.0 * (regions[i] / sum);
	}
	
	public void paint(Graphics g) {
		x = this.getWidth();
		y = this.getHeight();
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, x, y);
		
		int temp = 0; //for fillArc, to remember the last angle printed out, and start from there in the next arc
		int space = 5; //spacing in between items in the legend
		int pieChartX = (x * 3) / 5; //piechart X dimension
		int pieChartY = (y * 3) / 5; //piechart Y dimension
		int offset = (y / 2) + 125; //amount of space from the piechart to the legend
		int legendRectangleX = 30; //X dimension of the rectangles in the legend
		int legendRectangleY = 10; //Y dimension of the rectangles in the legend
		
		for(int i = 0; i < 5; ++i) //draw pie chart and legend
		{
			g.setColor(colors[i]);
			g.fillArc(x0, y0, pieChartX, pieChartY, temp, (int)(angles[i] + .5));
			temp += (int)(angles[i] + .5);
			
			g.fillRect(x0, y0 + offset + (i*10) - legendRectangleY  + (space * i), legendRectangleX, legendRectangleY);
			g.drawString(regionLabels[i] + " - " + regions[i], x0 + legendRectangleX + 10, y0 + offset + (i*10) + (space * i));
		}
		
		
	}
}