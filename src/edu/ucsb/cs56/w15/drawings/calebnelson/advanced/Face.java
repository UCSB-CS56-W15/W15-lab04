package edu.ucsb.cs56.w15.drawings.calebnelson.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a house that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Caleb Nelson, Phill Conrad 
   @version for CS56, Winter 15, UCSB
   
*/
public class Face extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of house
       @param y y coord of lower left corner of house
       @param width width of the house
       @param height of house (including first story and second story)
     */
    public Face(double x, double y, double width, double height)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
        double eyeHeight = .25 * height;
        double eyeUpperLeftY = y + eyeHeight;
        double eyeRatio = .3;

        double mouthHeight = .75 * height;
	double mouthUpperLeftY = y + mouthHeight;
	double mouthLength = .6;
	double mouthStart = .2;

        // Draw the head

	Ellipse2D.Double head = 
	    new Ellipse2D.Double(x, y, width, height);
        
	// Draw the eyes

        Ellipse2D.Double leftEye = 
            new Ellipse2D.Double(x + (width * ((.5 - eyeRatio)/2)), eyeUpperLeftY,
                          width * eyeRatio, height * eyeRatio);
        
	Ellipse2D.Double rightEye = 
            new Ellipse2D.Double(x + (width * (.5 + ((.5 - eyeRatio)/2))), eyeUpperLeftY,
                          width * eyeRatio, height * eyeRatio);

        // make the roof.   Remember that y goes DOWN the page,
        // so we ADD to y to get a "lower" value on the screen
        
        Line2D.Double mouth = 
            new Line2D.Double (x + (width * mouthStart), mouthUpperLeftY,
                               x + (width * (mouthStart + mouthLength)), mouthUpperLeftY);

        // put the whole face together
       
        GeneralPath wholeFace = this.get();
	wholeFace.append(head, false);
        wholeFace.append(leftEye, false);
	wholeFace.append(rightEye, false); 
        wholeFace.append(mouth, false);
    }

}
