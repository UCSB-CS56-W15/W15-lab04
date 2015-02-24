package edu.ucsb.cs56.w15.drawings.sxh19911230.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a cat that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Xianghong Sun
   @version for CS56, Winter 15, UCSB
   
*/
public class CatFace extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of cat
       @param y y coord of lower left corner of cat
       @param width width of the cat
       @param height of cat (including first story and second story)
     */
    public CatFace(double x, double y, double width, double height)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
        double catFaceHeight = .65 * height;
        double catEar = height - catFaceHeight;
        
        double catFaceUpperLeftY = y + catEar;
        
        // Make the first story
        
        Ellipse2D.Double catFace = 
            new Ellipse2D.Double(x, catFaceUpperLeftY ,
                          width, catFaceHeight);
                          
        // make the catFace.
        
        QuadCurve2D.Double leftEar = 
            new QuadCurve2D.Double(.2 * width + x, .4 * height  + y, 
            		0.1 * width + x, 0.05 * height + y, 0.4 * width +x , 0.35 * height + y);
                               
        QuadCurve2D.Double rightEar =
            new QuadCurve2D.Double (.8 * width + x, .4 * height  + y, 
            		0.9 * width + x, 0.05 * height + y, 0.6 * width +x , 0.35 * height + y);

        Ellipse2D.Double catNose = 
                new Ellipse2D.Double(0.45 * width + x, 0.65 * height +y,
                              0.14 * width, 0.05 * height);
        
        Ellipse2D.Double leftEye = 
                new Ellipse2D.Double(0.3 * width + x, 0.5 * height +y,
                              0.1 * width, 0.1 * height);
        
        Ellipse2D.Double leftEyeBall = 
                new Ellipse2D.Double(0.345 * width + x, 0.545 * height +y,
                              0.01 * width, 0.01 * height);
        
        Ellipse2D.Double rightEye = 
                new Ellipse2D.Double(0.6 * width + x, 0.5 * height +y,
                              0.1 * width, 0.1 * height);
        
        Ellipse2D.Double rightEyeBall = 
                new Ellipse2D.Double(0.645 * width + x, 0.545 * height +y,
                              0.01 * width, 0.01 * height);
        
        Line2D.Double leftWhiskerOne = new Line2D.Double(x + 0.05 * width, .65 * height + y,
               x + .3 * width, y + .66 * height);
        
        Line2D.Double leftWhiskerTwo = new Line2D.Double(x + 0.1 * width, .75 * height + y,
                x + .33 * width, y + .70 * height);
        
        Line2D.Double leftWhiskerThree = new Line2D.Double(x + 0.15 * width, .85 * height + y,
                x + .35 * width, y + .74 * height);
        
        Line2D.Double rightWhiskerOne = new Line2D.Double(x + 0.95 * width, .65 * height + y,
                x + .7 * width, y + .66 * height);
         
         Line2D.Double rightWhiskerTwo = new Line2D.Double(x + 0.9 * width, .75 * height + y,
                 x + .67 * width, y + .70 * height);
         
         Line2D.Double rightWhiskerThree = new Line2D.Double(x + 0.85 * width, .85 * height + y,
                 x + .65 * width, y + .74 * height);
         
         QuadCurve2D.Double leftMouth = 
                 new QuadCurve2D.Double(0.355 * width + x, .8 * height  + y, 
                 		0.43 * width + x, 0.9 * height + y, 0.5 * width + x , 0.8 * height + y);
         
         QuadCurve2D.Double rightMouth = 
                 new QuadCurve2D.Double(0.645 * width + x, .8 * height  + y, 
                 		0.57 * width + x, 0.9 * height + y, 0.5 * width + x , 0.8 * height + y);
        // put the whole cat together
       
        GeneralPath wholeCat = this.get();
        wholeCat.append(catFace, false);
        wholeCat.append(leftEar, false);
        wholeCat.append(rightEar, false); 
        wholeCat.append(catNose, false); 
        wholeCat.append(leftEye, false); 
        wholeCat.append(rightEye, false); 
        wholeCat.append(leftEyeBall, false); 
        wholeCat.append(rightEyeBall, false); 
        wholeCat.append(leftWhiskerOne, false); 
        wholeCat.append(leftWhiskerTwo, false); 
        wholeCat.append(leftWhiskerThree, false); 
        wholeCat.append(rightWhiskerOne, false); 
        wholeCat.append(rightWhiskerTwo, false); 
        wholeCat.append(rightWhiskerThree, false); 
        wholeCat.append(leftMouth, false); 
        wholeCat.append(rightMouth, false); 
        
        
    }

}
