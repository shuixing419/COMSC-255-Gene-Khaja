package as2;

import javax.swing.JOptionPane;

class Rectangle {
	private double length;
    private double width;
    public Rectangle (double l, double w)
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
    public double calculateArea()
    {
    	return (length*width);
    }
    public double calculatePerimeter()
    {
    	return (2*length + 2*width);
    }
}

class TestRectangle {

	public static void main(String[] args) {
		String in, out;
        double l, w;
        double area, perim;

        //Input length for the first object
        //It will be in text form. So, convert it to a double form
        in=JOptionPane.showInputDialog ("Enter length");
        l=Double.parseDouble (in);

         //Input width for the first object
        //It is a in a String format. Convert it to double
        in=JOptionPane.showInputDialog ("Enter width");
        w=Double.parseDouble (in);

       //Create the first Rectangle object
        Rectangle r1 = new Rectangle (l, w);

       //Input length for the second object
        //It is in String format. Convert it to a double
        in=JOptionPane.showInputDialog ("Enter length");
        l=Double.parseDouble (in);     

        //Input width for the second object
        in=JOptionPane.showInputDialog ("Enter width");
        w=Double.parseDouble (in);

       //create the second Rectangle object
        Rectangle r2 = new Rectangle (l, w);

        //Call methods of the first Rectangle object
        l = r1.getLength( );
        w= r1.getWidth( );
        area= r1.calculateArea( );
        perim= r1.calculatePerimeter( );

        out="First Rectangle:\n";
        out=out + "Length: " + l + "\n";
        out= out + "Width: " + w + "\n";
        out= out + "Area: " + area + "\n";
        out= out + "Perimeter: " + perim + "\n";
        
        l = r2.getLength( );
        w= r2.getWidth( );
        area= r2.calculateArea( );
        perim= r2.calculatePerimeter( );

        out=out+"\nSecond Rectangle:\n";
        out=out + "Length: " + l + "\n";
        out= out + "Width: " + w + "\n";
        out= out + "Area: " + area + "\n";
        out= out + "Perimeter: " + perim + "\n";


        //display the value of variable out in a single dialog box
        JOptionPane.showMessageDialog (null, out); 
        System.exit(0);                           

	}

}