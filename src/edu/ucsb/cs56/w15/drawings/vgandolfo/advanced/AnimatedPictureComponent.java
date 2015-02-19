package edu.ucsb.cs56.w15.drawings.vgandolfo.advanced;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JComponent;

// the four tools things we'll use to draw

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
   A component that draws an animated picture by Vincent Gandolfo
   
   @author Vincent Gandolfo
   @version CS56, Winter 2015, 2/17/15
   
*/


public class AnimatedPictureComponent extends JComponent
{  
    private Shape iphone;
    private double height;
    private double speed1;
    private double amplitude = 3.2;
    private double speed2;
    private double xTravel = 0;
    private double startingPosition;
    private double startingXPos;
    private double xPos;
    private double startingYPos;
    private double width;
    private double startingLength;
    private double t;
    private double angle = 1.75*Math.PI;
    private double travelDistance;


    // starting length: 300; width: 30
    /** Constructs an AnimatedPictureComponent with specific properties.
	This animated picture depicts a pencil writing across the screen

	@param startingXPos the starting x position of the pencil
	@param startingYPos the starting y position of the pencil
	@param travelSpeed the speed at which the pencil will move
	across the screen
	@param travelDistance the number of pixels the pencil will move
	across the screen before stopping
	@param scribbleSpeed the speed at which the pencil oscillates (or
	scribbles) back and forth
	@param startingLength the starting length of the pencil in pixels
	@param width the width of the pencil in pixels
    */
    public AnimatedPictureComponent(double startingXPos, double startingYPos, double speed2, double travelDistance, double speed1, double startingLength, double width) {
	this.startingXPos = startingXPos;
	this.startingYPos = startingYPos;
	this.xPos = startingXPos;
	this.speed2 = speed2;
	this.travelDistance = travelDistance;
	this.speed1 = speed1;
	this.startingLength = startingLength;
	this.width = width;

	iphone = new IphoneWithApps(this.xPos, this.startingYPos, this.width, this.startingLength);
	//eraserHeight = ((Pencil)pencil).getEraserHeight();
    }

    /** The paintComponent method is orverriden to display
	out animation. Each time this method is called, the
	position of the pencil is updated
     */
    
   public void paintComponent(Graphics g)
   {  
       Graphics2D g2 = (Graphics2D) g;
       //g2.draw(new Rectangle(0, 0, 
       if (xPos >= startingXPos + travelDistance) {
	   this.xPos = startingXPos;
	   this.t = 0;
	   this.xTravel = 0;
	   return;
       }
       else
	   g2.setColor(Color.BLACK); g2.draw(iphone);

       t += speed1;
       xTravel += speed2;
       xPos = xTravel + startingXPos;
       //double wobble = amplitude*(1/speed1)*Math.sin(t) + amplitude*0.8*(1/speed1)*Math.sin(0.8*t+1.5);
       //xPos += wobble;
       //double length = (1 - (xTravel/travelDistance))*(startingLength);
       double yPos = startingYPos;
       
       iphone = ShapeTransforms.translatedCopyOf(new IphoneWithApps(xPos, yPos, width, startingLength), 3, 0);
   }    
  
}
