package edu.ucsb.cs56.w15.drawings.tgetty.advanced;
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
   A House
      
   @author Taylor Getty
   @version for CS56, W15, UCSB, 02/13/2015
   
*/
public class DoorWithWindow extends Door implements Shape
{
    /**
     * Constructor for objects of class Door
     */
    public DoorWithWindow(double x, double y, double width, double height)
    {
	// construct the basic door shell
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	// Make one window, spaced like this, where w=width*.4;
	// The top of window will be at y + 0.55*height and the
	// height of the window is 0.2height;

	double winLeft = x + 0.25 * width;
	double winRight = x + 0.75 * width;
	double winBottom = y + 0.15 * height;
	double winTop = y + 0.45 * height;

	Line2D.Double windowVert =
	    new Line2D.Double(x + width * .5, winTop, x + width * .5, winBottom);

	Line2D.Double windowHoriz = 
	    new Line2D.Double(winLeft, y + height * .25, winRight, y + height * .25);

	//add keyHole to the door in form of ellipse

	Ellipse2D.Double keyHole =
	    new Ellipse2D.Double( x + .85*width, y + .7*height, .08*width, .05*height);
	
	// add the windows to the house
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholeDoor = this.get();
        wholeDoor.append(windowVert, false);
	wholeDoor.append(windowHoriz, false);
	wholeDoor.append(keyHole, false);
    }

}
