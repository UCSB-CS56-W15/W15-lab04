package edu.ucsb.cs56.w15.drawings.salolivares.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnimatedPictureViewer{
    private DrawPanel panel;
    private DesktopComputerWithMonitor computer;

    Thread animation;

    // position of drawing
    private int x = 150;
    private int y = 150;

    private int dy = 2;
    
    public static void main(String[] args){
        new AnimatedPictureViewer().go();
    }
    
    public void go(){
        // Declare new jframe and intialized animation panel
        JFrame frame = new JFrame();
        panel = new DrawPanel();

        frame.setSize(640,480);
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Declare event managers
        frame.getContentPane().addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                animation = new Animation();
                animation.start();
            }
            public void mouseExited(MouseEvent e){
                animation.interrupt();
                while(animation.isAlive()){}
                animation = null;
                panel.repaint();
            }
        });
    }

    class DrawPanel extends JPanel{
        public void paintComponent(Graphics g){
            Graphics2D g2 = (Graphics2D) g;

            //clear panel
            g2.setColor(Color.white);
            g2.fillRect(0,0,this.getWidth(),this.getHeight());


            //draw computer
            g2.setColor(Color.GREEN);
            computer = new DesktopComputerWithMonitor(x,y,100,150);
            g2.draw(computer);
        }
    }
    class Animation extends Thread{
        public void run(){
            try{
                dy = 2;
                while(true){
                    if(y >= 280){
                        dy = -(dy + 5);
                    }
                    if(y <= 50){
                        dy = dy + 5;
                    }

                    y += dy;
                    panel.repaint();

                    Thread.sleep(50);
                }
            } catch(Exception e){
                if(e instanceof InterruptedException){
                    //do nothing
                }
                else{
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }
    }

}
