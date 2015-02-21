
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
       @param radius the radius of the cat face circle
     */
    public Cat(double x, double y, double radius)
    {
    

        double xSpecial = Math.sqrt(3.0/4.0);
        double ySpecial = Math.sqrt(1-(1.0/16.0));


       
        Circle mainCircle = new Circle(x, y, radius);



        // Assemble left ear
        Line2D.Double leftEar_r = 
            new Line2D.Double (x-radius*(0.25), y-(ySpecial)*radius, 
                                x - radius*(0.75),y-(1.20)*radius);

        Line2D.Double leftEar_l = 
            new Line2D.Double (x-radius*(xSpecial), y-(0.5)*radius, 
                                x - radius*(0.75),y-(1.20)*radius);





        Line2D.Double rightEar_r = 
            new Line2D.Double (x+radius*(xSpecial), y-(0.5)*radius, 
                                x + radius*(0.75),y-(1.20)*radius);

        Line2D.Double rightEar_l = 
            new Line2D.Double (x+radius*(0.25), y-(ySpecial)*radius, 
                                x + radius*(0.75),y-(1.20)*radius);





        // Assemble Eyes
        Line2D.Double leftEye = 
            new Line2D.Double(x - (0.25)*radius, y - (0.25)*radius, 
                            x - (0.25)*radius, y - (0.5)*radius);

        Line2D.Double rightEye = 
            new Line2D.Double(x + (0.25)*radius, y - (0.25)*radius, 
                            x + (0.25)*radius, y - (0.5)*radius);




        // Assemble Mouth
        Arc2D.Double mouthLeft = 
            new Arc2D.Double(x-(0.5)*radius, y, 
                                (0.5)*radius, (0.5)*radius, 
                                180, 180, 
                                Arc2D.OPEN);

            // same as mouthLeft, but starts at x = center, y = center
        Arc2D.Double mouthRight = 
            new Arc2D.Double(x, y, 
                                (0.5)*radius, (0.5)*radius, 
                                180, 180, 
                                Arc2D.OPEN);





        // Assemble the Cat!!
       
        GeneralPath wholeCat = this.get();

        wholeCat.append(mainCircle, false);

        wholeCat.append(leftEar_l, false);
        wholeCat.append(leftEar_r, false);

        wholeCat.append(rightEar_r, false);
        wholeCat.append(rightEar_l, false);


        wholeCat.append(leftEye, false);
        wholeCat.append(rightEye, false);

        wholeCat.append(mouthLeft, false);
        wholeCat.append(mouthRight, false);




    }

}
