package edu.ucsb.cs56.w15.drawings.zhu.advanced;
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
   A Boat with Chimney

   @author Yuxiang Zhu 
   @version for CS56, W15, UCSB, 02/02/2015
   
*/
public class BoatWithChimney extends Boat implements Shape
{
    /**
     * Constructor for objects of class BoatWithChimney
     */
    public BoatWithChimney(double x, double y, double width, double height)
    {
	// construct the basic house shell
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();

	// make a chimney at the head of the boat

	double widthOfChimney = 0.1 * width;
	double heightOfChimney = 0.2 * height;

	Rectangle2D.Double chimney =
	    new Rectangle2D.Double(x + 0.2 * width, y - 0.8* height , widthOfChimney, heightOfChimney);

	
	// add the chimney to the boat
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholeBoat = this.get();
        wholeBoat.append(chimney, false);
    }

}
