package edu.ucsb.cs56.w15.drawings.dlynch.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // General class for shapes

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;


import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
   The face of Kanye West w/ shutter shades obviously

   @author Dylan Lynch
   @version for CS56, W15, UCSB, 02/07/2015

*/

public class KanyeWest extends GeneralPathWrapper implements Shape 
{
    /**                                                                        
       Constructor                                                             
       @param x x coord of left top corner of Kanye's face
       @param y y coord of left top corner of Kanye's face                          
       @param width width of Kanye's face                                        
       @param height of Kanye's face
    */
    public KanyeWest(double x, double y, double width, double height)
    {
        GeneralPath leftFace = new GeneralPath();
             
	leftFace.moveTo(x,y);
	leftFace.lineTo(x, y + height * 1.5);
	leftFace.lineTo(x + width * 1.5, y + height * 2.0);
	leftFace.lineTo(x + width * 3.0, y + height * 2.2);
	leftFace.lineTo(x + width * 4.0, y + height * 2.2);

        GeneralPath leftTop = new GeneralPath();
	
        leftTop.moveTo(x,y);
	leftTop.lineTo(x + width, y - height * 0.25);
	leftTop.lineTo(x + width * 3.0, y - height * 0.55);
	leftTop.lineTo(x + width * 3.5, y - height * 0.55);
	leftTop.lineTo(x + width * 4.0, y - height * 0.55);


	GeneralPath leftShades = new GeneralPath();
	// Frames
	leftShades.moveTo(x + width * 0.5,y + height * 0.3);
	leftShades.lineTo(x + width * 3.5, y + height * 0.3);
	leftShades.lineTo(x + width * 3.5, y + height * 0.90);
	leftShades.lineTo(x + width * 0.5, y + height * 0.90);
	leftShades.lineTo(x + width * 0.5, y + height * 0.3);
	//Shutter Lines
	
	leftShades.moveTo(x + width * 0.5, y + height * 0.40);
	leftShades.lineTo(x + width * 7.0, y + height * 0.40);
	for (int i = 1; i <= 5; i++) {
	    double k = .40 + i * .10;
	    leftShades.moveTo(x + width * 0.5, y + height * k);
	    leftShades.lineTo(x + width * 3.5, y + height * k);
	}

	GeneralPath mouth = new GeneralPath();
	leftShades.moveTo(x + width * 3.5, y + height * 1.75);
	leftShades.lineTo(x + width * 5.5, y + height * 1.75);
	
	GeneralPath leftKanye = new GeneralPath();
	leftKanye.append(leftTop, false);
	leftKanye.append(leftFace, false);
	leftKanye.append(leftShades, false);

	Shape rightKanye 
	    = ShapeTransforms.horizontallyFlippedCopyOf(leftKanye);

	rightKanye = ShapeTransforms.translatedCopyOf(rightKanye, width * 8.0, 0.0);

        GeneralPath wholeKanye = new GeneralPath ();
	wholeKanye.append(leftKanye, false);
	wholeKanye.append(rightKanye, false);
	wholeKanye.append(mouth, false);
	
	final double ORIG_X = 100;
	final double ORIG_Y = 200;
	final double ORIG_WIDTH = 300;
	final double ORIG_HEIGHT = 175;

        // translate to the origin by subtracting the original upper left x and y
        // then translate to (x,y) by adding x and y
        
        Shape s = ShapeTransforms.translatedCopyOf(wholeKanye, -ORIG_X + x, -ORIG_Y + y);
 
	// scale to correct height and width
        s =  ShapeTransforms.scaledCopyOf(s,
					  width/ORIG_WIDTH,
					  height/ORIG_HEIGHT) ;
	 
	// Use the GeneralPath constructor that takes a shape and returns
	// it as a general path to set our instance variable cup
        
	this.set(new GeneralPath(s)); 
    }
}
