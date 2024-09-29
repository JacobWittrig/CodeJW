def digits():
    number=int(input("Enter a four-digit positive integer: "))
    print(number//1000)
    print((number-((number//1000)*1000))//100)
    print((number%100-number%10)//10)
    print(number%10)
