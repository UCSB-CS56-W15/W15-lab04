package edu.ucsb.cs56.w15.drawings.npoon.advanced;
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
import java.awt.geom.Arc2D;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;
/**
   A Basketball Court with Three Point markings
      
   @author Nicholas Poon
   @version for CS56, W11, UCSB, 02/23/2015
   
*/
public class ThreePointCourt extends BasketballCourt implements Shape
{
    /**
     * Constructor for objects of class ThreePointCourt
     */
    public ThreePointCourt(double x, double y, double width)
    {
		
	// construct the basic bball court shell
	super(x,y,width);
		double height = width / 2;	

	GeneralPath gp = this.get();
	

	// make the lines for 3 point line

	   // **RIGHT SIDE**	

		Line2D.Double r1 = 
			new Line2D.Double(x, y + height/8, x + width / 5, y + height/8);

		Line2D.Double r2 = 
			new Line2D.Double(x, y + 7 * height/8, x + width / 5, y + 7 * height/8);
	
	
	   // **LEFT SIDE**
	
		Line2D.Double l1 = 
			new Line2D.Double(x + 4 * width/5, y + height/8, x + width, y + height/8);

		Line2D.Double l2 = 
			new Line2D.Double(x + 4 * width/5, y + 7 * height/8, x + width, y + 7 * height/8);

	// ARCS
	
	Arc2D.Double rightarc =
		new Arc2D.Double(x + 4*width/5 - width/8, y + height/8, 2*width/8, 6*height/8, 90, 180, 	Arc2D.OPEN);
	
	Arc2D.Double leftarc =
		new Arc2D.Double(x + width/15 , y + height/8, 2*width/8, 6*height/8, 90, -180, Arc2D.OPEN);

	
	//putting everything together
        GeneralPath wholeCourt = this.get();
        wholeCourt.append(r1, false);
        wholeCourt.append(r2, false);
	wholeCourt.append(l1, false);
        wholeCourt.append(l2, false);
	wholeCourt.append(rightarc, false);
	wholeCourt.append(leftarc, false);
    }

}
