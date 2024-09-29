#Jacob Wittrig wittr049
#hw3.py
#hw3

#==========================================
# Purpose: removes "D", "F", and "W" from a list and returns a new list with their count in the first part, and the remaining values in a list in the second part
# Input Parameter(s): mylist is the list of grades
# Return Value(s): returned list is a new list with the DFW count in the first part, and the remaining values in a list in the second part
#==========================================

def remove_grades(mylist):
    count_dfw=0
    count_dfw+=mylist.count("D")
    count_dfw+=mylist.count("F")
    count_dfw+=mylist.count("W")
    remaining_list=mylist[:]
    while remaining_list.count("D")>0:
        remaining_list.remove("D")
    while remaining_list.count("F")>0:
        remaining_list.remove("F")
    while remaining_list.count("W")>0:
        remaining_list.remove("W")
    return [count_dfw,remaining_list]

#==========================================
# Purpose: finds number of ints in a list, their average, and makes a list of them
# Input Parameter(s): a list of assorted values
# Return Value(s): returns a list that contains in the 0 th index position, the count of the number of ints, in the 1 st position, the average of the ints and in the 2nd index position a list of the ints themselves
#==========================================

def avg_ints(mylist):
    ints_list=[]
    int_count=0
    int_sum=0
    for val in mylist:
        if type(val)==int:
            ints_list.append(val)
            int_count+=1
            int_sum+=val
    if(int_sum==0 or mylist==[]):
        return [0, 0, [ ]]
    return [int_count,int(int_sum/int_count),ints_list]
    

#==========================================
# Purpose: finds the minimum of each list in a 2d list, then the ultimate minimum
# Input Parameter(s): a 2d list
# Return Value(s): the list of minimums, and the ultimate minimum
#==========================================

def all_minimums(mylist):
    min_list=[]
    if mylist==[]:
        return 0
    for list_iterator in mylist:
        if list_iterator==[]:
            minimum=0
        else:
            minimum=list_iterator[0]
        for val in list_iterator:
            if val<minimum:
                minimum=val
        min_list.append(minimum)
    ultimate_minimum=min_list[0]
    for val in min_list:
        if val<ultimate_minimum:
            ultimate_minimum=val
    return [min_list,ultimate_minimum]
        

#==========================================
# Purpose: finds if all numerical values of a list are less then x
# Input Parameter(s): the list of values and the maximum value x
# Return Value(s): returns True if all values are less then x, False if there are no numerical values or one is larger than x
#==========================================

def lesser_than(mylist,x):
    has_num=False
    is_less=True
    if mylist==[]:
        return False
    for val in mylist:
        if type(val)==int or type(val)==float:
            has_num=True
            if (val>=x):
                is_less=False
    return has_num and is_less

#==========================================
# Purpose: sorts a list by finding max values and putting them at end of unsorted vals
# Input Parameter(s): the input list to be sorted
# Return Value(s): returns the sorted list
#==========================================
def selection_sort(mylist):
    length=0
    for i in mylist:
        length+=1
    for count in range(length):
        unsorted_list=mylist[:length-count]
        maximum=unsorted_list[0]
        location=0
        unsorted_length=0
        for i in unsorted_list:
            unsorted_length+=1
        for loc in range(unsorted_length):
            if unsorted_list[loc]>maximum:
                maximum=unsorted_list[loc]
                location=loc
        mylist[location]=mylist[length-count-1]
        mylist[length-count-1]=maximum
    return mylist






#==========================================
# Purpose: The main function is only called by me when I am testing this code.
# Input Parameter(s): There are no imput parameters in main.
# Return Value(s): Nothing is returned by main. It only ensures functionality.
#==========================================

def main():
    print("remove_grades: ")
    print(remove_grades(["D", "F", "A", "A", "B", "W"]))
    print(remove_grades([]))
    print("avg_ints: ")
    print(avg_ints([1, 2, 4, "sadie", 4.4, "bottle", 7.7]))
    print(avg_ints([]))
    print("all_minimums: ")
    print(all_minimums([[1, 0, 5], [2, 3], [0, -1, 3]]))
    print(all_minimums([[], [1, 1, 1], []]))
    print(all_minimums([]))
    print("lesser_than: ")
    print(lesser_than([4, 4, 5.2, 6, "cat", "dog", 7.9, 8], 10))
    print(lesser_than([], 3))
    print(lesser_than([1,2,3], 2))
    print("selection_sort: ")
    print(selection_sort([3, 2, 1, 4, 0]))
        

if __name__ == "__main__":
    main()
