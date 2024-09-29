import java.awt.Color;
public class Rectangle {
    double xpos,ypos,width,height;
    Color rectangleColor;
    public Rectangle(double x,double y,double w,double h){
        this.xpos=x;
        this.ypos=y;
        this.width=w;
        this.height=h;
    }
    //constructor takes in x, y, width, and height

    public double calculatePerimeter(){
        return 2 * this.height + 2 * this.width;
    }
// Input: none
// Output: perimeter of the rectangle (type double)
    public double calculateArea(){
        return this.width * this.height;
    }
// Input: none
// Output: area of the rectangle (double)
public void setColor(Color newColor){
    this.rectangleColor=newColor;
}
// Input: color of the shape (type Color)
// Output: none (void)
public void setPos(double newX, double newY){
    this.xpos=newX;
    this.ypos=newY;
}
// Input: x, y position of the center (both doubles)
// Output: none (void)
    public void setHeight(double newHeight){
        this.height=newHeight;
    }
// Input: height (double)
// Output: none
    public void setWidth(double newWidth){
        this.width=newWidth;
    }
// Input: width (double)
// Output: none
    public Color getColor(){
        return this.rectangleColor;
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
    public double getHeight(){
        return this.height;
    }
// Input: none
// Output: height (double)
    public double getWidth(){
        return this.width;
    }
// Input: none
// Output: width (double)
}
