#Jacob Wittrig lab 12
#lab12.py

class Rational:
    def __init__(self, num=0, den=1):
        self.numerator = num
        if den == 0:
            self.denominator = 1
        else:
            self.denominator = den
    def __str__(self):
        if self.numerator==0:
            return 0
        if self.denominator==1:
            return self.numerator
        return str(self.numerator) + '/' + str(self.denominator)

    def scale(self,factor):
        self.numerator*=factor
        self.denominator*=factor
        

class Sentence():
    def __init__(self,string):
        self.string=string
    def getSentence(self):
        return self.string
    def getWords(self):
        return self.string.split(" ")
    def getLength(self):
        return len(self.string)
    def getNumWords(self):
        return len(self.getWords())

class SentenceV1():
    def __init__(self,string):
        self.string=string.split(" ")
    def getSentence(self):
        return " ".join(self.string)
    def getWords(self):
        return self.string
    def getLength(self):
        return len(self.getSentence())
    def getNumWords(self):
        return len(self.string)

class Poly():
    def __init__(self,val=[0]):
        self.coef=val
    def degree(self):
        return len(self.coef)
    def insertTerm(coef,exp):
        if exp>self.degree():
            self.coef.append([0 for i in range(coef-self.degree())])
        self.coef[exp-1]=coef
    def __str__(self):
        retstr=""
        coefs=self.coef[::-1]
        while len(coefs)>2:
            if(coefs[0]!=0):
                if(coefs[0]<0):
                    retstr+="-"
                    if(len(retstr)>1):
                        retstr+=" "
                if(coefs[0]>0 and len(retstr)>0):
                    retstr+="+ "
                if(abs(coefs[0]))!=1:
                    retstr+=str(abs(coefs[0]))
                retstr+="x^"+str(len(coefs)-2)+" "
            
            coefs=coefs[1:]
        if(coefs[0]!=0):
            if(coefs[0]<0):
                    retstr+="- "
            else:
                retstr+="+ "
            if(abs(coefs[0]))!=1:
                    retstr+=str(abs(coefs[0]))
            retstr+="x "
        coefs=coefs[1:]

        if(coefs[0]<0):
                retstr+="- "
        if(coefs[0]>=0 and len(retstr)>0):
                    retstr+="+ "
        retstr+=str(abs(coefs[0]))
        return retstr
        
            
    def integrate(self):
        for i in range(len(self.coef)):
            if(i!=0):
                self.coef[i]/=(i)
        self.coef=[0]+self.coef

def main():
    num1 = Rational(3,4)
    num2 = Rational(1,3)
    print(num1)
    num1.scale(3)
    print(num1)
    sentence=Sentence("Jacob Wittrig is cool")
    print(sentence.getNumWords())
    print("V1:")
    sentenceV1=SentenceV1("Jacob Wittrig is cool")
    print (sentenceV1.getSentence())
    num=Poly([1,1,0,4, -5, -7])
    print(num)
    num.integrate()
    print(num)
    


if __name__=="__main__":
    main()
