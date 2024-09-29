import java.awt.Color;
public class Circle {
    double xpos,ypos,radius;
    Color circleColor;
    public Circle(double x,double y,double r){
        this.xpos=x;
        this.ypos=y;
        this.radius=r;
    }
    //constructor takes x,y, and radius

    public double calculatePerimeter(){
        return this.radius * 3.1415926535 * 2;
    }
// Input: none
// Output: perimeter of the circle (type double)
    public double calculateArea(){
        return this.radius*this.radius*3.1415926535;
    }
// Input: none
// Output: area of the circle (type double)
    public void setColor(Color newColor){
        this.circleColor=newColor;
    }
// Input: color of the shape (type Color)
// Output: none (void)
    public void setPos(double newX, double newY){
        this.xpos=newX;
        this.ypos=newY;
    }
// Input: x, y position of the center (both doubles)
// Output: none (void)
    public void setRadius(double newRadius){
        this.radius=newRadius;
    }
// Input: radius (double)
// Output: none (void)
    public Color getColor(){
        return this.circleColor;
    }
// Input: none
// Output: color of the shape (type Color)
    public double getXPos(){
        return this.xpos;
    }
// Input: none
// Output: x position of the center (double)
    public double getYPos(){
        return this.ypos;
    }
// Input: none
// Output: y position of the center (double)
    public double getRadius(){
        return this.radius;
    }
// Input: none
// Output: radius (double)
}
