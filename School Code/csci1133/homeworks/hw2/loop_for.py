#Jacob Wittrig wittr049
#loop_for.py
#HW2

#==========================================
# Purpose: Returns the sum of the initial value added to itself minus the subtraction number x times
# Input Parameter(s): return_sum is the return value. times is the number of times to iterate. total is the initial value. sub is the subtraction constant.
# Return Value(s): return_sum gets returned.
#==========================================

def loop_for(total, sub, times):
    return_sum = 0
    for iteration_count in range (times):
        return_sum += total-sub
        total -= sub
    return return_sum

#==========================================
# Purpose: The main function is only called by me when I am testing this code.
# Input Parameter(s): There are no imput parameters in main.
# Return Value(s): Nothing is returned by main. It only ensures functionality.
#==========================================

def main():
   total = int(input("Please enter the current total:  "))
   sub = int(input("What number will be subtracted?  "))
   times = int(input("How many times should we subtract?  "))        
   print(loop_for(total, sub, times))          

if __name__ == "__main__":
    main()
