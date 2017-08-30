package main;

public abstract class Athlete {

    private String participantID;
    private String participantName;
    private String participantState;
    private int totalPoints;

    public  Athlete(String participantID, String participantName, String participantState, int totalPoints){
        this.participantID = participantID;
        this.participantName = participantName;
        this.participantState = participantState;
        this.totalPoints = 0;
    }




    public String getParticipantID(){
        return participantID;
    }

    public String getParticipantName(){
        return participantName;
    }

    public String getParticipantState(){
        return participantState;
    }

    public int getTotalPoints(){
        return totalPoints;
    }

    public void setParticipantState(String participantState) {
        this.participantState = participantState;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public void setParticipantID(String participantID) {
        this.participantID = participantID;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public abstract double Compete();



}
