package edu.ucsb.cs56.w15.drawings.gaberome.advanced;
import java.awt.geom.GeneralPath;
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
 * Circle extends Ellipse2D to make it easier to draw circles
 * because the parameters to the constructor are more convenient
 * 
 * @author P. Conrad  
 * @version CS56, Spring 2013, UCSB
 */
public class Ball extends GeneralPathWrapper implements java.awt.Shape
{ 
    /**
     * Constructor for objects of class Circle
     * @param x    x coordinate of center of circle
     * @param y    y coordinate of center of circle
     * @param r    radius of circle
     */
    public Ball(double x, double y, double r)
    {
       
	Circle Ball = new Circle(x, y, r);
	
	GeneralPath BALL = this.get();
	BALL.append(Ball, false);
     
    }
    
}
