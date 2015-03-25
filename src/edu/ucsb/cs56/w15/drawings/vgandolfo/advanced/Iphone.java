package edu.ucsb.cs56.w15.drawings.vgandolfo.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
  A vector drawing of an iPhone that implements the Shape interface. 
   @author Vincent Gandolfo 
   @version for CS56, Winter 15, UCSB
   
*/
public class Iphone extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of iPhone
       @param y y coord of lower left corner of iPhone
       @param width width of the iPhone
       @param height of the iPhone
     */
    public Iphone(double x, double y, double width, double height)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
  
      
        
        // Make the first story
        
        Rectangle2D.Double body = 
            new Rectangle2D.Double(x, y ,
                          width, height);
          

	double halfOfWidth = width/2.0;
	Ellipse2D.Double homeButton = 
           new Ellipse2D.Double
           (
	    x + halfOfWidth - halfOfWidth * .1,
             y + height - height * .09,
	    width * .1,
	    width * .1
           );

	  Rectangle2D.Double screen = 
            new Rectangle2D.Double(x + width * .15, y + height * .047 ,
                          width * .7 , height * .85);
          
	

                
        
	//  Remember that y goes DOWN the page,
        // so we ADD to y to get a "lower" value on the screen
        
  
        // put the whole house together
       
        GeneralPath wholeIphone = this.get();
        wholeIphone.append(body, false);
        wholeIphone.append(homeButton, false);
        wholeIphone.append(screen, false); 
        
    }

}
