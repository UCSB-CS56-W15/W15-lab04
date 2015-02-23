package edu.ucsb.cs56.w15.drawings.npoon.advanced;
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
   A vector drawing of a basketball court that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Nicohlas Poon
   @version for CS56, Winter 15, UCSB
   
*/
public class BasketballCourt extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of basketball court
       @param y y coord of lower left corner of basketball court
       @param width - width of the basketball court
     */
    public BasketballCourt(double x, double y, double width)
    {
	
	double height = width/2; //Height of the basketball court is half the width

	// Draw the court outline
	
	Rectangle2D.Double court = 
		new Rectangle2D.Double(x, y, width, height);

	// Draw court center line

	Line2D.Double centerLine = 
		new Line2D.Double(x + width/2, y, x + width/2, y + height);

	
	Line2D.Double centerLine1 =  /*TEST LINE FOR Y CENTERED OBJECTS*/
		new Line2D.Double(x, y+height/2, x + width, y + height/2);
	
	// Draw court center circle for tipoff

	Ellipse2D.Double centerCircle = 
		new Ellipse2D.Double(x + height/3 * 2.5, y + height/3 , height/3, height/3); 


	// Draw restricted areas for both sides

	Rectangle2D.Double restrictL =  /*Left Restricted Area*/
		new Rectangle2D.Double(x, y+height/3, width*.2, height/3);
	
	Rectangle2D.Double restrictR =  /*Left Restricted Area*/
		new Rectangle2D.Double(x + width - width*.2, y+height/3, width*.2, height/3);

	
	// Draw restricted area circles
	
	Ellipse2D.Double LCircle = 
		new Ellipse2D.Double(x + width/5 - height/6, y+height/3, height/3, height/3);

	Ellipse2D.Double RCircle = 
		new Ellipse2D.Double(x + 4*width/5 - height/6, y+height/3, height/3, height/3);
	

        GeneralPath wholeCourt = this.get();
        wholeCourt.append(court, false);
        wholeCourt.append(centerCircle, false);
        wholeCourt.append(centerLine, false); 
	wholeCourt.append(restrictL, false);
	wholeCourt.append(restrictR, false);
	wholeCourt.append(LCircle, false);
	wholeCourt.append(RCircle, false);
	//wholeCourt.append(centerLine1, false);    /*FOR TESTING*/
        
    }

}
