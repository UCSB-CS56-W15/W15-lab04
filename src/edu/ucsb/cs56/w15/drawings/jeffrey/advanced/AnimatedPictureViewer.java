package edu.ucsb.cs56.w15.drawings.jeffrey.advanced;
import javax.swing.JFrame;
import java.awt.event.*;
import java.lang.Integer.*;

/** A viewer class to see my clock animation using
 * the DisarmedClock and DisarmedAlarmClock classes.
 * Also requires the AnimatedPictureComponent class.
 *  
 * @author Jeffrey Chen
 * @version for UCSB CS56, W15, 02/20/2015
 */

public class AnimatedPictureViewer extends JFrame
{
    Thread animate;
    AnimatedPictureComponent component;
    static final double xCoord = 220;
    static final double yCoord = 150;
    static final double radius = 100;
    static final double animationSpeed = 200;

    /** constructs a JFrame with an animated picture inside
     */
    public AnimatedPictureViewer() {
		// Set the size to whatever size you like (width, height)
		// For projects you turn in, no bigger than 640,480	
		setSize(640,480);
		
		// Set your own title
		setTitle("Jeffrey Chen's Animated Clock");
		
		// Always do this so that the red X (or red circle) works
		// to close the window. 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Instantiate your drawing as a "component"
		component = new AnimatedPictureComponent(
			xCoord, yCoord, radius, animationSpeed);
		
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
					System.out.println("Running");
			    }//end mouseEntered
			    
			    public void mouseExited(MouseEvent e){
					//Terminate the animation.
					animate.interrupt();
					//Let the thread die a natural death.
					// Then make it eligible for garbage
					// collection.
					while (animate.isAlive()){}//loop;
					animate = null;
					System.out.println("Stopped");
			    }//end MouseExited
			}//end new MouseAdapter
		);//end addMouseListener()
		//End definition of anonymous inner class
		setVisible(true);
    }

    /** Animates picture component if mouse cursor within frame
    */
    class Animate extends Thread{
		public void run() {//begin run method
			// Increase/decrease delay based on animationSpeed
			Double delayTemp = new Double(1000*(1/animationSpeed));
			int delay = delayTemp.intValue();

		    try{
				//The following code will continue to
				// loop until the animation thread is
				// interrupted by the mouseExited 
				// method.               
				while(true){
					//Display several images in succession.

					display(delay);
				}//end while loop  
			}catch(Exception ex){
				if(ex instanceof InterruptedException){
					// Do nothing. This exception is
					// expected on mouseExited.    
				}
				else {//Unexpected exception occurred.
					System.out.println(ex);
					System.exit(1);//terminate program
				}//end else
		    }//end catch
		}//end run
		//-----------------------------------------//

		// This method displays an image and sleeps
		// for a prescribed period of time.  It 
		// terminates and throws an      
		// InterruptedException when interrupted
		// by the mouseExited method.     
		void display(int delay)
		    throws InterruptedException{
		    // Update the animation
		    component.repaint();
		    // Check interrupt status.  If interrupted
		    // while not asleep, force animation to
		    // terminate.              
		    if(Thread.currentThread().interrupted())
				throw(new InterruptedException());
		    // Delay specified number of msec.
		    // Terminate animation automatically if
		    // interrupted while asleep.  
		    Thread.currentThread().sleep(delay);
		}//end display method    
	//-----------------------------------------//
    }//end inner class named Animate

    public static void main(String[] args) {
		AnimatedPictureViewer apv = new AnimatedPictureViewer();
    }
}
