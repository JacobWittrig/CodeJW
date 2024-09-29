#Jacob Wittrig wittr049
#lab 7
#translate.py
def longest_substring(string):
    words=string.split()
    return_string=[]
    for word in words:
        new_word=word[0]
        for i in range(1,len(word)):
            if word[i] in new_word:
                break
            new_word+=word[i]
        return_string.append(new_word)
    return " ".join(return_string)
        

def main():
    print("longest_substring: ")
    print(longest_substring("abcdefabcdefg h98hjk12345"))
    print(longest_substring("Jacob Matthew Wittrig is cool."))

if __name__ == "__main__":
    main()
