package edu.ucsb.cs56.w15.drawings.kevinlau.advanced;
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
   A vector drawing of a house that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Phill Conrad 
   @version for CS56, Winter 11, UCSB
   
*/
public class tv extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of house
       @param y y coord of lower left corner of house
       @param width width of the house
       @param height of house (including first story and second story)
     */
    public tv(double x, double y, double width, double height)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
        double screenHeight = height * .8 ;
        double screenWidth = width * .8 ; 
        double screenX = x + (width * .10);
		double screenY = y + (height * .10); 
        // Make the first story
        
        Rectangle2D.Double bezel = 
            new Rectangle2D.Double(x, y ,
                          width, height);
						  
        
		Rectangle2D.Double screen = 
            new Rectangle2D.Double(screenX, screenY ,
                          screenWidth, screenHeight);                  
        // make the roof.   Remember that y goes DOWN the page,
        // so we ADD to y to get a "lower" value on the screen
        
        

        // put the whole house together
       
        GeneralPath wholeTv = this.get();
        wholeTv.append(bezel, false);
        wholeTv.append(screen, false);
        
        
    }

}

