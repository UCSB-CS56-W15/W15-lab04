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
import java.lang.Math.*;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   A Cargo Car (subclass of TrainCar, implements Shape)

   This builds a train car with a randomly-generated rectangle, centered on top of the bed of the car, that will not get any larger than a square with the side length equal to the length of the train car
      
   @author  Wesley Pollek
   @version for CS56, W15, UCSB
   
*/
public class CargoCar extends TrainCar implements Shape
{

    
    /**
     * Constructor for objects of class CargoCar
     */
    public CargoCar(double x, double y, double width, double height)
    {
	super(x,y,width,height);
	double randomheight= (double)(Math.random()*width);
	double randomwidth= (double)(Math.random()*width);
	double centerit=width/2-randomwidth/2;
	GeneralPath gp = this.get();
	Rectangle2D.Double randCargo=
	    new Rectangle2D.Double(x+centerit,y-randomheight,randomwidth,randomheight);
	GeneralPath LoadedCar = this.get();
	LoadedCar.append(randCargo, false);
    }
}
