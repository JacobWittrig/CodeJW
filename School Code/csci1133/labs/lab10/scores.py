#lab10
#Jacob Wittrig wittr049
#score.py

def get_score(name,dictionary):
    if name not in dictionary.keys():
        return -1
    return dictionary[name]

def make_dictionary(l1,l2):
    score_dict=dict(zip(l1,l2))
    print(score_dict['barb'])
    score_dict['john']=19
    scores=list(score_dict.values())
    scores.sort()
    print(scores)
    avg=sum(scores)/len(scores)
    print(avg)
    del score_dict['tom']
    score_dict['sally']=13
    print(get_score('barb',score_dict))
    
    
   



def main():
    make_dictionary(['joe', 'tom', 'barb', 'sue', 'sally'],[10,23,13,18,12])

if __name__ == "__main__":
    main()
