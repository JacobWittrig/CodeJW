#lab 11
#Jacob Wittrig
#flat_deep_square.py

def flat_deep_square(mylist):
    if len(mylist)==0:
        return []
    if type(mylist[0])==int:
        ret=[mylist[0]**2]
    if(type(mylist[0])==list):
        ret=flat_deep_square(mylist[0])
    return ret+flat_deep_square(mylist[1:])

def main():
    print("testing")
    print(flat_deep_square([[-1,[2],[3],[[[-4,5]]],[],[]]]))
    print(flat_deep_square([[-1,[3],[[[-4,5]]]]]))

if __name__ == "__main__":
    main()
