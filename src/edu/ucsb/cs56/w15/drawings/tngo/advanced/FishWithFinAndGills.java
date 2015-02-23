package edu.ucsb.cs56.w15.drawings.tngo.advanced;
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
   A Fish
      
   @author Tamky Ngo 
   @version for CS56, W15, UCSB, 01/31/2015
   
*/
public class FishWithFinAndGills extends Fish implements Shape
{
    /**
     * Constructor for objects of class FishWithFinAndGills
     */
    public FishWithFinAndGills(double x, double y, double width, double height)
    {
	// construct the basic house shell
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	// Make three vertical lines representing gills on a fish
	// Make fin that looks similar to the tail but is smaller
	//        and is situated in the middle of the fish body.

	double startOfGillLine = y + height/3;
	double endOfGillLine = y + (height*2)/3;
	double startOfFiny = y + height/2;

	Line2D.Double gill1 =
	    new Line2D.Double(x + width/5, startOfGillLine, x + width/5, endOfGillLine);
	Line2D.Double gill2 =
	    new Line2D.Double(x + width/5 + 5, startOfGillLine, x + width/5 + 5, endOfGillLine);
	Line2D.Double gill3 =
	    new Line2D.Double(x + width/5 + 10, startOfGillLine, x + width/5 + 10, endOfGillLine);
	Line2D.Double topOfFin =
	    new Line2D.Double(x + (width*2)/5, startOfFiny, x + (width*3)/5, startOfFiny);
	Line2D.Double rightSideOfFin =
	    new Line2D.Double(x + (width*3)/5, startOfFiny, x + width/2, startOfFiny + height/2 - 20);
	Line2D.Double leftSideOfFin =
	    new Line2D.Double(x + width/2, startOfFiny + height/2 - 20, x + (width*2)/5, startOfFiny);
	
	// add gills and a fin for the fish
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholeFish = this.get();
        wholeFish.append(gill1, false);
        wholeFish.append(gill2, false);
        wholeFish.append(gill3, false);
	wholeFish.append(topOfFin, false);
	wholeFish.append(rightSideOfFin, false);
	wholeFish.append(leftSideOfFin, false);
    }

}
