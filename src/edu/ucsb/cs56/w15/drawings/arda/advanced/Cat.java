package edu.ucsb.cs56.w15.drawings.arda.advanced;
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

import java.awt.geom.Arc2D;  // ARCS
import java.awt.geom.Ellipse2D;  // ellipses and circles
import java.awt.geom.GeneralPath; // combinations of lines and curves


import static java.lang.Math.sqrt;


import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a simple cat face that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Phill Conrad
   @author Arda Ungun
   @version for CS56, Winter 15, UCSB
   
*/
public class Cat extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of house
       @param y y coord of lower left corner of house
       @param width width of the house
       @param height of house (including first story and second story)
     */
    public Cat(double x, double y, double radius)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
        Circle mainCircle = new Circle(x, y, radius);



        // Assemble left ear
        Line2D.Double leftEar_l = 
            new Line2D.Double (x-sqrt(12)*radius, y - (4-sqrt(12))*radius,
                            x-(3/8)*radius, y - (5/8)*radius);

        Line2D.Double leftEar_r = 
            new Line2D.Double (x-(3/8)*radius, y - (5/8)*radius,
                            x-(4-sqrt(12))*radius, y - sqrt(12)*radius);
 

        // Assemble right ear
        Line2D.Double rightEar_l = 
            new Line2D.Double (x+sqrt(12)*radius, y - (4-sqrt(12))*radius,
                            x + (3/8)*radius, y - (5/8)*radius);

        Line2D.Double rightEar_r = 
            new Line2D.Double (x+(3/8)*radius, y - (5/8)*radius,
                            x+(4-sqrt(12))*radius, y - sqrt(12)*radius);





        // Assemble Eyes
        Line2D.Double leftEye = 
            new Line2D.Double(x - (1/8)*radius, y - (1/8)*radius, 
                            x - (1/8)*radius, y - (2/8)*radius,);

        Line2D.Double rightEye = 
            new Line2D.Double(x + (1/8)*radius, y - (1/8)*radius, 
                            x + (1/8)*radius, y - (2/8)*radius,);




        // Assemble Mouth
        Arc2D.Double mouthLeft = 
            new Arc2D.Double(x-(2/8)*radius, y+(1/8)*radius, (2/8)*radius, (1/8)*radius, 0, 180, Arc2D.OPEN);

            // same as mouthLeft, but starts at x = center, y = center - radius/8
        Arc2D.Double mouthRight = 
            new Arc2D.Double(x, y+(1/8)*radius, (2/8)*radius, (1/8)*radius, 0, 180, Arc2D.OPEN);



        // Assemble the Cat!!
       
        GeneralPath wholeCat = this.get();

        wholeCat.append(mainCircle, false);

        wholeCat.append(leftEar_l, false);
        wholeCat.append(leftEar_r, false);
        
        wholeCat.append(rightEar_l, false);
        wholeCat.append(rightEar_l, false);
        
        wholeCat.append(mouthLeft, false);
        wholeCat.append(mouthRight, false);


    }

}
