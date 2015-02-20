package edu.ucsb.cs56.w15.drawings.jeffrey.advanced;
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
   A component that draws an animated picture by Jeffrey Chen
   
   @author Jeffrey Chen
   @version CS56, Winter 2015, UCSB
   
*/


public class AnimatedPictureComponent extends JComponent {
    // Parameters needed:
    // Clock object
    // x-coordinate
    // y-coordinate
    // Radius
    // Animation Speed
    private Shape clock;
    private double xCoord; //Top-left bound
    private double yCoord; //Top-left bound
    private double radius;
    private double xOrigin;
    private double yOrigin;
    private double animationSpeed = 1; // Default is 1 second
    private double secAngle = (Math.PI / 2); // Start pointing at 12;
    private double inc = (6 * (Math.PI / 180)); // Change of angle/s


    // starting length: 300; width: 30
    /** Constructs an AnimatedPictureComponent with specific properties.
	This animated picture depicts a clock writing across the screen

	@param startingXPos the starting x position of the clock
	@param startingYPos the starting y position of the clock
	@param travelSpeed the speed at which the clock will move
	across the screen
	@param travelDistance the number of pixels the clock will move
	across the screen before stopping
	@param scribbleSpeed the speed at which the clock oscillates (or
	scribbles) back and forth
	@param startingLength the starting length of the clock in pixels
	@param width the width of the clock in pixels
    */
    public AnimatedPictureComponent(double x, double y,
            double radius, double animationSpeed) {
    	this.xCoord = x;
        this.yCoord = y;
        this.radius = radius;
        this.animationSpeed = animationSpeed;
    	this.clock = new AlarmClock(xCoord,yCoord,radius);
        this.xOrigin = xCoord+radius;
        this.yOrigin = yCoord+radius;
    }

    /** The paintComponent method is orverriden to display
	out animation. Each time this method is called, the
	position of the second hand is updated
     */
    
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        // Clear the panel first
        g2.setColor(Color.WHITE);
        g2.fillRect(0,0,this.getWidth(), this.getHeight());

        // Draw the clock
        Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
        Stroke orig=g2.getStroke();
        g2.setColor(Color.BLACK);
        g2.setStroke(thick);
        clock = new AlarmClock(xCoord, yCoord, radius);
        g2.draw(clock);

        // Add second hand
        Line2D.Double secHand = new
            Line2D.Double(xOrigin, yOrigin,
                (xOrigin)+Math.cos(secAngle)*radius*0.9,
                (yOrigin)-Math.sin(secAngle)*radius*0.9);
        g2.setColor(Color.BLACK);
        g2.setStroke(orig);
        g2.draw(secHand);

        // Rotate second hand by incrementing
        secAngle -= inc;
   }    
  
}
