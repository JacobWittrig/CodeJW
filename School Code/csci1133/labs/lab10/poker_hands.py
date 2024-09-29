#lab10
#Jacob Wittrig wittr049
#poker_hands.py
numbers=['2','3','4','5','6','7','8','9','T','J','Q','K','A']
def rank_suit_count(cards):
    rank={}
    suit={}
    for val in cards:
        if val[0] not in rank:
            rank[val[0]]=1
        else:
            rank[val[0]]+=1
        if val[1] not in suit:
            suit[val[1]]=1
        else:
            suit[val[1]]+=1
    return rank,suit

def poker_hand(cards):
    suit,rank=rank_suit_count(cards)
    nums=list(rank.keys())
    nums.sort()
    straight=False
    for i in range(10):
        x=list(numbers)
        x=x[i:i+5]
        x.sort()
        y=list(suit.keys())
        y.sort
        print(x)
        print(y)
        
        if(set(x)==set(y)):
            straight=True
    if(len(rank.keys()))==1 and straight:
        return "straight flush"
    for val in nums:
        if(val==4):
            return "four-of-a-kind"
    if len(nums)==2:
        return "full-house"
    if(len(suit))==1:
        return "flush"
    if(straight):
        return "straight"
    count2s=0
    for val in list(rank.values()):
        if val==3:
            return "three-of-a-kind"
        if val==2:
            count2s+=1
    if(count2s==2):
        return "two pair"
    if(count2s==1):
        return "one pair"
    return "high-card"
    

        



def main():
    print(poker_hand(['8D', '9D', 'TD', 'JD', 'QD']))

if __name__ == "__main__":
    main()
