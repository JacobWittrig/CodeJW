#readearthquake.py
#Jacob Wittrig wittr049
#Lab 8
import os


def readearthquake(fname):
    if not os.path.exists(fname):
        print("Bad file name")
        exit()
    with open(fname, encoding = "utf-8") as f:
        lines = f.readlines()[:38] + f.readlines()[39:]
        
                
        for number, value in enumerate(lines[0].split(',')):
            print(number,value)
       

    return("Done")

def readmag(fname):
    if not os.path.exists(fname):
        print("Bad file name")
        exit()
    with open(fname, encoding = "utf-8") as f:
        lines = f.readlines()[:38] + f.readlines()[39:]
        
        values = [x.split(",") for x in lines]
                           
                
        for i in values:
            print(i[4],i[14][:-1])
       

    return("Done")
    
    
def main():
    print(readearthquake("2.5_day.csv"))
    print(readmag("2.5_day.csv"))
if __name__ == "__main__":
    main()
