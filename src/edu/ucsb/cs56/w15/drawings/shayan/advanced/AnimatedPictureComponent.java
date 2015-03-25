package edu.ucsb.cs56.w15.drawings.shayan.advanced;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.geom.AffineTransform;
// the four tools things we'll use to draw
import java.awt.Shape; // Shape interface
import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
/**
   A component that draws an animated picture by Jakob Staahl
   
   @author Shayan Sadigh
   @version CS56, Winter 2015
   
*/


public class AnimatedPictureComponent extends JComponent
{  
    private Shape ddrArr;
	private Shape ddrPad;
	private int x = 0;
	private int count = 0;

    // starting length: 300; width: 30
    /** Constructs an AnimatedPictureComponent with specific properties.
	This animated picture depicts a pencil writing across the screen

	@param startingXPos the starting x position of the pencil
    */
    public AnimatedPictureComponent() {
		ddrArr = new DDRArrow(200);
		ddrPad = new DDRPad(200);
		ddrPad = ShapeTransforms.translatedCopyOf(ddrPad, 220, 0);
    }

    /** The paintComponent method is orverriden to display
	out animation. Each time this method is called, the
	position of the pencil is updated
     */
    
   public void paintComponent(Graphics g)
   {  
       Graphics2D g2 = (Graphics2D) g;
       ddrArr = ShapeTransforms.rotatedCopyOf(ddrArr,0.02);
	   ddrPad = ShapeTransforms.translatedCopyOf(ddrPad, x, x);
	   if (count == 70) x = -2;
	   if (count == 0)   x = 2;
	   if (x == -2)   --count;
	   if (x == 2)   ++count;
	   g2.draw(ddrArr);
	   g2.draw(ddrPad);
   }    
  
}
