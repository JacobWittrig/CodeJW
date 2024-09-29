#Jacob Wittrig wittr049
#hw5.py
#HW5
import numbers
#helps me tell if a value type is a number

    

#==========================================
# Purpose: This function recursively creates a list of the steps it takes the base to be put to the nth power
# Input Parameter(s): n- the power it is rased to- and base- the number raised
# Return Value(s): returns list of steps raising base to the nth power
#==========================================

def base_seq(n,base):
    if(n<=0):
        return [1]
    return base_seq(n-1,base)+[base**n]

    

#==========================================
# Purpose: Finds the number of non-numbers in possible embedded lists
# Input Parameter(s): input_list - the possible embedded list
# Return Value(s): returns the count of non-numbers
#==========================================
def cnt_non_num(input_list):
    if len(input_list)==0:
        return 0
    if isinstance(input_list[0],numbers.Number):
        return cnt_non_num(input_list[1:])
    if isinstance(input_list[0],tuple) or isinstance(input_list[0],list):
        return cnt_non_num(input_list[0])+cnt_non_num(input_list[1:])+1
    else:
        return 1 + cnt_non_num(input_list[1:])
    

#==========================================
# Purpose: returns a dictionary with the minimum and maximum hours for each employee
# Input Parameter(s): the timechart dictionary "emp_diction"
# Return Value(s): returns the minimum / maximum dictionary with each employee
#==========================================
def min_max(emp_diction):
    min_max_dict={}
    for key in emp_diction:
        if(len(emp_diction[key])==0):
            min_max_dict[key]=[0,0]
        else:
            min_max_dict[key]=[min(emp_diction[key]),max(emp_diction[key])]
    return min_max_dict
#==========================================
# Purpose: The main function is only called by me when I am testing this code.
# Input Parameter(s): There are no input parameters in main.
# Return Value(s): Nothing is returned by main. It only ensures functionality.
#==========================================

def main():
    print("base_seq")
    print(base_seq(2, 2))
    print(base_seq(0, 2))
    print(base_seq(4, 4))
    print(base_seq(10, 2))

    print("cnt_non_num")
    print(cnt_non_num([1, 2, 3, 'abc', 5.5, [1, [2, 3, ("a", "b","c")]]]))
    print(cnt_non_num([]))
    print(cnt_non_num(["dog", "cat", "b", ["flower", 3.2,complex(5,4)]]))
    print(cnt_non_num([0, 99, 8.5]))
    print(cnt_non_num([[], [[]]]))

    print("min_max")
    print(min_max({"Shana": [20], "Jody": [10, 20, 10, 5], "Mike":[40, 40]}))
    print(min_max({"Shana": [20, 20, 20, 60, 70, 5], "Ahmed": [40, 50,10]}))
    print(min_max({}))
    print(min_max({"Marty": []}))
                           
if __name__ == "__main__":
    main()

