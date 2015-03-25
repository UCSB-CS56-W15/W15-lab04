package edu.ucsb.cs56.w15.drawings.vgandolfo.advanced;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JComponent;


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


    
    /** Constructs an AnimatedPictureComponent with specific properties.
	This animated picture depicts an Iphone traveling across the screen

	@param startingXPos the starting x position of the Iphone
	@param startingYPos the starting y position of the Iphone
	@param speed1 the speed at which the Iphone will move
	across the screen
	@param travelDistance the number of pixels the Iphone will move
	across the screen before stopping
	@param speed2 the speed at which the Iphone goes back and forth
	@param startingLength the starting length of the Iphone in pixels
	@param width the width of the Iphone in pixels
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
	
    }

    /** The paintComponent method is orverriden to display
	out animation. Each time this method is called, the
	position of the Iphone is updated
     */
    
   public void paintComponent(Graphics g)
   {  
       Graphics2D g2 = (Graphics2D) g;
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
       double yPos = startingYPos;
       
       iphone = ShapeTransforms.translatedCopyOf(new IphoneWithApps(xPos, yPos, width, startingLength), 3, 0);
   }    
  
}
