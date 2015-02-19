package edu.ucsb.cs56.w15.drawings.alexis110907.advanced;
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
   A vector drawing of a santaHat that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Alexis Jimenez 
   @version for CS56, Winter 15, UCSB
   
*/
public class SantaHat extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param  x coord of peak of the santa hat
        @param  y coord of peak of the santa hat
       @param  width from center of the bottom of the hat to the side peak
       @param height of santa hat 
     */
    public SantaHat(double x, double y,double width,double height)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
        double bottomHatBandHeight = .25 * height;
        double heightOfTriangularPart = height - bottomHatBandHeight;
        double bottomBandUpperLeftY = y + heightOfTriangularPart;
	double bottomBandUpperLeftX = x - (width);
	double bandWidth = 2*width;
        
        // Make the bottom band
        
        Rectangle2D.Double bottomBand = 
            new Rectangle2D.Double(bottomBandUpperLeftX, bottomBandUpperLeftY ,
                          bandWidth, bottomHatBandHeight);
                          
        // make the triangular part of hat.   Remember that y goes DOWN the page,
        // so we ADD to y to get a "lower" value on the screen
        
        Line2D.Double leftSideOfHat = 
            new Line2D.Double (x, y,
                               bottomBandUpperLeftX,  bottomBandUpperLeftY);
                               
        Line2D.Double rightSideOfHat =
            new Line2D.Double (x, y,
                                bottomBandUpperLeftX + bandWidth,  bottomBandUpperLeftY);

	//make the cotton ball at the top
	Shape cottonBall = new Ellipse2D.Double(x-(width/4),y-(width/2), (width/2), (width/2));


        // put the whole house together
       
        GeneralPath entireSantaHat = this.get();
        entireSantaHat.append(bottomBand, false);
	entireSantaHat.append(leftSideOfHat, false);
	entireSantaHat.append(rightSideOfHat, false);
	entireSantaHat.append(cottonBall, false);
        
    }

}
