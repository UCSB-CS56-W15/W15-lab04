package edu.ucsb.cs56.w15.drawings.vporter.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.vporter.simple.Circle;
import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a Robot that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Victor Porter 
   @version for CS56, Winter 15, UCSB
   
*/
public class Robot extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of upper left corner of the head
       @param y y coord of upper left corner of the head
       @param height of Robot (from bottom of legs to the top of head)
     */
    public Robot(double x, double y, double height)
    {
        //Declare body part height and width base on input params
        double headHeight = .25 * height;
        double armHeight = .4 * height;
	      double bodyHeight = .45 * height;
      	double legHeight = .3 * height;
        double armWidth = .4 * headHeight;
        double legWidth = armWidth;

        //Set up Y-coordinate system for body parts
        double headUpperLeftY = y;
	      double armUpperLeftY = y + headHeight + .25 * bodyHeight;
      	double bodyUpperLeftY = y + headHeight;
      	double legUpperLeftY = y + headHeight + bodyHeight;
 	  
        //Set up Y-coordinate system for body parts
       	double headUpperLeftX = x;
	      double bodyUpperLeftX = x - (.43 * headHeight);  //centers head on robot body
      	double arm1UpperLeftX = bodyUpperLeftX - armWidth; //x - .5 * bodyHeight;
      	double arm2UpperLeftX = bodyUpperLeftX + bodyHeight; //x + headHeight + .25 * bodyHeight;
      	double leg1UpperLeftX = x;
      	double leg2UpperLeftX = x + headHeight - legWidth;
        
        //Create shapes to represent body part of the robot

        Rectangle2D.Double head = 
            new Rectangle2D.Double(x, y , headHeight, headHeight);
                          
        Rectangle2D.Double body = 
            new Rectangle2D.Double (bodyUpperLeftX, bodyUpperLeftY, bodyHeight, bodyHeight);

        Rectangle2D.Double arm1 =
            new Rectangle2D.Double (arm1UpperLeftX, armUpperLeftY, armWidth, armHeight);

        Rectangle2D.Double arm2 =
            new Rectangle2D.Double (arm2UpperLeftX, armUpperLeftY, armWidth, armHeight);

        Rectangle2D.Double leg1 =
            new Rectangle2D.Double (leg1UpperLeftX, legUpperLeftY, legWidth, legHeight);

        Rectangle2D.Double leg2 =
            new Rectangle2D.Double (leg2UpperLeftX, legUpperLeftY, legWidth, legHeight);

        Rectangle2D.Double mouth =
            new Rectangle2D.Double (x + .25 * headHeight, y + .6 * headHeight, .5 * headHeight, .25 * headHeight);

        Circle eye1 =
           new Circle (x + .25 * headHeight, y + .25 * headHeight, headHeight/10);

        Circle eye2 =
           new Circle (x + .75 * headHeight, y + .25 * headHeight, headHeight/10);
       
        //Create General Path instance to create robot out of robot parts

        GeneralPath wholeRobot = this.get();

        wholeRobot.append(head, false);
        wholeRobot.append(body, false);
        wholeRobot.append(arm1, false); 
        wholeRobot.append(arm2, false);
        wholeRobot.append(leg1, false); 
        wholeRobot.append(leg2, false); 
        wholeRobot.append(mouth, false); 
        wholeRobot.append(eye1, false);
        wholeRobot.append(eye2, false);
        
    }

}
