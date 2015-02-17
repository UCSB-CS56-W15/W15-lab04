package edu.ucsb.cs56.w15.drawings.jingzhou.advanced;
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
   A vector drawing of an Iphone that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Jingzhou Xue
   @version for CS56, Winter 15, UCSB
   
*/
public class Iphone extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of Iphone
       @param y y coord of lower left corner of Iphone
       @param width width of the Iphone
       @param length length of the Iphone
     */
    public Iphone(double x, double y, double width, double length)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
        //double firstStoryHeight = .75 * height;
        //double roofHeight = height - firstStoryHeight;
        
        //double firstStoryUpperLeftY = y + roofHeight;
        
        // Make the first story
        
        //Rectangle2D.Double firstStory = 
        //    new Rectangle2D.Double(x, firstStoryUpperLeftY ,
         //                 width, firstStoryHeight);
                          
        // make the roof.   Remember that y goes DOWN the page,
        // so we ADD to y to get a "lower" value on the screen
        
        //Line2D.Double leftRoof = 
        //    new Line2D.Double (x, y + roofHeight,
        //                       x + width/2.0, y);
                               
        //Line2D.Double rightRoof =
        //    new Line2D.Double (x + width/2.0, y,
        //                       x + width, y + roofHeight);

        // put the whole house together
       
        //GeneralPath wholeHouse = this.get();
        //wholeHouse.append(firstStory, false);
        //wholeHouse.append(leftRoof, false);
        //wholeHouse.append(rightRoof, false); 
        
		
		//TODO
		 // Make the outer rectangle
        double innerRecLength = length*6/10;
	double innerRecWidth = width*24/30;
	double innerRecUpperLeftX = x + width *3/30;
	double innerRecUpperLeftY = y + length*2/10;	
        Rectangle2D.Double OuterRec = 
		new Rectangle2D.Double(x, y, width, length);
	Rectangle2D.Double InnerRec = 
		new Rectangle2D.Double(innerRecUpperLeftX, innerRecUpperLeftY, innerRecWidth, innerRecLength);
		GeneralPath IphoneScreen = this.get();
		IphoneScreen.append(OuterRec,false);
		IphoneScreen.append(InnerRec,false);
		
    }

}
