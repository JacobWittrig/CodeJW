def expo(num1,num2):
    val=num1
    for i in range (num2-1):
        mult=0
        for i in range (val):
            mult+=num1
        num1=mult
    return num1
