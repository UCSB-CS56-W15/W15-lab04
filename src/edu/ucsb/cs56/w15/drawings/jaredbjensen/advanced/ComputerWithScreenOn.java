package edu.ucsb.cs56.w15.drawings.jaredbjensen.advanced;
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

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;
/**
   A computer with screen on
      
   @author Phill Conrad
   @author Jared Jensen
   @version for CS56, W15, UCSB, 02/20/2015
   
*/
public class ComputerWithScreenOn extends Computer implements Shape
{
    /**
     * Constructor for objects of class ComputerWithScreenOn
     */
    public ComputerWithScreenOn(double x, double y, double width, double height)
    {
	// construct the basic computer shell
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	

	Rectangle2D.Double win1 =
	    new Rectangle2D.Double(x + width/14, y - height/7, 6*width/7, height/14);
	Rectangle2D.Double win2 =
	    new Rectangle2D.Double(x + width/7, y - 6*height/7, width/14, height/14);
	Rectangle2D.Double win3 =
	    new Rectangle2D.Double(x + width/7, y - 5*height/7, width/14, height/14);


        GeneralPath wholeComp = this.get();
        wholeComp.append(win1, false);
        wholeComp.append(win2, false);
        wholeComp.append(win3, false); 
    }

}
