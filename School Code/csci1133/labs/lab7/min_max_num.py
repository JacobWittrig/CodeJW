#Jacob Wittrig wittr049
#lab 7
#min_max_num.py
def min_max_nums(string):
    if(len(string)==0):
        return [0,0]
    words=string.split()
    minimum=len(words[0])
    maximum=len(words[0])
    for word in words:
        if len(word)<minimum:
            minimum=len(word)
        if len(word)>maximum:
            maximum=len(word)
    return [minimum,maximum]

def main():
    print("min_max_num: ")
    print(min_max_nums("The yellow kite was flying in the bright blue sky"))
    print(min_max_nums(""))

if __name__ == "__main__":
    main()
