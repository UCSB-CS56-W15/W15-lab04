package edu.ucsb.cs56.w15.drawings.jeffrey.advanced;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.geom.Line2D;  // single lines
import java.awt.Rectangle;  // squares and rectangles
import java.awt.geom.Rectangle2D; // for rectangles drawing with Doubles
import java.awt.Color; // class for Colors
import java.awt.Shape; // Shape interface
import java.awt.Stroke; // Stroke interface
import java.awt.BasicStroke; // class that implements stroke

/**
   A component that draws an animated clock by Jeffrey Chen
   
   @author Jeffrey Chen
   @version CS56, Winter 2015, UCSB, 2/20/2015
   
*/


public class AnimatedPictureComponent extends JComponent {
    private Shape clock;
    private double xCoord; //Top-left bound
    private double yCoord; //Top-left bound
    private double radius;
    private double xOrigin;
    private double yOrigin;
    private double animationSpeed = 1; // Default is 1 second
    private double secAngle = (Math.PI / 2); // Start pointing at 12;
    private double minAngle = (Math.PI / 2);
    private double hrAngle = (Math.PI / 2);
    private double inc = (6 * (Math.PI / 180)); // Moves 6 deg at a time
    private int secInc = 0;
    // Amount that the hour hand moves per minute
    private double hrAngleInc = (0.5 * (Math.PI / 180));

    // starting length: 300; width: 30
    /** Constructs an AnimatedPictureComponent with specific properties.
    This animated picture depicts a ticking clock.

    @param xCoord - Clock object's top-left bound
    @param yCoord - Clock object's top-left bound
    @param radius - Radius of the clock
    @param animationSpeed - Number of seconds in one real second (e.g 
    '2' makes clock move twice as fast as normal)
    */
    public AnimatedPictureComponent(double xCoord, double yCoord,
            double radius, double animationSpeed) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.radius = radius;
        this.animationSpeed = animationSpeed;
        this.clock = new DisarmedAlarmClock(xCoord,yCoord,radius);
        this.xOrigin = xCoord+radius;
        this.yOrigin = yCoord+radius;
    }

    /** The paintComponent method is orverriden to display
	out animation. Each time this method is called, the
	position of the second, minute, and hour hands are updated.
     */
    
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        // Clear the panel first
        g2.setColor(Color.WHITE);
        g2.fillRect(0,0,this.getWidth(), this.getHeight());

        // Draw the clock
        Stroke thick = new BasicStroke(
            4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
        Stroke orig=g2.getStroke();
        g2.setColor(Color.BLACK);
        g2.setStroke(thick);
        g2.draw(clock);

        // Add second, minute, and hour hands.
        // Have to remove static hands from default Clock class.
        Line2D.Double minHand = new
            Line2D.Double(xOrigin, yOrigin,
                (xOrigin)+Math.cos(minAngle)*radius*0.8,
                (yOrigin)-Math.sin(minAngle)*radius*0.8);
        g2.draw(minHand);
        Line2D.Double hrHand = new
            Line2D.Double(xOrigin, yOrigin,
                (xOrigin)+Math.cos(hrAngle)*radius/2,
                (yOrigin)-Math.sin(hrAngle)*radius/2);
        g2.draw(hrHand);
        Line2D.Double secHand = new
            Line2D.Double(xOrigin, yOrigin,
                (xOrigin)+Math.cos(secAngle)*radius*0.9,
                (yOrigin)-Math.sin(secAngle)*radius*0.9);
        g2.setStroke(orig);
        g2.draw(secHand);

        // Move second hand
        secAngle -= inc;
        secInc++;

        // Update angle of minute and hour hands every
        // 60 rotations of second hand.
        if(secInc>59) {
            minAngle -= inc; // Move minute hand
            hrAngle -= hrAngleInc; // Move hour hand
            secInc = 0; // Reset second increment value
        }
        g2.setColor(Color.BLACK); 
        g2.drawString("An animated alarm clock by Jeffrey", 20,20);
        g2.drawString("Mouse-over to run!", 20,35);
    }
}
// Note: If running long and fast enough, animation may crash
// once angle variables exceeds maximum double value.