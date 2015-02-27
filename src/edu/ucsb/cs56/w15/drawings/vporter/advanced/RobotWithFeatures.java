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
   A Robot gets an upgrade
      
   @author Victor Porter
   @version for CS56, W15, UCSB, 02/4/2015
   
*/
public class RobotWithFeatures extends Robot implements Shape
{
    /**
       Constructor

       @param x x coord of upper left corner of the head
       @param y y coord of upper left corner of the head
       @param height of Robot (from bottom of legs to the top of head)
       @param antennaeHeight The height of the robots head antennae
     */
    public RobotWithFeatures(double x, double y, double height, double antennaeHeight) {

	// construct the basic Robot shell
	super(x,y,height);
	
	//Create new circle shapes to act as button features for the robot
	Circle button1 =
           new Circle (x + .85 * (.25 * height), y + (.25 * height) + (.25 * (.45 * height)), (.25 * height)/15);

    Circle button2 =
           new Circle (x + .85 * (.25 * height), y + (.25 * height) + (.50 * (.45 * height)), (.25 * height)/15);

    Circle button3 =
           new Circle (x + .85 * (.25 * height), y + (.25 * height) + (.75 * (.45 * height)), (.25 * height)/15);

    //Creature a Robot Atennae with height given by the user

    Rectangle2D.Double antennae =
           new Rectangle2D.Double (x + (.1 * height), y - antennaeHeight, .25 * .25 * height, antennaeHeight);

    //Add new features to the Generalpath instance for drawing

    GeneralPath wholeRobot = this.get();
    wholeRobot.append(button1, false);
    wholeRobot.append(button2, false);
    wholeRobot.append(button3, false); 
    wholeRobot.append(antennae, false);
    }

}
