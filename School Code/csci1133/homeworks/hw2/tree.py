#Jacob Wittrig wittr049
#tree.py
#HW2

#==========================================
# Purpose: determines whether it will rain
# Input Parameter(s):  none
# Return Value(s): returns "Rain" or "No rain"
#==========================================

def tree():
    temp=int(input("what temperature is it (F):  "))
    if(temp>75):
        wind=int(input("what windspeed is it (mph):  "))
        if (wind>2):
            pres=int(input("what presure is it (Hg):  "))
            if(pres>24):
                return "Rain"
            else:
                return "No rain"
        else:
            return "No rain"
    else:
        wind=int(input("what windspeed is it (mph):  "))
        if (wind>6):
            return "Rain"
        else:
            pres=int(input("what presure is it (Hg):  "))
            if(pres>31):
                return "Rain"
            else:
                return "No Rain"
    return "Unreachable part of branch, error occured"
#==========================================
# Purpose: The main function is only called by me when I am testing this code.
# Input Parameter(s): There are no imput parameters in main.
# Return Value(s): Nothing is returned by main. It only ensures functionality.
#==========================================

def main():
   print(tree())      

if __name__ == "__main__":
    main()
