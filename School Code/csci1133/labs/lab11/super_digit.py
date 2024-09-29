#lab 11
#Jacob Wittrig
#super_digit.py

def super_digit(num):
    if(num<10):
        return num
    total=0
    while num>0:
        total+=num%10
        num//=10
    return super_digit(total)

def main():
    print("testing")
    print(super_digit(1439))
    print(super_digit(245824406892))

if __name__ == "__main__":
    main()
