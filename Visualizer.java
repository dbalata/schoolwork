/**
 * Dylan Balata
 * CS 251
 * This class uses display in order to show a box,
 * a circle rotating on a circle, and a smiley face
 * in that order.
 */
import cs251.lab2.Display;

public class Visualizer {
    
    /**
     * Runs the three displays sequentially
     */
    public static void main(String[] args){
        Display myDisplay= new Display(2000,3);
        Box(myDisplay);
        Circle(myDisplay);
        Smiley(myDisplay);
    }
    /**
     * Traces an outline around the display in the shape of a square
     * @param myDisplay
     */
    
    public static void Box(Display myDisplay){
        for(int i=1; i<myDisplay.getWidth();i++){
            myDisplay.drawNextPoint(i, myDisplay.getHeight()-1);
        }
        for(int i=myDisplay.getHeight(); i>1; i--){
            myDisplay.drawNextPoint(myDisplay.getWidth()-1, i);
        }
        for(int i= myDisplay.getWidth(); i>1; i--){
            myDisplay.drawNextPoint(i, 1);
        }
        for(int i=1; i<myDisplay.getHeight();i++){
            myDisplay.drawNextPoint(1,i);
        }
    }
    
    /**
     * Traces a circle around a point on a second circle with both circles
     * continuously iterating.
     * @param myDisplay
     */
    public static void Circle(Display myDisplay){
        double centerX = myDisplay.getWidth()/2;
        double centerY = myDisplay.getHeight()/2;
        double pi = Math.PI;
        double firstRadius = 100;
        double secondRadius = 50;
        double firstAngle=pi/2;
        double x,y,newX,newY;
        for(double i = firstAngle; i<firstAngle+2*pi; i+=.01){
            x = centerX+firstRadius*Math.cos(i);
            y = centerY+firstRadius*Math.sin(i);
            newX = x+secondRadius*Math.cos(5*i);
            newY = y+secondRadius*Math.sin(5*i);
            myDisplay.drawNextPoint((int) newY, (int) newX);
        }
    }
    
    /**
     * Draws a smiley face like this =D
     * @param myDisplay
     */
    public static void Smiley(Display myDisplay){
        int firstXT = myDisplay.getWidth()/3;
        int thirdXT = myDisplay.getWidth()/3+firstXT;
        int centerX = myDisplay.getWidth()/2;
        int rad = myDisplay.getWidth()/2-myDisplay.getWidth()/6;
        int yHalf = myDisplay.getHeight()/2;
        double pi =Math.PI;
        double x,y;
        for(int i=50; i<yHalf+20; i++){
            myDisplay.drawNextPoint(firstXT,i);
        }
        for(int i=50; i<yHalf+20; i++){
            myDisplay.drawNextPoint(thirdXT, i);
        }
        for(double i=pi; i>0; i-=.01){
            x = centerX+rad*Math.cos(i);
            y = centerX+50+rad*Math.sin(i)/4;
            myDisplay.drawNextPoint((int)x,(int)y);
        }
        for(double i=pi; i>0; i-=.01){
            x = centerX+rad*Math.cos(i);
            y = centerX+50+rad*Math.sin(i);
            myDisplay.drawNextPoint((int)x,(int)y);
        }
    }
}

