init = float(input("Initial Amount: ") )
halflife = float(input("Half-Life: ") )
time = float(input("Elapsed Time: ") )
residual = init * .5 ** (time/halflife)
print("Residual Amount Remaining is", residual)
print("Hello World")
