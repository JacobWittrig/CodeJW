def factorize():
    running=True
    while(running):
        num=int(input("Input a positive integer: "))
        print_val=""
        factor_iterator=2
        while(num>1):
            if(num%factor_iterator==0):
                print_val+=str(factor_iterator)
                num//=factor_iterator
                if(num>1):
                    print_val+="*"
                
            else:
                factor_iterator+=1
        print("Factors:",print_val)
        if(input("Continue (y/n)?")=="n"):
            running=False
            
