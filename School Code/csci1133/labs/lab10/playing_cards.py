#lab10
#Jacob Wittrig wittr049
#playing_cards.py

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




def main():
    rank, suit = rank_suit_count(['AS','AD','2C','TH','TS'])
    print(rank)
    print(suit)

if __name__ == "__main__":
    main()
