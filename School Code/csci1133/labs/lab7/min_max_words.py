#Jacob Wittrig wittr049
#lab 7
#min_max_words.py
def min_max_words(string):
    if(len(string)==0):
        return [[],[]]
    words=string.split()
    minimum=[words[0]]
    maximum=[words[0]]
    for word in words:
        if len(word)<len(minimum[0]):
            minimum=[word]
        if len(word)==len(minimum[0]) and word not in minimum:
            minimum.append(word)
        if len(word)>len(maximum[0]):
            maximum=[word]
        if len(word)==len(maximum[0]) and word not in maximum:
            maximum.append(word)
    return [minimum,maximum]

def main():
    print("min_max_num: ")
    print(min_max_words("The yellow kite was flying in the bright blue sky"))
    print(min_max_words(""))
    print(min_max_words("word"))

if __name__ == "__main__":
    main()
