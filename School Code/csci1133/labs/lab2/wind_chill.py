def wind_chill():
    temperature = float(input("Enter a temperature t in degrees Fahrenheit: "))
    wind_velocity = float(input("Enter a wind velocity v in miles/hour: "))
    windChill= 35.74 + .6215 * temperature - 35.75 * wind_velocity ** .16 + .4275 * temperature * wind_velocity**.16
    return windChill                            
