#word_count
#Jacob Wittrig wittr049
#Lab 8

def word_count(fname):
    myfile= open(fname,"r")
    words=0
    for val in myfile.read().split():
        words+=1
    myfile.close()
    return words
    
    
def main():
    print(word_count("test_file.py"))

if __name__ == "__main__":
    main()
