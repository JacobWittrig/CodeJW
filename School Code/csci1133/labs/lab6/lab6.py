#wittr049 Jacob Wittrig
#Lab6
import random
import math

def matrix(n,init):
    matrix=[]
    for x in range(n):
        matrix.append([init for i in range(n)])
    return matrix

def order(m):
    if(len(m)==0):
        return 0
    if (len(m[0])==0):
        return 0
    length=len(m)
    width=len(m[0])
    return length*width

def identity(n):
    retmatrix=matrix(n,0)
    for x in range(n):
        for y in range(n):
            if(x==y):
                retmatrix[x][y]=1
    return retmatrix

def populate(mtrx,n,value):
    length=int(order(mtrx)**.5)
    for i in range(n):
        mtrx[random.randrange(0,length)][random.randrange(0,length)]=value
    return mtrx

def dist(p1,p2):
    return ((p1[0]-p2[0])**2+(p1[1]-p2[1])**2)**.5

def shortest_dist(points):
    distances=[]
    for x in range(len(points)):
        for y in range(len(points)):
            if(x!=y):
                distances.append(dist(points[x],points[y]))
    return min(distances)

def live_count(matrix):
    sum=0
    for x in matrix:
        for y in x:
            if y==1:
                sum+=1
    return sum-1

def lives(num,living):
    if (num<2 and living==True):
        return 0
    if (num>=2 and living==True):
        return 1
    if (num==3 and living==False):
        return 1
    else:
        return 0
                
def game_of_life():
    life_matrix=populate(matrix(100,0),5000,1)
    next_matrix=populate(matrix(100,0),0,0)
    running=5
    while running>0:
        for x in range(100):
            for y in range(100):
                check_matrix=matrix(3,0)
                xval=-1
                if(x>0):
                    xval=x-1
                yval=-1
                if(y>0):
                    yval=y-1
                for a in range(3):
                    for b in range(3):
                        check_matrix[a][b]=life_matrix[xval][yval]
                        yval+=1
                        if(yval>99):
                            yval=0
                    xval+=1
                    if(xval>99):
                        xval=0
                next_matrix[x][y]=lives(live_count(check_matrix),check_matrix[1][1])
        print(life_matrix)
        life_matrix=next_matrix
        running-=1
