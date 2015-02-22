package edu.ucsb.cs56.w15.drawings.jordannguyen.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a door that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Jordan Nguyen
   @version for CS56, Winter 15, UCSB
   
*/
public class Door extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of upper left corner of door
       @param y y coord of upper left corner of door
       @param width width of the door
       @param height height of the door
     */
    public Door(double x, double y, double width, double height)
    {
        
        // Make the shape of the door
        
        Rectangle2D.Double doorFrame =  new Rectangle2D.Double(x, y, width, height);
                          
        // make the door knob proportionate to the door
	
	double knobDiameter = width/10;
	double knobCenterY = y + height/2 - knobDiameter/2;
	double knobCenterX = x + width - width/10 - knobDiameter/2;
	Ellipse2D.Double doorKnob = new Ellipse2D.Double(knobCenterX, knobCenterY, knobDiameter, knobDiameter);
        

        // put the whole house together
       
        GeneralPath wholeDoor = this.get();
        wholeDoor.append(doorFrame, false);
        wholeDoor.append(doorKnob, false);
        
    }

}
