package edu.ucsb.cs56.w15.drawings.glee.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;
/**
   A Car with windows!
      
   @author Geon Hee Lee 
   @version for CS56, W15, UCSB, 02/7/2015
   
*/
public class CarWithWindows extends Car implements Shape
{
    /**
     * Constructor for objects of class Car
     */
    public CarWithWindows(double x, double y, double width, double height)
    {
	// construct the basic car 
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();

	double windowDiameter = width/5.0;
	double x1 = x + (width/4.0) + windowDiameter/10.0;
	double x2 = (x+width) - (width/2.0) + windowDiameter/10.0;
	double y1 = y + height/8.0;

	Ellipse2D.Double win1 =
	    new Ellipse2D.Double(x1, y1, windowDiameter, windowDiameter);
	Ellipse2D.Double win2 =
	    new Ellipse2D.Double(x2, y1, windowDiameter, windowDiameter);

        GeneralPath wholeCar = this.get();
        wholeCar.append(win1, false);
        wholeCar.append(win2, false);
    }

}
