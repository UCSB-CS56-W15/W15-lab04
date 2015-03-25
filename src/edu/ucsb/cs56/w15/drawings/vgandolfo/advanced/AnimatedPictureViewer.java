package edu.ucsb.cs56.w15.drawings.vgandolfo.advanced;
import javax.swing.JFrame;
import java.awt.event.*;

/** A viewer class to see a picture I drew with 
 *  just three simple Java graphics objects, namely
 *  Rectangle, Line2D.Double,
 *  
 * @author P. Conrad 
 * @author Vincent Gandolfo
 * @version for UCSB CS56, W15, 2/17/2015
 */

public class AnimatedPictureViewer extends JFrame
{
    Thread animate;
    AnimatedPictureComponent component;
    static final double x = 20;
    static final double y = 83;
    static final double speed1 = 1;
    static final double travelDistance = 580;
    static final double speed2 = 1;
    static final double startingLength = 225;
    static final double width = 125;
    

    /** constructs a JFrame with an animated picture inside
     */
    public AnimatedPictureViewer() {
	
	// Set the size to whatever size you like (width, height)
	// For projects you turn in, lets not get any bigger than 640,480	
	setSize(640,480);
	
	// Set your own title
	setTitle("Vincent Gandolfo's Animted Drawing");
	
	// Always do this so that the red X (or red circle) works
	// to close the window. 
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	// Instantiate your drawing as a "component"
	component = new AnimatedPictureComponent(x, y, speed1,
						 travelDistance, speed2,
						 startingLength, width);
	
	// Always add your component to the frame 
	// and then make the window visible
	
	add(component);

	getContentPane().addMouseListener(
					 new MouseAdapter(){
			    public void mouseEntered(MouseEvent e){
				  //Get a new animation thread and start
				    // the animation on it.
				 animate = new Animate();
				 animate.start();
						    }
						    
		 public void mouseExited(MouseEvent e){
			 //Terminate the animation.
			 animate.interrupt();
			  //Let the thread die a natural death.
			  // Then make it eligible for garbage
			  // collection.
		    while (animate.isAlive()){}
			 animate = null;
						    }
						}
						);
	
	setVisible(true);
    }

    public static void main(String[] args) {
	AnimatedPictureViewer apv = new AnimatedPictureViewer();
    }

    class Animate extends Thread{

	public void run(){
	    try{
		//The following code will continue to
		// loop until the animation thread is
		// interrupted by the mouseExited 
		// method.               
		while(true){
		     
		    display(10);
		}
	    }catch(Exception ex){
		if(ex instanceof InterruptedException){
		    //Do nothing. This exception is
		    // expected on mouseExited.    
		}else{//Unexpected exception occurred.
		    System.out.println(ex);
		    System.exit(1);
		}                
	    }              
	}          
	

	//This method displays an image and sleeps
	// for a prescribed period of time.  It 
	// terminates and throws an      
	// InterruptedException when interrupted
	// by the mouseExited method.     
	void display(int delay)
	    throws InterruptedException{
	    
	    component.repaint();
	               
	    if(Thread.currentThread().interrupted())
		throw(new InterruptedException());
	    //Delay specified number of msec.
	    //Terminate animation automatically if
	    // interrupted while asleep.  
	    Thread.currentThread().sleep(delay);
	}
	
    }    
}
