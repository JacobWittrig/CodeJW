import random
def hist():
    nums=[0 for i in range (12)]
    for i in range (10000):
        num1=random.randrange(1,7)
        num2=random.randrange(1,7)
        nums[num1+num2-1]+=1

    for i in range(2,len(nums)):
        print(f"{i+1}: {nums[i]}")
        
