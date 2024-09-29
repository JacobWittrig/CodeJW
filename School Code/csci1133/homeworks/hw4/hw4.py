#Jacob Wittrig wittr049
#hw4.py
#HW4


#==========================================
# Purpose: This function creates new string and then capitalizes the first letter of the input and lowers the rest
# Input Parameter(s): The input string my_str which will be used for values
# Return Value(s): Returns a new string with capitalized first value and lowered rest
#==========================================
def str_capitalize(my_str):
    if len(my_str)==0:
        return ""
    return_str=""
    return_str+=my_str[0].upper()
    for i in range(1,len(my_str)):
        return_str+=my_str[i].lower()
    return return_str
        

#==========================================
# Purpose: The function will count the number of non-overlapping occurrences of the substring sub in the string. If sub is empty, the function returns the number of empty strings between characters which is the length of the my_str plus one.
# Input Parameter(s): my_str is the inputted string, and sub is the substring to be found
# Return Value(s): the count of occurences is returned. If sub is empty, the function returns the number of empty strings between characters which is the length of the my_str plus one.
#==========================================
def str_count(my_str,sub):
    count=0
    location=0
    increment=1
    if(sub==""):
        return len(my_str)+1
    while location<len(my_str)-len(sub):
        increment=1
        if(my_str[location:location+len(sub)]==sub):
            count+=1
            increment=len(sub)
        location+=increment
    return count

#==========================================
# Purpose: The function will return the index position where the first occurrence of val is found in in a string
# Input Parameter(s): my_str which is the string, and val which is searched for
# Return Value(s): returns the index position, or -1 if it is not found
#==========================================
def str_find(my_str,val):
    if(val==""):
        return 0
    for i in range(len(my_str)):
        if my_str[i:i+len(val)]==val:
            return i
    return -1

#==========================================
# Purpose: Returns the index position of a value within a specified substring of the given string
# Input Parameter(s): my_str - the string, val- the value searched for, start and end- the locations of the substring
# Return Value(s): returns the first instance of the value in the substring, -1 if not found
#==========================================
def str_find2(my_str,val,start=0,end=-1):
    if(end==-1):
        end=len(my_str)-1
    my_str=my_str[start:end]
    if(val==""):
        return 0+start
    for i in range(len(my_str)):
        if my_str[i:i+len(val)]==val:
            return i+start
    return -1

#==========================================
# Purpose: returns True if all characters are alphanumeric with at least one character
# Input Parameter(s): my_str is the input string
# Return Value(s): True or False
#==========================================
def str_isalnum(my_str):
    if(my_str==""):
        return False
    for letter in my_str:
        if not(letter.isalpha() or letter.isdecimal() or letter.isdigit() or letter.isnumeric()):
            return False
    return True

#==========================================
# Purpose: concatenates a string and a second string in a specific manner
# Input Parameter(s): my_str, the string to be added, and str_iter, the base string
# Return Value(s): the specific concatenation of the two strings.
#==========================================
def str_join(my_str,str_iter):
    ret_str=""
    for i in range (len(str_iter)):
        ret_str+=str_iter[i]
        if i!=len(str_iter)-1:
            ret_str+=my_str
    return ret_str

#==========================================
# Purpose: interleaves two strings and removes the integers
# Input Parameter(s): str1- the first string str2- the second string
# Return Value(s): returns the combination of the two strings
#==========================================
def rm_num_combine(str1,str2):
  retstring=""
  while len(str1)+len(str2)>0:
    if len(str1)>0:
        if not str1[0].isdigit():
            retstring+=(str1[0])
        str1=str1[1:]
    if len(str2)>0:
        if not str2[0].isdigit():
            retstring+=(str2[0])
        str2=str2[1:]
  return retstring


#==========================================
# Purpose: The main function is only called by me when I am testing this code.
# Input Parameter(s): There are no input parameters in main.
# Return Value(s): Nothing is returned by main. It only ensures functionality.
#==========================================

def main():
    print("String Capitalize: ")
    print(str_capitalize("heAAB"))
    print(str_capitalize("123heAAB"))
    print(str.capitalize("#$$$233"))
    print(str.capitalize(""))

    print("String Count: ")
    print(str_count("aaaabbbbb", "aa"))
    print(str_count("aaaabbbbb", ""))
    print(str_count("", ""))
    print(str_count("aaabaaab", "aa"))
    print(str_count("Jacob Wittrig is cool","o"))

    print ("String Find: ")
    print(str_find("aaacbaabb", "dd"))
    print(str_find("",""))
    print(str_find("aa", ""))
    print(str_find("aaabaaabbbb", "bb"))
    print(str_find("Jacob Wittrig", "Jacob"))

    print("String Find 2:")
    print(str_find2 ("aaabaaabbbb","bb",5,12))
    print(str_find2( "aaabaaabbbb","",5,9))
    print(str_find2 ("BBBBB","A"))
    print(str_find2("aaabaaabbbb", "b",5))

    print("Is Alphanumeric: ")
    print(str_isalnum("123abc"))
    print(str_isalnum( "123abc#"))

    print("String Join: ")
    print(str_join( "123", "abc"))
    print(str_join( "1", "abc"))
    print(str_join( "", "abc"))
    print(str_join( "", ""))

    print("Remove Number Combine: ")
    print(rm_num_combine( "a1c", "mn2z"))
    print(rm_num_combine( "", ""))
    print(rm_num_combine( "123", "456"))
    
if __name__ == "__main__":
    main()

