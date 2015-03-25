package edu.ucsb.cs56.w15.drawings.vonmeier.advanced;
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
   A vector drawing of an Ornament that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Ishi von Meier
   @version for CS56, Winter 15, UCSB
   
*/
public class Balls extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of tree
       @param y y coord of lower left corner of tree
       @param width width of the tree
       @param height of tree (including stump and branches)
     */

		public Balls(double x, double y, double width, double height)
		{

		// get the GeneralPath that we are going to append stuff to
		GeneralPath gp = this.get();
	

		double startX = x + 0.25 * width;
		double startY = y + 0.8 * height;
		double winHt =  0.25 * height;
		double xRad = width/20;
		double yRad = height/20;
	
		Line2D.Double leftSide = new Line2D.Double (startX, startY, startX, startY + .75*yRad);
		Line2D.Double rightSide = new Line2D.Double (startX+xRad, startY, startX+xRad, startY + .75*yRad);
	
		Arc2D leftNut=new Arc2D.Double(startX-.5*xRad, startY+.75*yRad, xRad, yRad, 90, 270,  Arc2D.OPEN);
	  	Arc2D rightNut=new Arc2D.Double(startX+.5*xRad, startY+.75*yRad, xRad, yRad, 90, -270,  Arc2D.OPEN);


	
		// add the balls to the pane
		// Look up the meaning of the second parameter of append
		// (Hint--is a method of "GeneralPath")

		    GeneralPath wholeBalls = this.get();
		    wholeBalls.append(leftSide, false);
		    wholeBalls.append(rightSide, false);
		    wholeBalls.append(leftNut, false); 
		    wholeBalls.append(rightNut, false); 
		}

}
