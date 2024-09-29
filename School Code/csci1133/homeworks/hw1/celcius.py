# Jacob Wittrig, wittr049
# celcius.py
# HW1
print('This program converts Celcius to Fahrenheit and Kelvin\n')
Tc = float(input('Please enter the temperature in Celcius: '))
Tf = (Tc * 9/5) + 32
print ('The temperature in Fahrenheit is: ', int(Tf))
Tk = Tc + 273.15
print('The temperature in Kelvin is: ', int(Tk))
if Tf <= 32:
    print('It is cold!')
elif Tf >32 and Tf < 70:
    print('It is cool.')
else: print('It is warm.')
