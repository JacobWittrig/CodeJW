#Jacob Wittrig wittr049
#basil.py
#HW2




def h_and_b (weight, height, age, gender):
#==========================================
# Purpose: calculates the Harris and Benedict BMR and returns the value as a float
# Input Parameter(s): weight, height, age, and gender
# Return Value(s): returns the BMR
#==========================================
    if(gender=="f"):
        return 655.1 + (9.563 * convert_pounds_to_kg(weight)) + (1.850 * convert_inches_to_cm(height)) - (4.676 * age)
    else:
        return 66.5 + (13.75 * convert_pounds_to_kg(weight)) + (5.003 * convert_inches_to_cm(height)) - (6.755 * age)
    
def r_and_s (weight, height, age, gender):
#==========================================
# Purpose: calculates the Roza and Shizgal BMR and returns the value as a float
# Input Parameter(s): weight, height, age, and gender
# Return Value(s): returns the BMR
#==========================================
    if(gender=="f"):
        return 447.593 + (9.247 * convert_pounds_to_kg(weight)) + (3.098 * convert_inches_to_cm(height)) - (4.330 * age)
    else:
        return 88.362 + (13.397 * convert_pounds_to_kg(weight)) + (4.799 * convert_inches_to_cm(height)) - (5.677 * age)
    

def m_and_s (weight, height, age, gender):
#==========================================
# Purpose: calculates the Millfin and St Jeor BMR and returns the value as a float
# Input Parameter(s): weight, height, age, and gender
# Return Value(s): returns the BMR
#==========================================
    if(gender=="f"):
        return 10 * convert_pounds_to_kg(weight) + 6.25 * convert_inches_to_cm(height) - 5 * age - 161
    else:
        return 10 * convert_pounds_to_kg(weight) + 6.25 * convert_inches_to_cm(height) - 5 * age + 5
    

def convert_pounds_to_kg (pounds):
#==========================================
# Purpose: Gives conversion of pounds to kg
# Input Parameter(s): pounds
# Return Value(s): kg number
#==========================================
    return pounds * 0.453592

def convert_inches_to_cm (inches):
#==========================================
# Purpose: Gives conversion of inches to cm
# Input Parameter(s): inches
# Return Value(s): cm number
#==========================================
    return inches * 2.54



def main():
#==========================================
# Purpose: The main function is only called by me when I am testing this code.
# Input Parameter(s): There are no imput parameters in main.
# Return Value(s): Nothing is returned by main. It only ensures functionality.
#==========================================
    age = int(input("Your current age:  "))
    gender = input("Your gender:  ")
    weight = int(input("Your weight (in pounds):  "))
    height = int(input("Your height (in inches):  "))
    print(f"Your weight in kilograms:  {convert_pounds_to_kg(weight):.1f}")
    print(f"Your height in centimeters:  {convert_inches_to_cm(height):.1f}")
    print(f"Harris and Benedict BMR:  {h_and_b(weight, height, age, gender):.1f}")
    print(f"Roza and Shizgal BMR:  {r_and_s(weight, height, age, gender):.1f}")
    print(f"Mifflin and St Jeor BMR:  {m_and_s(weight, height, age, gender):.1f}")
            

if __name__ == "__main__":
    main()
