package edu.ucsb.cs56.w15.drawings.ryanpeffers.advanced;

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
   A vector drawing of a car that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Ryan Peffers
   @version for CS56, Winter 15, UCSB
   
*/
public class Car extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of car
       @param y y coord of lower left corner of car
       @param length length of the car
       @param height of car
     */
    public Car(double x, double y, double length, double height)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
	//        double firstStoryHeight = .75 * height;
	//        double roofHeight = height - firstStoryHeight;
        double underSide1 = 0.15 * length;
	double bumper2 = 0.66 * height;
	double trunkLength3 = underSide1;
	double rearWindow4 = 1.4142 * 0.34 * height; // length of 45 degree angle windows
	double frontWindow9 = 2 * 0.34 * height; //length of 30 degree angle windows
	double hood6 = 0.3 * length;
	double roof5 = (0.55 * length) - (0.34 * height) - (0.866 * frontWindow9);
	double UnderSide7 = length - (2 * underSide1) - (0.24 * length);
	double wheelWellLength8 = 0.12*length;
	
	//        double firstStoryUpperLeftY = y + roofHeight;
        
        // Make the first story
        /*
        Rectangle2D.Double firstStory = 
            new Rectangle2D.Double(x, firstStoryUpperLeftY ,
                          width, firstStoryHeight);
	*/                
        // make the roof.   Remember that y goes DOWN the page,
        // so we ADD to y to get a "lower" value on the screen
        
	Line2D.Double rearUnderSide = new Line2D.Double (x, y, x + underSide1, y);
	Line2D.Double rearBumper = new Line2D.Double (x, y, x, y - bumper2);
	Line2D.Double trunkLength = new Line2D.Double (x, y - bumper2, x + trunkLength3, y - bumper2);
	Line2D.Double rearWindow = 
	    new Line2D.Double (x+underSide1, y-bumper2, x+underSide1+(0.34*height), y - height);
	Line2D.Double roof = 
	    new Line2D.Double 
	    (x+underSide1+(0.34*height), y-height, x+(0.7*length)-(0.866*frontWindow9), y - height);
	Line2D.Double frontWindow = 
	    new Line2D.Double 
	    (x+(0.7*length)-(0.866*frontWindow9), y-height, x+(0.7*length), y-bumper2);
	Line2D.Double hood = new Line2D.Double (x+(0.7*length), y-bumper2, x+length, y-bumper2);
	Line2D.Double frontBumper = new Line2D.Double (x+length, y-bumper2, x+length, y);
	Line2D.Double frontUnderSide = new Line2D.Double (x+length, y, x+length-underSide1, y);
	Line2D.Double UnderSide = 
	    new Line2D.Double 
	    (x+underSide1+wheelWellLength8, y, x+length-underSide1-wheelWellLength8, y);
	
	// Size of wheel will be radius = 0.06 * length which leaves a 0.12 * length wheel well
	
        // put the whole car together
       
        GeneralPath wholeCar = this.get();
        wholeCar.append(rearUnderSide, false);
        wholeCar.append(rearBumper, false);
        wholeCar.append(trunkLength, false); 
        wholeCar.append(rearWindow, false); 
	wholeCar.append(roof, false); 
	wholeCar.append(frontWindow, false); 
	wholeCar.append(hood, false); 
	wholeCar.append(frontBumper, false); 
	wholeCar.append(frontUnderSide, false); 
	wholeCar.append(UnderSide, false); 

    }

}
