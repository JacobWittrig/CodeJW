#Jacob Wittrig wittr049
#hw6.py
#HW6


#==========================================
# Purpose: SoccerPlayer is a class containing stats, id, and activity of the player
# Input Parameter(s): takes in the player id
# Return Value(s): is able to return the player information using getters.
#==========================================
class SoccerPlayer():
#==========================================
# Purpose: Initializes SoccerPlayer
# Input Parameter(s): The Player's ID and activity
# Return Value(s): None
#==========================================
    
    def __init__(self,player_id, active=True):
        self.__player_id=player_id
        self.__active=active
        self.__stats=[]
        
#==========================================
# Purpose: Sets active to input
# Input Parameter(s): boolean of activity
# Return Value(s): None
#==========================================

    def set_active(self,is_active):
        self.__active=is_active
        return None

#==========================================
# Purpose: Returns value of active
# Input Parameter(s): None
# Return Value(s): active
#==========================================

    def get_active(self):
        return self.__active

#==========================================
# Purpose: Returns value of player id
# Input Parameter(s): None
# Return Value(s): player id
#==========================================

    def get_player_id(self):
        return self.__player_id

#==========================================
# Purpose: Returns value of stats
# Input Parameter(s): None
# Return Value(s): stats
#==========================================

    def get_stats(self):
        return self.__stats

#==========================================
# Purpose: adds a stat to the player
# Input Parameter(s): the year, position, and number of goals and assists
# Return Value(s): None
#==========================================

    def add_stat(self,year,position,goals,assists):
        if year<2000:
            print("Year cannot start below 2000")
            return None
        if goals<0 or assists<0:
            print("Goals and assists cannot be less than 0")
            return None
        self.__stats.append([year,position,goals,assists])
        return None

#==========================================
# Purpose: Returns average goals per year
# Input Parameter(s): None
# Return Value(s): the average
#==========================================

    def average_goals(self):
        years_list=[]
        years_count=0
        goals_sum=0
        for year_pos in self.get_stats():
            if year_pos[0] not in years_list:
                years_list.append(year_pos[0])
                years_count+=1
            goals_sum+=year_pos[2]
        if years_count==0:
            return 0
        return goals_sum//years_count

#==========================================
# Purpose: Returns average assists per year
# Input Parameter(s): None
# Return Value(s): the average
#==========================================

    def average_assists(self):
        years_list=[]
        years_count=0
        assists_sum=0
        for year_pos in self.get_stats():
            if year_pos[0] not in years_list:
                years_list.append(year_pos[0])
                years_count+=1
            assists_sum+=year_pos[3]
        if years_count==0:
            return 0
        return assists_sum//years_count

#==========================================
# Purpose: Returns number of goals total, or for a year if year given
# Input Parameter(s): optional year
# Return Value(s): the total
#==========================================

    def number_of_goals(self,year=0):
        goals=0
        for year_pos in self.get_stats():
            if year_pos[0]==year or year==0:
                goals+=year_pos[2]
        return goals
    
#==========================================
# Purpose: Returns the formatted output for printing
# Input Parameter(s): None
# Return Value(s): the formatted return string
#==========================================

    def __str__(self):
        return(f"Player ID: {self.get_player_id()}\nActive: {self.get_active()}\nStats: {self.get_stats()}\nAvg Goals Over All Years: {self.average_goals()}\nAvg Assists Over All Years: {self.average_assists()}\n")
    
    
#==========================================
# Purpose: SoccerTeam is a class containing team name, league, and players
# Input Parameter(s): takes in the name and the league
# Return Value(s): is able to return varoius messages and information
#==========================================

class SoccerTeam():

#==========================================
# Purpose: Initializes SoccerTeaj
# Input Parameter(s): The team's name and league
# Return Value(s): None
#==========================================
    
    def __init__(self,soccer_team,league):
        self.__soccer_team=soccer_team
        self.__league=league
        self.__players=[]

#==========================================
# Purpose: Returns the players on the team
# Input Parameter(s): None
# Return Value(s): the list of players
#==========================================

    def get_players(self):
        return self.__players

#==========================================
# Purpose: iterates through the rosters and prints the players
# Input Parameter(s): None
# Return Value(s): None
#==========================================

    def print_roster(self):
        for player in self.get_players():
            print(player)

#==========================================
# Purpose: Returns the number of players in a given year
# Input Parameter(s): the year
# Return Value(s): the total number of players for the year
#==========================================            

    def count(self,year):
        players_counted=[]
        total=0
        for player in self.get_players():
            for year_pos in player.get_stats():
                if year_pos[0]==year and player.get_player_id() not in players_counted:
                    total+=1
                    players_counted.append(player.get_player_id())
                    
        return total

#==========================================
# Purpose: adds a player to the list of players
# Input Parameter(s): the player object
# Return Value(s): none
#==========================================

    def add_player(self,player):
        self.__players.append(player)

#==========================================
# Purpose: adds a stat to a player on the list
# Input Parameter(s): the player's id, the year, position, number of goals, and number of assists
# Return Value(s): none
#==========================================

    def stat_add(self,player_id,year,position,goals,assists):
        for player in self.get_players():
            if player.get_player_id() == player_id:
                player.add_stat(year,position,goals,assists)
                break

#==========================================
# Purpose: Returns the formatted output for printing
# Input Parameter(s): None
# Return Value(s): the formatted return string
#==========================================

    def __str__(self):
        total = 0
        for player in self.get_players():
            total+=player.number_of_goals()
        return f"{self.__soccer_team}: {total}"        
    


#==========================================
# Purpose: The main function is only called by me when I am testing this code.
# Input Parameter(s): There are no input parameters in main.
# Return Value(s): Nothing is returned by main. It only ensures functionality.
#==========================================

def main():
    players=[]
    PlayerA = SoccerPlayer(1,active=False)
    PlayerA.add_stat(2000,"striker",7,2)
    PlayerA.add_stat(2001,"striker",3,5)
    PlayerA.add_stat(2002,"goalie",8,3)
    players.append(PlayerA)
    PlayerB = SoccerPlayer(2,active=True)
    PlayerB.add_stat(2000,"defender",1,1)
    PlayerB.add_stat(2000,"striker",0,1)
    PlayerB.add_stat(2000,"defender",-1,2)
    players.append(PlayerB)
    PlayerC = SoccerPlayer(3)
    players.append(PlayerC)
    for player in players:
        print(player)
    print("Testing various functions: ")
    PlayerC.set_active(False)
    PlayerC.add_stat(2023,"left field",5,7)
    print(PlayerC.get_player_id())
    print(PlayerC.get_active())
    print(PlayerC.get_stats())
    print(PlayerC.average_goals())
    print(PlayerC.average_assists())
    print(PlayerC.number_of_goals(2022))

    print(f"\nTesting for team object:\n")
    print("Adding players: ")
    TeamA= SoccerTeam("TeamA","ALeague")
    TeamA.add_player(PlayerA)
    TeamA.add_player(PlayerB)
    TeamA.add_player(PlayerC)
    TeamA.stat_add(1,2000,"defender",10,10)
    print("Team name and goals: ")
    print(TeamA)
    print("Getting Players: ")
    print(TeamA.get_players())
    print("Printing Roster: ")
    TeamA.print_roster()
    print("Number of players in 2000: ")
    print(TeamA.count(2000))
    
                           
if __name__ == "__main__":
    main()

