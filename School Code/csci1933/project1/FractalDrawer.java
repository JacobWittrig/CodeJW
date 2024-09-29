// FractalDrawer class draws a fractal of a shape indicated by user input
import java.awt.Color;
import java.util.Scanner;
public class FractalDrawer {
private double totalArea=0; // member variable for tracking the total area
public FractalDrawer() {
} // contructor

// drawFractal creates a new Canvas object
// and determines which shapes to draw a fractal by calling appropriate helper function
// drawFractal returns the area of the fractal
public double drawFractal(String type) {
    Canvas fractalCan = new Canvas(800,800);
    //Creates a new Canvas object to draw the fractals on
    Color startColor = new Color(255,165,0);
    //initializes a color that can be used when passed in to the drawers
    if (type.equals("circle")){
        drawCircleFractal(150, 400, 400, startColor, fractalCan, 7);
    }
    else if (type.equals("rectangle")){
        drawRectangleFractal(200, 200, 400, 400, startColor, fractalCan, 7);
    }
    else if (type.equals("triangle")){
        drawTriangleFractal(100, 100, 400, 400, startColor, fractalCan, 7);
    }

    return totalArea;
}

// drawTriangleFractal draws a triangle fractal using recursive techniques
public void drawTriangleFractal(double width, double height, double x, double
y, Color c, Canvas can, int level){
    Triangle addTriangle= new Triangle(x,y,width,height);
    c = new Color(150-5*(7-level),0+15*(7-level),255-30*(7-level));
    //makes a triangle specific color
    addTriangle.setColor(c);
    can.drawShape(addTriangle);
    //draws the triangle onto the Canvas
    this.totalArea+=addTriangle.calculateArea();
    //Each time this function is called, it adds to the class's total area
    if(level>=0){
        drawTriangleFractal(width*.5,height*.6, x+width*.7, y+height*.8, c, can, level-1);
        drawTriangleFractal(width*.8,height*.7, x+width*.6, y-height*.5, c, can, level-1);
        drawTriangleFractal(width*.5,height*.8, x-width*.6, y+height*.7, c, can, level-1);
        drawTriangleFractal(width*.6,height*.5, x-width*.8, y-height*.7, c, can, level-1);
        
    }
    //the changing values allow for a fractal that looks changes in each direction, yet is still a fractal
}

// drawCircleFractal draws a circle fractal using recursive techniques
public void drawCircleFractal(double radius, double x, double y, Color c,
Canvas can, int level) {
    Circle addCircle= new Circle(x,y,radius);
    c = new Color(255-25*(7-level),165-15*(7-level),0+30*(7-level));
    addCircle.setColor(c);
    can.drawShape(addCircle);
    this.totalArea+=addCircle.calculateArea();
    if(level>=0){
        drawCircleFractal(radius*.5, x-radius, y-radius, c, can, level-1);
        drawCircleFractal(radius*.5, x+radius, y-radius, c, can, level-1);
        drawCircleFractal(radius*.5, x-radius, y+radius, c, can, level-1);
        drawCircleFractal(radius*.5, x+radius, y+radius, c, can, level-1);
    }
}
//the circle fractal draws a "traditional" fractal

// drawRectangleFractal draws a rectangle fractal using recursive techniques
public void drawRectangleFractal(double width, double height, double x, double
y, Color c, Canvas can, int level) {
    
    Rectangle addRectangle= new Rectangle(x,y,width,height);
    c = new Color(150-5*(7-level),0+15*(7-level),255-30*(7-level));
    addRectangle.setColor(c);
    can.drawShape(addRectangle);
    this.totalArea+=addRectangle.calculateArea();
    if(level>=0){
        drawRectangleFractal(width*.5,height*.5, x-width*.5, y-height*.5, c, can, level-1);
        drawRectangleFractal(width*.5,height*.5, x+width*.5, y-height*.5, c, can, level-1);
        drawRectangleFractal(width*.5,height*.5, x-width*.5, y+height*.5, c, can, level-1);
        drawRectangleFractal(width*.5,height*.5, x+width*.5, y+height*.5, c, can, level-1);
        
    }
}
//The rectangle fractal draws in such a way that the size is halved, and the next iteration is still within the larger shapes

// main asks user for shape input, and then draws the corresponding fractal by sneding the scanner input to the drawing function
// it then prints the area of fractal
public static void main(String[] args){
    FractalDrawer fractal1933= new FractalDrawer();
    //initializes an instantiation of the class
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter in a shape type for fractal drawing: triangle, circle, or rectangle: ");
    String shape=scanner.nextLine();
    scanner.close();
    System.out.println("The area of this fractal is "+Double.toString(fractal1933.drawFractal(shape))+" pixels");

}
}