/**********************************************************************************************************************
 * Author:
 * Purpose: This is the control class that can hold most function and method to run a game.
 * Create Date: 28/07/2017
 * Version: 1.15
 * Update Date: 04/09/2017
 **********************************************************************************************************************/

package NewVersion;

public class Game {
    private String gameID;
    private String gameType;
    // Participant participant;

    public Game (String gameID, String gameType){
        this.gameID = gameID;
        this.gameType = gameType;
    }




    public void setGameID(String gameID) {
        this.gameID = gameID;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getGameID() {
        return gameID;
    }

    public String getGameType() {
        return gameType;
    }


    @Override
    public String toString() {
        return "gameID:" + getGameID() + "\tgameType:" +getGameType();
    }

}
