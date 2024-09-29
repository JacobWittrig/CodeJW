def load():
    loan_amount=float(input("Enter a loan amount: "))
    annual_interest_rate=float(input("Enter an annual interest rate: "))
    loan_duration=float(input("Enter a loan duration (months): "))
    payment=annual_interest_rate/12*loan_amount/(1-(1+annual_interest_rate/12)**(-1*loan_duration))
    return payment
