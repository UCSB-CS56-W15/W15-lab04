package edu.ucsb.cs56.w15.drawings.marshallnaito.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;
import java.awt.Color; // class for Colors


import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;
/**
   A Stop Light
      
   @author Marshall Naito
   @version for CS56, W15, UCSB, 02/10/2015
   
*/
public class StopLight extends Pole implements Shape
{
    /**
     * Constructor for objects of class Pole
     */

    public StopLight(double x, double y, double width, double height)
    {

    	super(x,y,width,height);

        //declare variables
    	GeneralPath gp = this.get();

    	double lightWidth = 0.1 * height;
    	double lightHeight =  0.3 * height;
    	double lightRadius = 0.33 * lightHeight;

        double straightBottom = y-height;

        double bendWidth = x + 0.75 * height;
        double bendHeight = straightBottom - height/10;

        //create shapes for stoplight
    	Rectangle2D.Double stopFrame = new Rectangle2D.Double( bendWidth , straightBottom, lightWidth, lightHeight);
    	
    	Line2D.Double stopPole = new Line2D.Double( x , straightBottom , bendWidth , straightBottom);

    	Ellipse2D.Double l1 = new Ellipse2D.Double( bendWidth , straightBottom, lightRadius, lightRadius);
  

    	Ellipse2D.Double l2 = new Ellipse2D.Double( bendWidth , straightBottom+lightRadius, lightRadius, lightRadius);

    	Ellipse2D.Double l3 = new Ellipse2D.Double( bendWidth , straightBottom+2*lightRadius, lightRadius, lightRadius);

        //create and add everything to generalpath wrapper
        GeneralPath wholeLight = this.get();
        wholeLight.append(stopFrame, false);
        wholeLight.append(stopPole, false);
        wholeLight.append(l1, false);
        wholeLight.append(l2, false);
        wholeLight.append(l3, false);

    }

}
