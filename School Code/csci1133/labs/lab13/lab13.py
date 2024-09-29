import turtle
import random
myt=turtle.Turtle()
myt.speed(0)
myt.hideturtle()
turtle.Screen().bgcolor("black")
#myt.penup()
#myt.goto(40,40)
#myt.circle(100)
#myt.pendown()
#myt.circle(100)

#myt.fillcolor("red")
#myt.begin_fill()
#myt.circle(100)
#myt.end_fill()

#myt.penup()
#myt.goto(-50,-50)
#myt.pendown()
#myt.fillcolor("blue")
#myt.begin_fill()
#for i in range(4):
#    myt.forward(100)
#    myt.right(90)
#myt.end_fill()

def mouse_input(x,y):
    print(x,',',y)

#scr = myt.getscreen() #get the Screen object for myt
#scr.onclick(mouse_input)#register the button handler function
#scr.listen()

class Shape():
    def __init__(self,x=0,y=0,color="#000000"):
        self.x=x
        self.y=y
        self.color=color
        self.fill_color=""
        self.filled=False
        def set_fill_color(color):
            self.color=color
        def set_filled(filled):
            self.filled=filled
        def is_filled():
            return self.filled

class Circle(Shape):
    def __init__(self,x=0,y=0,radius=1,color="#000000"):
        super().__init__(x,y,color)
        self.radius=radius
    def draw(self,t):
        print(self.fill_color)
        t.penup()
        t.goto(self.x,self.y)
        t.pendown()
        t.fillcolor(self.color)
        t.begin_fill()
        t.circle(self.radius)
        t.end_fill()
        t.penup()

class Rectangle(Shape):
    def __init__(self,x=0,y=0,wide=1,len=1,color="#000000"):
        super().__init__(x,y,color)
        self.len=len
        self.wide=wide
    def draw(self,t):
        print(self.fill_color)
        t.penup()
        t.goto(self.x,self.y)
        t.pendown()
        t.fillcolor(self.color)
        t.begin_fill()
        for i in range(2):
            myt.forward(self.wide)
            myt.right(90)
            myt.forward(self.len)
            myt.right(90)
        t.end_fill()
        t.penup()        
            
#jacobscircle=Circle(50,50,100,"orange")
#jacobscircle.draw(myt)

class Display():
    def __init__(self):
        self.t1=turtle.Turtle()
        self.t1.hideturtle()
        self.t1.speed=0
        self.scr = self.t1.getscreen() #get the Screen object for myt
        self.scr.onclick(self.mouse_event)#register the button handler function
        self.scr.listen()
        self.elements=[]
        self.colors=["red","blue","white"]
    def mouse_event(self,x,y):
        num=random.randrange(0,2)
        for element in self.elements:
            if isinstance(element,Circle):
                print("is")
                if x>element.x-element.radius and x<element.x+element.radius:
                    self.elements.remove(element)
                    self.t1.clear()
                    myt.clear()
                    for element in self.elements:
                        element.draw(myt)
                    return None
            if isinstance(element,Rectangle):
                print("is")
                if x>element.x-element.len and x<element.x+element.len:
                    self.elements.remove(element)
                    self.t1.clear()
                    myt.clear()
                    for element in self.elements:
                        element.draw(myt)
                    return None
        if num%2==0:
            circ=Circle(x,y,random.randrange(100),random.choice(self.colors))
            self.elements.append(circ)
            circ.draw(myt)
        else:
            rect=Rectangle(x,y,random.randrange(100),random.randrange(100),random.choice(self.colors))
            self.elements.append(rect)
            rect.draw(myt)
        #self.t1.clear()
        #myt.clear()
        #for element in self.elements:
            #print(element)
            #element.draw(myt)

jacobdisplay=Display()

