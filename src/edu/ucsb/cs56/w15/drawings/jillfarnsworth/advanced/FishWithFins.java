package edu.ucsb.cs56.w15.drawings.jillfarnsworth.advanced;
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

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;
/**
   A Fish with Fins
      
   @author Jill Farnsworth
   @version for CS56, W15, UCSB, 02/06/2015
   
*/
public class FishWithFins extends Fish implements Shape
{
    /**
     * Constructor for objects of class FishWithFins

       @param x x coord of upper left corner of framing rectangle of fish body
       @param y y coord of upper left corner of framing rectangle of fish body
       @param w width of fish
       @param h height of fish
     */
    public FishWithFins(double x, double y, double w, double h)
    {
	// construct the basic fish
	super(x,y,w,h);

	// get the GeneralPath that we are going to append to
	GeneralPath gp = this.get();
	
	double topFinX = x + (w*0.65);
	double topFinY = y - (h/3);
	double bottomFinX = topFinX;
	double bottomFinY = y + h + (h/5);

	Line2D.Double topFinLeft = new Line2D.Double(x + w*0.375, y, topFinX, topFinY);
	Line2D.Double topFinRight = new Line2D.Double(topFinX, topFinY, x + w*0.75, y + h/2);
	Line2D.Double bottomFinLeft = new Line2D.Double(x + w*0.375, y + h, bottomFinX, bottomFinY);
	Line2D.Double bottomFinRight = new Line2D.Double(bottomFinX, bottomFinY, x + w*0.75, y + h/2); 

        GeneralPath wholeFish = this.get();
        wholeFish.append(topFinLeft, false);
        wholeFish.append(topFinRight, false);
        wholeFish.append(bottomFinLeft, false);
	wholeFish.append(bottomFinRight,false); 
    }

}
