def is_prime(n):
    if(n==2):
        return True
    for x in range(2,n):
        if(n%x==0):
            return False
    return True
def sieve(n):
    return_list=[]
    for i in range (2,n+1):
        if(is_prime(i)):
            return_list.append(i)
    return return_list
