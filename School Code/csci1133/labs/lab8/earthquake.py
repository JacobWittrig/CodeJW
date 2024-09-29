#earthquake.py
#Jacob Wittrig wittr049
#Lab 8
import os


def readfile(fname):
    if not os.path.exists(fname):
        print("Bad file name")
        exit()
    with open(fname) as f:
        lines_list = f.readlines()
        minimum=int(lines_list[0].split(',')[1])
        maximum=int(lines_list[0].split(',')[1])
        
        for line in lines_list:
            if(int(line.split(',')[1])<minimum):
                minimum=int(line.split(',')[1])
            if(int(line.split(',')[1])>maximum):
                maximum=int(line.split(',')[1])

    return(minimum,maximum)
    
    
def main():
    print(readfile("2.5_day.csv"))

if __name__ == "__main__":
    main()
