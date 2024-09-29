def metric_conv (number,unit):
    if(unit=="pounds"):
        return (f"{(number*0.453592):.2f} kilos")
    if(unit=="kilos"):
        return (f"{(number/0.453592):.2f} pounds")
    if(unit=="ounces"):
        return (f"{(number*28.3495):.2f} grams")
    if(unit=="grams"):
        return (f"{(number/28.3495):.2f} ounces")
    if(unit=="miles"):
        return (f"{(number*1.60934):.2f} kilometers")
    if(unit=="kilometers"):
        return (f"{(number/1.60934):.2f} miles")
    if(unit=="inches"):
        return (f"{(number*2.54):.2f} centimeters")
    if(unit=="centimeters"):
        return (f"{(number/2.54):.2f} inches")
    return("Error")
    
    
def main():
    number=float(input("Input a floating-point number: "))
    unit=input("Input a measurement: ")
    if(metric_conv(number,unit)!="Error"):
        print(f"The conversion equivalent is {metric_conv(number,unit)}.")
    else:
        print("The units do not match any of those in the metric or imperial system, make sure units are lower case.")
    
if __name__ == "__main__":
    main()
