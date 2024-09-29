def BMR (weight,height,age,sex):
    if (sex=="M" or sex=="m" or sex=="male" or sex=="Male"):
        bmr=66+(6.3*weight)+(12.9*height)-(6.8*age)
    else:
        bmr=655+(4.3*weight)+(4.7*height)-(4.7*age)
    return bmr
        
def main():
    weight=float(input("Enter your weight: "))
    height=float(input("Enter your height: "))
    age=int(input("Enter your age: "))
    sex=input("Enter your sex: ")
    bmr=BMR(weight,height,age,sex)
    print(f"The amount of calories required for you to maintain weight is {bmr:.2f}, or {bmr/230:.2f} candy bars")
        

    
if __name__ == "__main__":
    main()
