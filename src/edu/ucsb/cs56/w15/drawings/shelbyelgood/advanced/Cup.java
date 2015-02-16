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
   A vector drawing of a cup that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Shelby Elgood
   @version for CS56, Winter 15, UCSB
   
*/
public class Cup extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left of cup
       @param y y coord of lower left of cup
       @param width diameter of bottom of cup
       @param height height of cup
     */
    public Cup(double x, double y, double width, double height)
    {       
     
	//draw all parts of the cup   
	Ellipse2D.Double bottomOfCup = new Ellipse2D.Double(x,y,width, width/4);
        Ellipse2D.Double topOfCup = new Ellipse2D.Double(x-width/4,y-height,3*width/2, width/4);
	Line2D.Double leftEdge = new Line2D.Double(x,y+width/8,x-width/4,y+width/8-height);
	Line2D.Double rightEdge = new Line2D.Double(x+width,y+width/8,x+5*width/4,y+width/8-height);

                         
	//append all parts of the cup       
        GeneralPath wholeCup = this.get();
        wholeCup.append(bottomOfCup, false);
	wholeCup.append(topOfCup, false);
	wholeCup.append(leftEdge, false);
	wholeCup.append(rightEdge, false);
    }

}

