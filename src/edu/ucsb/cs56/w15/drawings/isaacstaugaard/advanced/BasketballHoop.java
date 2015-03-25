package edu.ucsb.cs56.w15.drawings.isaacstaugaard.advanced;
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

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   A Basketball Hoop (wrapper around a General Path, implements Shape)

   This provides an example of how you can start with the coordinates
   of a hard coded object, and end up with an object that can be
   drawn anywhere, with any width or height.
   
      
   @author Phill Conrad, Isaac Staugaard 
   @version for CS56, W15, UCSB, 02/10/2015
   
*/
public class BasketballHoop extends GeneralPathWrapper implements Shape
{

    
    /**
     * Constructor for objects of class BasketballHoop
     */
    public BasketballHoop(double x, double y, double width, double height)
    {
    
        // Specify the upper left corner, and the 
        //  width and height of the original points used to 
        //  plot the *hard-coded* basketball hoop
        
        final double ORIG_ULX = 100.0; 
        final double ORIG_ULY = 100.0; 
        final double ORIG_HEIGHT = 300.0; 
        final double ORIG_WIDTH = 514.0; 
                
        GeneralPath leftSideBackboard = new GeneralPath();
      
        // left side of backboard
       
        leftSideBackboard.moveTo(100,100);
        leftSideBackboard.lineTo(100,400);
        
        GeneralPath topAndBottomBackboard = new GeneralPath();
       
        topAndBottomBackboard.moveTo(100,100);
        topAndBottomBackboard.lineTo(614,100); // top of backboard
        
        topAndBottomBackboard.moveTo(100,400);
        topAndBottomBackboard.lineTo(614,400); // bottom of backboard
       
        GeneralPath rightSideBackboard = new GeneralPath();
              
        rightSideBackboard.moveTo(614,100);
	rightSideBackboard.lineTo(614,400);
        // now we put the whole thing together ino a single path.
       
        GeneralPath Backboard = new GeneralPath ();
        Backboard.append(topAndBottomBackboard, false);
        Backboard.append(leftSideBackboard, false);
        Backboard.append(rightSideBackboard, false);

	GeneralPath insideSquare = new GeneralPath();
	insideSquare.moveTo(264,195);
	insideSquare.lineTo(264,305);
	insideSquare.moveTo(264,305);
	insideSquare.lineTo(450,305);
	insideSquare.moveTo(450,305);
	insideSquare.lineTo(450,195);
	insideSquare.moveTo(450,195);
	insideSquare.lineTo(264,195);
	
	GeneralPath BackboardWithInnerSquare = new GeneralPath ();
	BackboardWithInnerSquare.append(Backboard, false);
	BackboardWithInnerSquare.append(insideSquare, false);

	Ellipse2D.Double Rim1 = new Ellipse2D.Double(264,310,186,30);
	
	GeneralPath BackboardWithSquareAndRim = new GeneralPath (); 
	BackboardWithSquareAndRim.append(Backboard,false);
	BackboardWithSquareAndRim.append(insideSquare,false);
	BackboardWithSquareAndRim.append(Rim1,false);
	
	GeneralPath Net = new GeneralPath ();
	Net.moveTo(264,325);
	Net.curveTo(304,350,294,370,294,440);
	Net.moveTo(450,325);
	Net.curveTo(410,350,420,370,420,440);

	Ellipse2D.Double NetBottom = new Ellipse2D.Double(294,435,126,5);

	GeneralPath BackboardWithSquareRimNet = new GeneralPath ();
	BackboardWithSquareRimNet.append(BackboardWithSquareAndRim, false);
	BackboardWithSquareRimNet.append(Net, false);
	BackboardWithSquareRimNet.append(NetBottom,false);

        // translate to the origin by subtracting the original upper left x and y
        // then translate to (x,y) by adding x and y
        
        Shape s = ShapeTransforms.translatedCopyOf(BackboardWithSquareRimNet, -ORIG_ULX + x, -ORIG_ULY + y);
 
	// scale to correct height and width
        s =  ShapeTransforms.scaledCopyOf(s,
					  width/ORIG_WIDTH,
					  height/ORIG_HEIGHT) ;
	 
	// Use the GeneralPath constructor that takes a shape and returns
	// it as a general path to set our instance variable basketball hoop
        
	this.set(new GeneralPath(s));
        
    }

}
