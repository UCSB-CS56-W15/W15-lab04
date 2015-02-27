package edu.ucsb.cs56.w15.drawings.glee.advanced;
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
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a car that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Geon Hee Lee
   @version for CS56, Winter 15, UCSB
   
*/
public class Car extends GeneralPathWrapper implements Shape
{
    /**
       Constructor for objects of class Car

       @param x x coord of bottom left corner of car
       @param y y coord of bottom left corner of car
       @param width width of the car
       @param height of car (excluding the wheels)
     */
    public Car(double x, double y, double width, double height)
    {
	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();

        double halfHeight = height / 2.0;
	double halfWidth = width / 2.0;
	double quarterWidth = width / 4.0;
	double wheelDiameter = width / 5.0;
        
        // Make top cover 
	
	Line2D.Double upLine = 
	    new Line2D.Double (x, (y+height), x, (y+halfHeight));
	Line2D.Double rightLine = 
	    new Line2D.Double (x, y+halfHeight, x+quarterWidth, y+halfHeight);
	Line2D.Double upLine2 = 
	    new Line2D.Double (x+quarterWidth, y+halfHeight, x+quarterWidth,y);
	Line2D.Double rightLine2 = 
	    new Line2D.Double (x+quarterWidth, y,x+(quarterWidth*3),y);
	Line2D.Double downLine = 
	    new Line2D.Double (x+(quarterWidth*3), y, x+(quarterWidth*3), y+halfHeight);
	Line2D.Double rightLine3 =
	    new Line2D.Double (x+(quarterWidth*3),y+halfHeight, x+width, y+halfHeight);
	Line2D.Double downLine2 =
	    new Line2D.Double (x+width, y+halfHeight, x+width, y+height);

	
	// Make bottom cover
	Line2D.Double botLine = 
	    new Line2D.Double (x, (y+height), x+wheelDiameter, (y+height));
	Line2D.Double botLine2 = 
	    new Line2D.Double (x+(wheelDiameter*2), y+height,x+(wheelDiameter*2)+wheelDiameter, y+height);
	Line2D. Double botLine3 = 
	    new Line2D.Double (x+(wheelDiameter*4), y+height ,x+(wheelDiameter*5), y+height);


	// Make wheels
	Ellipse2D.Double wheel1 = 
	    new Ellipse2D.Double (x + wheelDiameter, (y+height) - wheelDiameter/2, wheelDiameter, wheelDiameter);
	Ellipse2D.Double wheel2 = 
	    new Ellipse2D.Double (x + (wheelDiameter*3), (y+height) - wheelDiameter/2, wheelDiameter, wheelDiameter);

        // put the whole house together
       
        GeneralPath wholeCar = this.get();
	wholeCar.append(upLine, false);
	wholeCar.append(rightLine, false);
	wholeCar.append(upLine2, false);
	wholeCar.append(rightLine2, false);
	wholeCar.append(downLine, false);
	wholeCar.append(rightLine3, false);
	wholeCar.append(downLine2, false);
	wholeCar.append(botLine, false);
        wholeCar.append(botLine2, false);
        wholeCar.append(botLine3, false);
        wholeCar.append(wheel1, false);
        wholeCar.append(wheel2, false);

    }

}
