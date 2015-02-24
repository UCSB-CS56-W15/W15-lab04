package edu.ucsb.cs56.w15.drawings.wpollek.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D; 


import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   A Train Car (wrapper around a General Path, implements Shape)
   
   This draws a train car using constructor:
   TrainCar(double x, double y, double l, double h)
   At point (x,y) with hitch-to-hitch length l and height h
      
   @author Wesley Pollek
   @version for CS56, W15, UCSB
   
*/
public class TrainCar extends GeneralPathWrapper implements Shape
{

    
    /**
     * Constructor for objects of class TrainCar
     */
    public TrainCar(double x, double y, double width, double height)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        double wheel = height/4;
        double CarHeight = height/4;
        double wheelJoint = y + CarHeight;
	double hitch=height/8;
        
        // Make the first story
        
        Rectangle2D.Double carBox = 
            new Rectangle2D.Double(x+wheel, y, width-2*wheel, CarHeight);
        
        Ellipse2D.Double leftWheel = 
            new Ellipse2D.Double (x+wheel, y + CarHeight , wheel, wheel);
                               
        Ellipse2D.Double rightWheel =
            new Ellipse2D.Double (x + width-2*wheel, y + CarHeight, wheel, wheel);
	Line2D.Double laxle =
	    new Line2D.Double (x+2*wheel, y+CarHeight+wheel/2, x+width/2,y+CarHeight);
	Line2D.Double raxle =
	    new Line2D.Double (x+width/2, y+CarHeight, x+width-2*wheel,y+CarHeight+wheel/2);
	Line2D.Double fronthitch =
	    new Line2D.Double(x+width-wheel, y+CarHeight/2,x+width,y+CarHeight/2);
	Line2D.Double backhitch =
	    new Line2D.Double(x+hitch, y+CarHeight/2,x+2*hitch,y+CarHeight/2);
	Ellipse2D.Double backloop =
	    new Ellipse2D.Double(x,y+CarHeight/4,hitch,hitch);

        // put the whole house together
       
        GeneralPath wholeCar = this.get();
        wholeCar.append(carBox, false);
        wholeCar.append(leftWheel, false);
        wholeCar.append(rightWheel, false);
        wholeCar.append(laxle, false);
        wholeCar.append(raxle, false); 
        wholeCar.append(fronthitch, false); 
        wholeCar.append(backhitch, false); 
        wholeCar.append(backloop, false); 
    }

}
