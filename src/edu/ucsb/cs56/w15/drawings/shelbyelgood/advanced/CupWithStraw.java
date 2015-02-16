package edu.ucsb.cs56.w15.drawings.shelbyelgood.advanced;
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
   A vector drawing of a cup with a straw that extends the Cup Class
   and implements the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Shelby Elgood
   @version for CS56, Winter 15, UCSB
   
*/
public class CupWithStraw extends Cup implements Shape
{
    /**
       Constructor

       @param x x coord of lower left of cup
       @param y y coord of lower left of cup
       @param width diameter of bottom of cup
       @param height height of cup
     */
    public CupWithStraw(double x, double y, double width, double height)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
	super(x,y,width,height);
	Line2D.Double leftMainStraw = new Line2D.Double(x+width/2,y+width/8,x+3*width/4,y-5*height/4);
	Line2D.Double rightMainStraw = new Line2D.Double(x+width/2+width/10,y+width/8,x+3*width/4+width/10,y-5*height/4);       

	//Line2D.Double leftUpperStraw = new Line2D.Double(x+3*width/4,y-5*height/4,x+4*width/3,y-9*height/8);
       Ellipse2D.Double topOfStraw = new Ellipse2D.Double(x+3*width/4,y-5*height/4-width/40,width/10,width/20);
	Ellipse2D.Double bottomOfStraw = new Ellipse2D.Double(x+width/2,y+width/8-width/40,width/10,width/20);
	 /*	Ellipse2D.Double bottomOfCup = new Ellipse2D.Double(x,y,width, width/4);
        Ellipse2D.Double topOfCup = new Ellipse2D.Double(x-width/4,y-height,3*width/2, width/4);
	Line2D.Double leftEdge = new Line2D.Double(x,y+width/8,x-width/4,y+width/8-height);
	Line2D.Double rightEdge = new Line2D.Double(x+width,y+width/8,x+5*width/4,y+width/8-height);
	 */

 /*
        Rectangle2D.Double firstStory = 
            new Rectangle2D.Double(x, firstStoryUpperLeftY ,
                          width, firstStoryHeight);
                          
        // make the roof.   Remember that y goes DOWN the page,
        // so we ADD to y to get a "lower" value on the screen
        
        Line2D.Double leftRoof = 
            new Line2D.Double (x, y + roofHeight,
                               x + width/2.0, y);
                               
        Line2D.Double rightRoof =
            new Line2D.Double (x + width/2.0, y,
                               x + width, y + roofHeight);

        // put the whole house together
 */      
        GeneralPath wholeCup = this.get();
//        wholeCup.append(bottomOfCup, false);
//	wholeCup.append(topOfCup, false);
//	wholeCup.append(leftEdge, false);
//	wholeCup.append(rightEdge, false);
	wholeCup.append(leftMainStraw, false);  
	wholeCup.append(rightMainStraw, false);
	wholeCup.append(topOfStraw, false);
	wholeCup.append(bottomOfStraw, false);
    // wholeHouse.append(leftRoof, false);
       // wholeHouse.append(rightRoof, false); 
       
    }

}


