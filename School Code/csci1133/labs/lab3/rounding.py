def round_float (number):
    if(number-int(number)<.5):
        return int(number)
    else:
        return int(number)+1
    
def main():
    number=float(input("Input a floating-point number: "))
    print(f"The rounded integer is {round_float(number)}")

    
if __name__ == "__main__":
    main()
