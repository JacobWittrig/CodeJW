#Jacob Wittrig wittr049
#lab 7
#translate.py
def translate(string):
    string=string.lower()
    vowels="aeiou"
    punctuation=""
    message=string.split()
    translated=[]
    if not string[-1].isalpha():
        punctuation=string[-1]
        string=string[:-1]
    for word in string.split():
        new_word=word
        if new_word[0] not in vowels:
            while new_word[0] not in vowels:
               new_word+=new_word[0]
               new_word=new_word[1:]
            new_word+="ay"
        else:
            new_word+="way"
        translated.append(new_word)
    translated=" ".join(translated)
    translated=translated[0].upper()+translated[1:]+punctuation
    return translated

def main():
    print("translate: ")
    print(translate("Can you speak pig latin?"))
    print(translate("An apple a day keeps the doctor away"))

if __name__ == "__main__":
    main()
