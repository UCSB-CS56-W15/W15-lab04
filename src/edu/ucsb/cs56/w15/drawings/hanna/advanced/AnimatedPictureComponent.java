package edu.ucsb.cs56.w15.drawings.hanna.advanced;
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

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;
/**
   A component that draws an animated picture by Jakob Staahl
   
   @author Hanna Vigil
   @version CS56, Spring 2015, UCSB
   
*/


public class AnimatedPictureComponent extends JComponent
{  
    private Shape dice;
    private double startingXPos;
    private double startingYPos;
    private double yPos;
    private double yTravel;
    private double length;
    private double speed;
    private double travelDistance;

    /** Constructs an AnimatedPictureComponent with specific properties.
	This animated picture depicts a pencil writing across the screen

	@param startingXPos the starting x position of the dice
	@param startingYPos the starting y position of the dice
	@param speed the speed at which the dice will fall
	@param travelDistance the number of pixels the dice will fall
	before hitting the ground
       	@param length the length that will be used to draw the cube for the dice
         */
    public AnimatedPictureComponent(double startingXPos, double startingYPos, double speed, double travelDistance, double length) {
	this.startingXPos = startingXPos;
	this.startingYPos = startingYPos;
	this.yPos = startingYPos;
	this.speed = speed;
	this.travelDistance = travelDistance;
	this.length = length;

	this.dice = new Dice(this.startingXPos, this.yPos, this.length);
    }

    /** The paintComponent method is orverriden to display
	out animation. Each time this method is called, the
	position of the dice is updated
     */
    
   public void paintComponent(Graphics g)
   {  
       Graphics2D g2 = (Graphics2D) g;
       if (yPos >= startingYPos + travelDistance) {
	   this.yPos = startingYPos;
      	   this.yTravel = 0;
	   this.dice = new Dice(this.startingXPos, this.yPos, this.length);
	   return;
       }
       else
	   g2.setColor(Color.BLACK); g2.draw(dice);

       yTravel += speed;
       yPos = yTravel + startingYPos;
       
       dice = ShapeTransforms.translatedCopyOf(dice, 0, speed);
   }    
  
}
