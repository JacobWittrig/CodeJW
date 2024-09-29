#Jacob Wittrig wittr049
#lab 7
#remove_punc.py
def remove_punc(text,punc):
    for val in punc:
        text=text.replace(val,"")
    return text

def main():
    print("remove_punc: ")
    print(remove_punc('Rem!ove, o?nly th3 exc!amati.n points!', '!'))
    print(remove_punc('??Ge!t r;!;id of m,o,s,t punctuation', '.!;,?'))

if __name__ == "__main__":
    main()
