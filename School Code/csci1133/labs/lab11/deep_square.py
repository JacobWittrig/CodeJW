#lab 11
#Jacob Wittrig
#deep_square.py

def deep_square(mylist):
    if len(mylist)==0:
        return []
    if type(mylist[0])==int:
        ret=[mylist[0]**2]
    if(type(mylist[0])==list):
        ret=[deep_square(mylist[0])]
    return ret+deep_square(mylist[1:])

def main():
    print("testing")
    print(deep_square([[-1,[2],[3],[[[-4,5]]],[],[]]]))
    print(deep_square([[-1,[3],[[[-4,5]]]]]))

if __name__ == "__main__":
    main()
