package edu.ucsb.cs56.w15.drawings.mohithingorani.advanced;
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
   Death race style missile addon
      
   @author Mohit Hingorani
   @version for CS56, W15, UCSB
   
*/
public class Batmobile extends Car implements Shape
{
    /**
     * Constructor for objects of class Batmobile
     */
    public Batmobile(double x, double y, double width, double height)
    {
	// construct the basic house shell
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	//GeneralPath gp = this.get();
	
	// Make three windows, spaced like this, where w=width/10.0;
	// | +--+ +--+ +--+ |
	// | |  | |  | |  | |
	// | +--+ +--+ +--+ |
	// |w 2w w 2w w w2 w|
	//
	// The top of window will be at y + 0.5*height and the
	// height of the window is 0.25height;


	double topMissilePositionX = x + width * 0.2 ;
	double topMissilePositionY = y + height * 0.18 ; 
	double topMissileLength = width * 0.3;
	double topMissileWidth = height *0.1;
	double missilePoint = topMissileWidth * 0.5;
	
	

	Rectangle2D.Double topMissile = new Rectangle2D.Double ( topMissilePositionX, topMissilePositionY , topMissileLength , topMissileWidth );
	Line2D.Double topPointer = new Line2D.Double ( topMissilePositionX + topMissileLength , topMissilePositionY , topMissilePositionX + topMissileLength * 1.3 ,  topMissilePositionY  + missilePoint );
	Line2D.Double bottomPointer = new Line2D.Double ( topMissilePositionX + topMissileLength , topMissilePositionY + topMissileWidth, topMissilePositionX + topMissileLength * 1.3 ,  topMissilePositionY  + missilePoint );


	// add the windows to the house
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath addMissile = this.get();
	addMissile.append(topMissile, false);
        addMissile.append(topPointer, false);
        addMissile.append(bottomPointer, false); 
    }

}
