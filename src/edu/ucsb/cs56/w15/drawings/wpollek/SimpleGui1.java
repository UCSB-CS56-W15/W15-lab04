package edu.ucsb.cs56.w15.drawings.wpollek;
import javax.swing.*;
import java.lang.Math;

/** SimpleGui1 comes from Head First Java 2nd Edition p. 355.
      It illustrates a simple GUI with a Button that doesn't do anything yet.

     @author Head First Java, 2nd Edition p. 355
     @author P. Conrad (who only typed it in and added the Javadoc comments)
     @author Wesley Pollek
     @version CS56, Winter 2015, UCSB
*/

public class SimpleGui1 {

    /** main method to fire up a JFrame on the screen  
          @param args not used
    */

    public static void main (String[] args) {
	JFrame frame = new JFrame() ;
	JButton button = new JButton("click me you sweet baboon") ;
	int r, g, b;
	r=(int)(Math.random()*256); g=(int)(Math.random()*256); b=(int)(Math.random()*256);
	java.awt.Color randcolor= new java.awt.Color(r,g,b);
	button.setBackground(randcolor);
	button.setOpaque(true);
	frame. setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE) ;
	frame. getContentPane() . add(button) ;
	frame. setSize(300,300) ;
	frame. setVisible(true) ;
    }
}
