/**********************************************************************************************************************
 * Author:
 * Purpose: This class responsible for the swimmer athlete and how it process its compete method
 * Create Date: 28/07/2017
 * Version: 1.15
 * Update Date: 04/09/2017
 **********************************************************************************************************************/

package NewVersion;

import java.util.Random;

public class Runner extends Athlete {

    private String participantAbility;
    private int result;

    public Runner (String participantID, String participantName, String participantState, int participantAge) {
        super(participantID,participantName,participantState,participantAge);
        participantAbility = "Run";
    }

    @Override
    public String getParticipantAbility() {
        return participantAbility;
    }

    public int compete(String gameType) {

        int min = 10;  //min result in seconds
        int max = 20;  //max result in seconds
        Random random =  new Random();
        result = random.nextInt(max - min + 1) + min;//provides a number between 100 seconds to 200 second
        return result;
    }

    @Override
    public int getResult() {
        return result;
    }

//    public String printParticipant() {
//        return "ParticipantID: " + super.getParticipantID() +
//                "\tParticipant Name: " + super.getParticipantName();
//    }
}

