import math
def approx_by_term(term):
    sum=0
    negative_iterator=1
    term_iterator=0
    while(term_iterator<term):
        sum+=negative_iterator*1/(3**term_iterator*((2*term_iterator)+1))
        negative_iterator*=-1
        term_iterator+=1
    return(sum*6/math.sqrt(3))

def approx_pi():
    tolerance=float(input("Enter tolerance: "))
    terms=0
    prev_approx=100
    current_approx=10
    #100 is an arbitrary starting point
    while ((abs(prev_approx-current_approx))>tolerance):
        terms+=1
        prev_approx=current_approx
        current_approx=approx_by_term(terms)
    print(f"The approximation of pi is {current_approx}, which was found with {terms} terms to fit {tolerance} tolerance.")

        
