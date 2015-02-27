package edu.ucsb.cs56.w15.drawings.sxh19911230.advanced;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.JComponent;

// the four tools things we'll use to draw


import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;

import java.awt.geom.Line2D;  // single lines
import java.awt.geom.Ellipse2D;  // ellipses and circles
import java.awt.Rectangle;  // squares and rectangles
import java.awt.geom.GeneralPath; // combinations of lines and curves


import java.awt.geom.Rectangle2D; // for rectangles drawing with Doubles
import java.awt.Color; // class for Colors
import java.awt.Shape; // Shape interface
import java.awt.Stroke; // Stroke interface
import java.awt.BasicStroke; // class that implements stroke

/**
   A component that draws an animated picture by Xianghong Sun
   
   @author Jakob Staahl
   @author Xianghong Sun
   @version CS56, Spring 2015, UCSB
   
*/


public class AnimatedPictureComponent extends JComponent
{  
    private Shape cf;
    private double rotateSpeed;
    private double xTravelSpeed;
    private double yTravelSpeed;
    private double xPos;
    private double yPos;
    private double width;
    private double length;
    private double t;


    /** Constructs an AnimatedPictureComponent with specific properties.
	This animated picture depicts a cat face writing across the screen

	@param startingXPos the starting x position of the cat face
	@param startingYPos the starting y position of the cat face
	@param travelSpeed the speed at which the cat face will move
	across the screen

	@param rotateSpeed the speed at which the cat face rotate 
	@param length the length of the cat face in pixels
	@param width the width of the cat face in pixels
    */
    public AnimatedPictureComponent(double startingXPos, double startingYPos, double travelSpeed, double travelDistance, double rotateSpeed, double length, double width) {

	this.xPos = startingXPos;
	this.yPos = startingYPos;
	this.xTravelSpeed = travelSpeed * 2;
	this.yTravelSpeed = travelSpeed / 2;
	this.rotateSpeed = rotateSpeed;
	this.length = length;
	this.width = width;

	cf = new CatFace(this.xPos, this.yPos, this.width, this.length);

    }

    /** The paintComponent method is orverriden to display
	out animation. Each time this method is called, the
	position of the cat face is updated
     */
    
   public void paintComponent(Graphics g)
   {  
       Graphics2D g2 = (Graphics2D) g;

       xPos += xTravelSpeed;
       yPos += yTravelSpeed;
       t += rotateSpeed;

       
       if (xPos >= getWidth() - width) {
    	   this.xTravelSpeed = - this.xTravelSpeed;

       }
       
       if (xPos <= 0) {
    	   this.xTravelSpeed = - this.xTravelSpeed;

       }
       
       if (yPos >= getHeight() - length) {
    	   this.yTravelSpeed = - this.yTravelSpeed;

       }
       
       if (yPos <= 0) {
    	   this.yTravelSpeed = - this.yTravelSpeed;

       }


	   g2.setColor(Color.BLACK); g2.draw(cf);


       
       
       cf = ShapeTransforms.rotatedCopyOf(new CatFace(xPos, yPos, width, length), Math.PI/120 * t);
   }    
  
}
