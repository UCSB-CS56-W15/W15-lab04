package edu.ucsb.cs56.w15.drawings.brianyan.advanced;
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
   A TV with stand
      
   @author Phill Conrad 
   @author Brian Yan
   @version for CS56, W15, UCSB, 02/6/2015
   
*/
public class TelevisionwithStand extends Television implements Shape
{
    /**
     * Constructor for objects of class TelevisionwithStand
     
       @param x x coor of top left corner
       @param y y coor of top left corner 
       @param side side length of TV
     */
    public TelevisionwithStand(double x, double y, double side)
    {   
	super(x,y,side);
	double bot = y+side;

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();

	//variables for stand length and height
	double w1 = x + (0.4  * side);
	double w2 = x + (0.6  * side);
	double h1 = bot + (0.25 * side);
	double h2 = bot + (0.50 * side);

	//drawing the stand
	Line2D.Double stand1 =
	    new Line2D.Double(w1,bot,w1,h1);
	Line2D.Double stand2 = 
	    new Line2D.Double(w2,bot,w2,h1);
	Line2D.Double stand3 =
	    new Line2D.Double(w1,h1,x,h1);
	Line2D.Double stand4 = 
	    new Line2D.Double(w2,h1,x+side,h1);
	Line2D.Double stand5 = 
	    new Line2D.Double(x,h1,x,h2);
	Line2D.Double stand6 =
	    new Line2D.Double(x+side,h1,x+side,h2);
	Line2D.Double stand7 = 
	    new Line2D.Double(x,h2,x+side,h2);
	gp.append(stand1,false);
	gp.append(stand2,false);
	gp.append(stand3,false);
	gp.append(stand4,false);
	gp.append(stand5,false);
	gp.append(stand6,false);
	gp.append(stand7,false);
	      
	    
    }
}

