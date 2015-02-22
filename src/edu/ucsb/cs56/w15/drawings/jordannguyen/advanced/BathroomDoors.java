package edu.ucsb.cs56.w15.drawings.jordannguyen.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;
/**
   Bathroom Doors
      
   @author Jordan Nguyen
   @version for CS56, W15, UCSB, 02/12/2015
   
*/
public class BathroomDoors extends Door implements Shape
{
    /**
     Constructor for objects of class BathroomDoors. This creates
     two doors, one for men and one for women.
     @param x upper left x-coordinate of first door
     @param y upper left y-coordinate of first door
     @param width width of both doors
     @param height height of both doors
     @param distance distance between the two doors
     */
    public BathroomDoors(double x, double y, double width, 
			 double height, double distance)
    {
	// construct the first door
	super(x,y,width,height);

	// construct the second door
	Door secondDoor = new Door(x+width+distance, y, width, height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	

	// draw a triangle on the left door for men's bathroom

	double triangleLength = width * .2;
	double topOfTriangleX = x + width * .5;
	double topOfTriangleY = y + height * .2;

	GeneralPath triangle = new GeneralPath();
	triangle.moveTo(topOfTriangleX, topOfTriangleY);
	triangle.lineTo(topOfTriangleX - (triangleLength * .5), topOfTriangleY + triangleLength);
	triangle.lineTo(topOfTriangleX + (triangleLength * .5), topOfTriangleY + triangleLength);
	triangle.lineTo(topOfTriangleX, topOfTriangleY);

	// draw a circle on right door for women's bathroom
	
	double signDiameter = width * .2;
	double centerOfCircleX = x + width + distance + width * .5 - signDiameter/2;
	double centerOfCircleY = y + height * .2;

	Ellipse2D.Double circle = new Ellipse2D.Double(centerOfCircleX, centerOfCircleY, signDiameter, signDiameter);

	
	// add the signs to the doors

        GeneralPath bothDoors = this.get();
	bothDoors.append(secondDoor, false);
        bothDoors.append(triangle, false);
        bothDoors.append(circle, false);

    }

}
