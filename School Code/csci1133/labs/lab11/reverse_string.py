#lab 11
#Jacob Wittrig
#reverse_string.py

def reverse_string(string):
    if(len(string)<=1):
        return string
    return string[-1]+reverse_string(string[:-1])


def main():
    print("testing")
    print(reverse_string("olleh"))
    print(reverse_string("Jacob Wittrig is cool."))

if __name__ == "__main__":
    main()
