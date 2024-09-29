#lab 11
#Jacob Wittrig
#gcd.py

def gcd(a,b):
    if(b==0):
        return a
    return gcd(b,a%b)

def main():
    print("testing")
    print(gcd(30,21))

if __name__ == "__main__":
    main()
