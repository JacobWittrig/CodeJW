# Jacob Wittrig, wittr049
# binomial.py
# HW1
import math
def choose(n, k):
    if(n>=k and k>0):
        return int(math.factorial(n) / (math.factorial(k) * math.factorial(n - k)))
    else:
        return ("Cannot perform operation with given input, make sure n>=k>0")
    
def main():
    print(choose(52,2)) #should print 1326
    
if __name__ == "__main__":
    
    main()
