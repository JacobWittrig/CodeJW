#make_csv.py
#Jacob Wittrig wittr049
#Lab 8
import random

def make_csv(fname):
    myfile= open(fname,"a")
    for i in range(100):
        myfile.write(f"{i}, {random.randrange(-1000,1001)}\n")
    myfile.close()
    return myfile
    
    
def main():
    print(make_csv("jacobscsv.csv"))

if __name__ == "__main__":
    main()
