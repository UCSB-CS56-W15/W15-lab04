package edu.ucsb.cs56.w15.drawings.triptisinghal.advanced;
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
   An Ant
      
   @author Phill Conrad 
   @version for CS56, W11, UCSB, 02/23/2011
   
*/
public class AntWithFace extends Ant implements Shape
{
    /**
     * Constructor for objects of class CoffeeCup
     */
    public AntWithFace(double x, double y, double r)
    {
	// construct the basic house shell
	super(x,y,r);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	double eyeRadius = r/8;
	double eye1XCoord = x +.5*r;
	double eye1YCoord = y +.5*r;
	double eye2XCoord = x + 1.25*r;
	double eye2YCoord = y +.5*r;
	

	Circle eye_1 = new Circle(eye1XCoord,eye1YCoord,eyeRadius);
	Circle eye_2 = new Circle(eye2XCoord,eye2YCoord,eyeRadius);
	Line2D.Double mouth = new Line2D.Double(eye1XCoord, eye1YCoord + .75*r, eye2XCoord +2*eyeRadius,eye1YCoord + .75*r);
	
	// add the face to the ant

        GeneralPath wholeAnt= this.get();
        wholeAnt.append(eye_1, false);
        wholeAnt.append(eye_2, false);
        wholeAnt.append(mouth, false); 
    }

}
