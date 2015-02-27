package edu.ucsb.cs56.w15.drawings.dlynch.advanced;
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

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;
/**
   Angry version of Kanye West (addition of angry eyebrows)
      
   @author Dylan Lynch
   @version for CS56, W15, UCSB, 02/10/15
   
*/
public class KanyeWestAngry extends KanyeWest implements Shape
{
    /**
     * Constructor for objects of class KanyeWestAngry
     */
    public KanyeWestAngry(double x, double y, double width, double height)
    {

	// construct the (non)basic Kanye West face
	super(x,y,width,height);

	final double ORIG_X = 100;
	final double ORIG_Y = 200;
	final double ORIG_WIDTH = 300;
	final double ORIG_HEIGHT = 175;

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();

	// Place rectangle eyebrows of anger on Kanyes Face
	GeneralPath leftBrow = new GeneralPath();

	leftBrow.moveTo(x + width * 0.5, y - height * 0.2);
	leftBrow.lineTo(x + width * 2.0 , y - height * 0.1);


	Shape rightBrow 
	    = ShapeTransforms.horizontallyFlippedCopyOf(leftBrow);

	rightBrow = ShapeTransforms.translatedCopyOf(rightBrow, width * 5.0, 0.0);
 

        GeneralPath bothBrows = new GeneralPath() ;
        bothBrows.append(leftBrow, false);
	bothBrows.append(rightBrow, false);

        Shape s = ShapeTransforms.translatedCopyOf(bothBrows, -ORIG_X + x, -ORIG_Y + y);
 
	// scale to correct height and width
        s =  ShapeTransforms.scaledCopyOf(s,
					  width/ORIG_WIDTH,
					  height/ORIG_HEIGHT) ;
	 
	// Use the GeneralPath constructor that takes a shape and returns
	// it as a general path to set our instance variable cup
        
	GeneralPath wholeKanye = this.get();
	wholeKanye.append(s, false);
   }

}
