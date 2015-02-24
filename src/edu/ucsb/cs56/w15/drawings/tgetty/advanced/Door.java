package edu.ucsb.cs56.w15.drawings.tgetty.advanced;
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
   A vector drawing of a door that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Taylor Getty 
   @version for CS56, Winter 14, UCSB
   
*/
public class Door extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of lower left corner of door
       @param y y coord of lower left corner of door
       @param width width of the door
       @param height of door
     */
    public Door(double x, double y, double width, double height)
    {
    
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
        double doorPaneHeight = .3 * height;
        double doorPaneWidth = .5 * width;
	double doorKnobHeight = .15 * height;
	double doorKnobWidth = .15 * width;
        
        // Make the door frame
        
        Rectangle2D.Double doorFrame = 
            new Rectangle2D.Double(x, y,
                          width, height);
                          
        // make the door panes.   Remember that y goes DOWN the page,
        // so we ADD to y to get a "lower" value on the screen
        
        Rectangle2D.Double topPane = 
            new Rectangle2D.Double (x + width/4.0, y + .65*height,
                               doorPaneWidth, doorPaneHeight);
                               
        Rectangle2D.Double bottomPane =
            new Rectangle2D.Double (x + width/4.0, y + .15*height,
                               doorPaneWidth, doorPaneHeight);

	Ellipse2D.Double doorKnob =
	  new Ellipse2D.Double( x + .81*width, y + .5*height, doorKnobWidth, doorKnobHeight);


        // put the whole door together
       
        GeneralPath wholeDoor = this.get(); 
        wholeDoor.append(doorFrame, false);
	wholeDoor.append(topPane, false);
	wholeDoor.append(bottomPane, false);
	wholeDoor.append(doorKnob, false);

    }

}
