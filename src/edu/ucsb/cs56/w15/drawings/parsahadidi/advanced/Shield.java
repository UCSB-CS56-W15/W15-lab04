package edu.ucsb.cs56.w15.drawings.parsahadidi.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   A Shield (wrapper around a General Path, implements Shape)

   This provides an example of how you can start with the coordinates
   of a hard coded object, and end up with an object that can be
   drawn anywhere, with any width or height.
   
      
   @author Parsa Hadidi
   @version for CS56, W15, UCSB, 02/3/2015
   
*/
public class Shield extends GeneralPathWrapper implements Shape
{

    
    /**
     * Constructor for objects of class Shield
     */
    public Shield(double x, double y, double width, double height)
    {
        
        final double ORIG_ULX = 100.0; 
        final double ORIG_ULY = 100.0; 
        final double ORIG_HEIGHT = 600.0; 
        final double ORIG_WIDTH = 200.0; 
                
        GeneralPath leftSide = new GeneralPath();
      
        // left side of shield
       
        leftSide.moveTo(100,100);
        leftSide.lineTo(100,550);
        leftSide.lineTo(150,700);
        
        GeneralPath top = new GeneralPath();
       
        top.moveTo(100,100);
        top.lineTo(200,100); // top of shield
        
        Shape rightSide = ShapeTransforms.horizontallyFlippedCopyOf(leftSide);
        rightSide = ShapeTransforms.translatedCopyOf(rightSide, 100.0, 0.0);
       
        // now we put the whole thing together ino a single path.
       
        GeneralPath wholeShield = new GeneralPath ();
        wholeShield.append(top, false);
        wholeShield.append(leftSide, false);
        wholeShield.append(rightSide, false);

        // translate to the origin by subtracting the original upper left x and y
        // then translate to (x,y) by adding x and y
        
        Shape s = ShapeTransforms.translatedCopyOf(wholeShield, -ORIG_ULX + x, -ORIG_ULY + y);
 
	// scale to correct height and width
        s =  ShapeTransforms.scaledCopyOf(s,
					  width/ORIG_WIDTH,
					  height/ORIG_HEIGHT) ;
	 
	// Use the GeneralPath constructor that takes a shape and returns
	// it as a general path to set our instance variable shield
        
	this.set(new GeneralPath(s));
        
    }

}
