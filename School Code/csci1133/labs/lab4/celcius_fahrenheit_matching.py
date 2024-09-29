#==========================================
# Purpose: Finds the value when Celcius and Fahrenheit are the same.
# Input Parameter(s): None
# Return Value(s): Returns the Celcius value when Celcius and Fahrenheit are the same
#==========================================

def match_val():
    celcius=100
    found=False
    while(found==False):
        if(int(celcius)==int(9/5*celcius+32)):
           found=True
        else:
            celcius-=1
    return celcius       

#This returns -40
