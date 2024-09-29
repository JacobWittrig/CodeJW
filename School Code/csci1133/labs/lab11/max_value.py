#lab 11
#Jacob Wittrig
#max_value.py

def max_value(mylist):
    if len(mylist)==1:
        return mylist[0]
    if(mylist[0]>mylist[-1]):
        return max_value(mylist[:-1])
    return max_value(mylist[1:])


def main():
    print("testing")
    print(max_value([1,4,6,3,7,4,7,3,2,8]))
    print(max_value([-1]))

if __name__ == "__main__":
    main()
