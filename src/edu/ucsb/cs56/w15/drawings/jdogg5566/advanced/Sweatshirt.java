package edu.ucsb.cs56.w15.drawings.jdogg5566.advanced;
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.*;
import java.awt.Rectangle;


import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;


/**
   A vector drawing of a sweatshirt that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Jonathan Easterman 
   @version for CS56, Winter 15, UCSB
   
*/

public class Sweatshirt extends GeneralPathWrapper implements Shape {

/**
       Constructor

       @param x x coord of top-left of torso of sweatshirt
       @param y y coord of top-left of torso of sweatshirt
	@param tHeight the height of the torso shape, arms and hood will be scaled accordingly
	@param tWidth the width of the torso shape, arms and hood will be scaled accordingly
*/

    public Sweatshirt (double x, double y, double tHeight, double tWidth) {
        double armY = y; // y coord of the top of the arm
        double rightArmX = x+tWidth; // x coord of the top-left of right arm
        double leftArmx = x - 1.25*tWidth; // x coord of the top-left of left arm

        double circleX = x; // x coord of top left of circle
        double circleY = y - .75*tWidth; // y coord of top left of circle
        double circleDiameter = tWidth; // Diameter of circle is equal to width of torso

        Rectangle2D.Double torso =
            new Rectangle2D.Double(x,y,tWidth,tHeight);

        Rectangle2D.Double leftArm = 
            new Rectangle2D.Double(leftArmx,armY,.75*tHeight,.25*tWidth);

        Rectangle2D.Double rightArm = 
            new Rectangle2D.Double(rightArmX,armY,.75*tHeight,.25*tWidth);

        Ellipse2D.Double hood = 
            new Ellipse2D.Double(circleX,circleY,circleDiameter,circleDiameter);

        GeneralPath wholeSweatshirt = this.get();
        wholeSweatshirt.append(torso, false);
        wholeSweatshirt.append(leftArm, false);
        wholeSweatshirt.append(rightArm, false);
        wholeSweatshirt.append(hood, false);

    }

}
