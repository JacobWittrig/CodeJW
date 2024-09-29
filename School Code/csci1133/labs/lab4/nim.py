def nim():
    running=True
    player_first=input("Would you like to go first (y/n)? ")
    if(player_first=="y"):
        player_first=True
    else:
        player_first=False
    objects=21
    player_turn=player_first
    while (running):
        if(player_turn):
            subtract_number=int(input(f"{objects} objects remain, choose 1,2, or 3: "))
            objects-=subtract_number
            player_turn=False
        else:
            if((objects-1)%4==0):
                subtract_number=1
                print(f"{objects} objects remain, I'll take {subtract_number}")
            elif((objects-2)%4==0):
                subtract_number=2
                print(f"{objects} objects remain, I'll take {subtract_number}")
            elif((objects-3)%4==0):
                subtract_number=3
                print(f"{objects} objects remain, I'll take {subtract_number}")
            else:
                subtract_number=1
                print(f"{objects} objects remain, I'll take {subtract_number}")
            objects-=subtract_number
            player_turn=True
        if(objects==0):
            if(player_turn):
                print("I win.")
            else:
                print("You win!")
            running=False
    

