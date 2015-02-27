package edu.ucsb.cs56.w15.drawings.rrthirumulu.advanced;
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
   A Bottle
      
   @author Raghav Raju 
   @version for CS56, W15, UCSB, 02/19/2015
   
*/
public class BottleWithCork extends Bottle implements Shape
{
    /**
     * Constructor for objects of class BottleWithCork
     */
    public BottleWithCork(double x, double y, double width, double height)
    {
	// construct the basic bottle shell
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	double corkWidth = 0.8 * (0.5 * width);
	double corkBottomLeft = (x + (0.1 * 0.5 * width)) - (0.75 * width);
	double corkHeight =  0.6 * corkWidth;

	Rectangle2D.Double bot1 =
	    new Rectangle2D.Double(corkBottomLeft, y - height - corkHeight, corkWidth, corkHeight);

	
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholeBottle = this.get();
        wholeBottle.append(bot1, false);
        
    }

}
