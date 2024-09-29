def day_of_week (day,month,year):
    name_number=(day + 5 + ((26*(month+1))//10) + ((5*(year%100))//4) + ((21 * (year//100))//4))%7
    if (name_number==0):
        return "Monday"
    if (name_number==1):
        return "Tuesday"
    if (name_number==2):
        return "Wednesday"
    if (name_number==3):
        return "Thursday"
    if (name_number==4):
        return "Friday"
    if (name_number==5):
        return "Saturday"
    if (name_number==6):
        return "Sunday"
    
    
    
def main():
    day=int(input("Input the day as a number: "))
    month=int(input("Input the month as a number: "))
    if(month<3):
        month+=12
    year=int(input("Input the year as a number: "))
    print(f"The day of the week is {day_of_week(day,month,year)}")

    
if __name__ == "__main__":
    main()
