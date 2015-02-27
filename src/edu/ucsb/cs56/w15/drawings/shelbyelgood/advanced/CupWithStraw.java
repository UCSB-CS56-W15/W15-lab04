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
    
        //call Cup constructor
	super(x,y,width,height);

	//draw all parts of the straw
	Line2D.Double leftMainStraw = new Line2D.Double(x+width/2,y+width/8,x+3*width/4,y-5*height/4);
	Line2D.Double rightMainStraw = new Line2D.Double(x+width/2+width/10,y+width/8,x+3*width/4+width/10,y-5*height/4);       
       Ellipse2D.Double topOfStraw = new Ellipse2D.Double(x+3*width/4,y-5*height/4-width/40,width/10,width/20);
	Ellipse2D.Double bottomOfStraw = new Ellipse2D.Double(x+width/2,y+width/8-width/40,width/10,width/20);

	//append all parts of cup
        GeneralPath wholeStraw = this.get();
	wholeStraw.append(leftMainStraw, false);  
	wholeStraw.append(rightMainStraw, false);
	wholeStraw.append(topOfStraw, false);
	wholeStraw.append(bottomOfStraw, false);
       
    }

}


