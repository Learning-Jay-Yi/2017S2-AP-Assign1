package AP1;


import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

    ArrayList<Athlete> participantArrayList = new ArrayList<>();
    ArrayList<Results> resultsArrayList = new ArrayList<>();

    ParticipationList participationList = new ParticipationList(); // why use this?

    Prediction prediction; // to store data prediction

    Results results;




    // main menu
    public void mainMenu(ArrayList<Athlete> athleteArrayList,ArrayList<Game> gameArrayList, ArrayList<Official> officialArrayList) {
        int mainMenuOption = 0;
        boolean bMainOption = false;
        while (mainMenuOption != 6){
            menuText();
            do {
                mainMenuOption = intTest(); // exception
                bMainOption = bMainOptionTest(mainMenuOption); // test mainMenuOption in the range
            } while (!bMainOption);
            bMainOption = false;
            switch (mainMenuOption){
                case 1:
                    gameMenu(athleteArrayList, gameArrayList);
                    break;
                case 2:
                    predictAthlete();
                    // todo
                    break;
                case 3:
                    startGame();
                    break;
                case 4:
                    // displayResult();
                    break;
                case 5:
                    // displayPoin();
                    break;
                case 6:
                    break;
            }
            // return a value to break loop.

        }
    }

    private boolean bMainOptionTest(int mainMenuOption) {
        if (mainMenuOption >= 1 && mainMenuOption <= 6)
            return true;
        else {
            System.out.println("\n\tYour option is invalid, please enter number between 1 to 6.");
            return false;
        }
    }

    private void menuText(){
        System.out.print("\tOlympic Game\t\n=============================\n" +
                "1.\tSelect a game to run\n" +
                "2.\tPredict the winner of the game\n" +
                "3.\tStart the game\n" +
                "4.\tDisplay the final results of all games\n" +
                "5.\tDisplay the points of all athletes\n" +
                "6.\tExit\n\n" +
                "Enter an option: ");
    }

    // system go in to select a game.
    private void gameMenu(ArrayList<Athlete> athleteArrayList, ArrayList<Game> gameArrayList){
        int gameMenuOption = 0 ;
        boolean bGameMenuOption = false;
            gameMenuText();
        do {
            gameMenuOption = intTest(); // exception
            bGameMenuOption = bGameMenuOptionTest(gameMenuOption); //test mainMenuOption in the range
        } while (!bGameMenuOption);
        bGameMenuOption = true;

        switch (gameMenuOption){
            case 1: //Swimming
                // TODO: 2017/9/1 test gaming type
                // link to Swimming game
                athleteChoose("Swimming", athleteArrayList);
                break;
            case 2:
                // TODO: 2017/8/30
                athleteChoose("Cycling",athleteArrayList);
                // link to Cycling game
                break;
            case 3:
                // TODO: 2017/8/30
                athleteChoose("Running",athleteArrayList);
                // link to Cycling game
                break;
            case 4:
                // todo
                // back to main menu
                break;
        }
//        }
    }

    private boolean bGameMenuOptionTest(int gameMenuOption) {
        if (gameMenuOption >= 1 && gameMenuOption <= 4)
            return true;
        else {
            System.out.println("\n\tYour option is invalid, please enter number between 1 to 4.");
            return false;
        }
    }

    private void gameMenuText(){
        System.out.print("\tOlympic Game\t\n=============================\n" +
                "1.\tSwimming\n" +
                "2.\tCycling\n" +
                "3.\tRunning\n" +
                "4.\tBack to main menu without save game\n\n" +
                "Enter an option: ");
    }

    private void athleteChoose(String gameType, ArrayList<Athlete> athleteArrayList) {
        System.out.println("1\tadd athletes by yourself? (less than 8 athletes)\n" +
                "2\tadd athletes automatically (full fill)");
        int athleteNum = 0;
        int athleteChoose = 0;
        boolean bAthleteChoose = false;
        do {
            athleteChoose = intTest(); // exception
            bAthleteChoose = bAthleteChooseTest(athleteChoose); //test mainMenuOption in the range
        } while (!bAthleteChoose);
        bAthleteChoose = true;
        switch (athleteChoose){
            case 1:
                athleteNum =  athleteNo();
                addParticipationList(gameType, athleteArrayList, athleteNum);
                break;
            case 2:
                addParticipationList(gameType, athleteArrayList, 8);
                break;
        }
    }

    private boolean bAthleteChooseTest(int athleteChoose) {
        if (athleteChoose >= 1 && athleteChoose <= 2) return true;
        else {
            System.out.println("\n\tYour option is invalid, please enter number 1 or 2.");
            return false;
        }
    }

    private int athleteNo() {
        int athleteNum =0;
        boolean bAthleteNum = false;
        System.out.println("How many athletes your want to add?");
        do {
            athleteNum = intTest(); // how many athletes you want
            bAthleteNum = bAthleteNumTest(athleteNum); //test mainMenuOption in the range
        } while (!bAthleteNum);
        bAthleteNum = true;
        return athleteNum;
    }

    private void addParticipationList(String gameType, ArrayList<Athlete> athleteArrayList, int athleteNum) {
        Scanner input = new Scanner(System.in);

        for (int i =0; i < athleteNum; i++){
            participationList.listPlayers(gameType, athleteArrayList);
            System.out.println("Please enter athlete's ID to add athlete to play game.");
            System.out.println("Please add（" +(i+1)+" of "+athleteNum+"） athlete: ");
            String addParticipant = "";
            boolean bAddParticipant = false;
            boolean checkExist = false;

            // we need find a efficient way to do this
            do {
                addParticipant = input.next();
                for (int j=0; j< athleteArrayList.size(); j++){
                    if (addParticipant.equalsIgnoreCase(athleteArrayList.get(j).getParticipantID())){
                        // TODO: 2017/9/4 check the athlete exist in ParticipantArrayList or not!!
                        bAddParticipant = true;
                        // sth wrong here
                         // checkExist = checkExist(addParticipant);
                        break;
                    }
                }
                if (!checkExist)
                    System.out.println("This athlete already the add to list, please select again.");
                if (!bAddParticipant)
                    System.out.println("We don't have this athlete, please enter the existing athleteID.");
            } while (!bAddParticipant && !checkExist);
            bAddParticipant = false;
            checkExist = false;

            participantArrayList.add(athleteArrayList.get(i));
        }
        // System.out.println();



    }

    private boolean checkExist(String addParticipant) {
        boolean exist = false;
        for (int i = 0; i < participantArrayList.size(); i++){
            if (addParticipant.equalsIgnoreCase(participantArrayList.get(i).getParticipantID())) {
                exist = true;
            } else exist =  false;
        }
        return exist;
    }

    private boolean bAthleteNumTest(int athleteNum) {
        if (athleteNum >= 1 && athleteNum <= 8) return true;
        else {
            System.out.println("\n\tYour option is invalid, please enter number 1 or 8.");
            return false;
        }
    }

    // system go in to predict a athlete
    public void predictAthlete (){
        Scanner input = new Scanner(System.in);
        // TODO: 2017/8/30
        // list athletes from athleteChoose(String gameType)
        System.out.println("Select a athlete above to predict.\nPlease enter athlete ID");
        // input
        String athleteID = input.next(); // input sth but not right
        // TODO: 2017/8/30 compare athleteID with ArrayList which from athleteChoose(String gameType)
        // this is sth thing to learn how push and pull
        prediction.setPredicationID(athleteID);
    }

    public void startGame() {

        if(participantArrayList.size()<4){
            System.out.println("Sorry, the athlete numbers is less than 4, this game can not be accessed!");

        }
        // ProcessResults.class();


        if (prediction.compareAthlete(results))
            System.out.println("\t||★,:*:‧\\(￣▽￣)/‧:*‧°★*\t||" +
                    "\n\t||\t\t\t\t\t\t||"+
                    "\n\t||\t you predict\t\t|| " +
                    "\n\t||\tright athlete!\t\t||"+
                    "\n\t||\t\t\t\t\t\t||"+
                    "\n\t||★,:*:‧\\(￣▽￣)/‧:*‧°★*\t||");

    }

    private int intTest(){
        Scanner input = new Scanner(System.in);
        int inputInt = 0;
            try {
                inputInt = input.nextInt();
            } catch (Exception e){
                System.out.println("\n\tYour option is invalid, please enter number\n\n");
            }
        return inputInt;
    }


//        try{
//
//            mainMenuOption = input.nextInt();
//            if (mainMenuOption < 1 || mainMenuOption > 6)
//                System.out.println("\n\tYour option is invalid, please enter number between 1 to 6.");
//        }catch(InputMismatchException ime){
//
//            System.out.println("\n\tYour option is invalid, please enter number\n\n");
//
//
//        }


//    public void listPlayers(String gameType, ArrayList<Athlete> athleteArrayList) {
//
//        if (gameType.equalsIgnoreCase("Swimming")) {
//            for (int i = 0; i < athleteArrayList.size(); i++) {
//                if (athleteArrayList.get(i) instanceof Swimmer){
//                    System.out.println(athleteArrayList.get(i).printAthlete(););
//                }
////                swimmer.printAthlete();
////                superAthlete.printAthlete();
//            }
//
//
//        } else if (gameType.equalsIgnoreCase("Running")) {
//            for (int i = 0; i < athleteArrayList.size(); i++) {
////                runner.printAthlete();
////                superAthlete.printAthlete();
//
//            }
//        }else if ((gameType.equalsIgnoreCase("Cycling"))){
//            for (int i = 0; i < athleteArrayList.size(); i++) {
////                cyclist.printAthlete();
////                superAthlete.printAthlete();
//            }
//
//        }
//
//
//    }

}
