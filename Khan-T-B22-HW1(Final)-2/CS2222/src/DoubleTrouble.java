import java.util.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DoubleTrouble {

    int greenMarkers = 3;
    int orangeMarkers = 5;
    int yellowMarkers = 7;
    int currentPlayer;
    static int USER_TURN = 1;
    static int COMPUTER_TURN = 2;
    boolean gameFinished;


    //Note: user decides who goes first
    public void welcomeScreen() {
        System.out.println("Welcome to Double Trouble! What's your name?");
        Scanner name;
        name = new Scanner(System.in);
        String graderName = name.next();
        System.out.println("Thank you for playing my game " +graderName+ ", I hope you enjoy:)");
        System.out.println(" ");//to make it easier to read
    }


    public void chooseFirstPlayer() {
        // we want input from the user, so we're going to use the scanner class that we imported. in stack overflow example, †his was done in main method
        Scanner input;
        input = new Scanner(System.in);

        System.out.println("Who would you like to go first? Enter 1 for you or 2 for the computer");
        int player = input.nextInt();// nextInt parses through the data entered
        if (player == USER_TURN) {
            currentPlayer = USER_TURN;

        } else if (player == COMPUTER_TURN) {
            currentPlayer = COMPUTER_TURN;
        } else
            System.out.println("Invalid input. Please enter either 1 or 2");

        //we want to store what the user entered and then have that person/computer make the first LEGAL move


        //computer logic

        /*
        1. when the user inputs 2, bc of chooseFirstPlayer method, computer goes
        2. it will switch off when user is done with turn
        3. randomly selects color
        4. randomly selects number in range
        5. wins when can win (check if greenMarkers and yellowMarkers are 0, take all the yellow) //bunch of if statements

        Implementing it into GUI is secondary
         */
        System.out.println(" ");//to make it easier to read


    }

    public void playerTurn() {

        Scanner inputColor1;
        inputColor1 = new Scanner(System.in);

        //toDo player logic (CHECK)
        //tested on 11/2 @6:33 (CHECK)
        if (currentPlayer == USER_TURN) {

            System.out.println("Your turn! What color would you like to choose?");
            System.out.println("Type either 'GREEN', 'ORANGE', or 'YELLOW'");

            String color1 = inputColor1.next();

            //user chose Green
            if (color1.equals("GREEN")) {

                System.out.println(" ");//to make it easier to read
                if ((greenMarkers == 0) && !gameFinished) {
                    System.out.println("Green markers are finished, choose either 'ORANGE' or 'YELLOW'");
                    color1 = inputColor1.next();
                } else {
                    System.out.println("How many green markers would you like to remove?");
                    System.out.println("You can choose up to " + greenMarkers + " markers to remove");

                    int howManyGreen1 = inputColor1.nextInt();

                    if(howManyGreen1 > greenMarkers){
                        System.out.println("Invalid input. Please try a valid number (less than or equal to " + greenMarkers + " )");
                        howManyGreen1 = inputColor1.nextInt();
                    }

                    greenMarkers = (greenMarkers - howManyGreen1);

                    if(greenMarkers == 1){
                        System.out.println("There is " +greenMarkers+ " green marker left");
                    }
                    if(greenMarkers == 0){
                        System.out.println("The are no more green markers left");
                    }
                    if(!(greenMarkers==1)&&!(greenMarkers==0)){
                        System.out.println("Your turn is complete, there are " + greenMarkers + " green markers left");
                        System.out.println(" ");//to make it easier to read
                    }

                }

            }

            //user chose Orange
            if (color1.equals("ORANGE")) {

                System.out.println(" ");//to make it easier to read

                if ((orangeMarkers == 0) && !gameFinished){
                    System.out.println("Orange markers are finished, choose either 'GREEN' or 'YELLOW'");
                    color1 = inputColor1.next();
                } else {
                    System.out.println("How many orange markers would you like to remove?");
                    System.out.println("You can choose up to " + orangeMarkers + " markers to remove");

                    int howManyOrange1 = inputColor1.nextInt();

                    if(howManyOrange1 > orangeMarkers){
                        System.out.println("Invalid input. Please try a valid number (less than or equal to " + orangeMarkers + " )");
                        howManyOrange1 = inputColor1.nextInt();
                    }
                    orangeMarkers = (orangeMarkers - howManyOrange1);

                    if(orangeMarkers == 1){
                        System.out.println("There is " +orangeMarkers+ " orange marker left");
                    }
                    if(orangeMarkers == 0){
                        System.out.println("The are no more orange markers left");
                    }
                    if(!(orangeMarkers==1)&&!(orangeMarkers==0)){
                        System.out.println("Your turn is complete, there are " + orangeMarkers + " orange markers left");
                        System.out.println(" ");//to make it easier to read
                    }
                }
                }
            if (color1.equals("YELLOW")) {
                System.out.println(" ");//to make it easier to read

                if ((yellowMarkers == 0) && !gameFinished) {
                    System.out.println("Yellow markers are finished, choose either 'GREEN' or 'ORANGE'");
                    color1 = inputColor1.next();
                }
                else {
                    System.out.println("How many yellow markers would you like to remove?");
                    System.out.println("You can choose up to " + yellowMarkers + " markers to remove");

                    int howManyYellow1 = inputColor1.nextInt();

                    if(howManyYellow1 > yellowMarkers){
                        System.out.println("Invalid input. Please try a valid number (less than or equal to " + yellowMarkers + " )");
                        howManyYellow1 = inputColor1.nextInt();
                    }

                    yellowMarkers = (yellowMarkers - howManyYellow1);

                    if(yellowMarkers == 1){
                        System.out.println("There is " +yellowMarkers+ " yellow marker left");
                    }
                    if(yellowMarkers == 0){
                        System.out.println("The are no more yellow markers left");
                    }
                    if(!(yellowMarkers==1)&&!(yellowMarkers==0)){
                        System.out.println("Your turn is complete, there are " + yellowMarkers + " yellow markers left");
                        System.out.println(" ");//to make it easier to read
                    }

                }


            }
            if((greenMarkers == 0)&&(orangeMarkers == 0)&&(yellowMarkers == 0)){
                gameFinished = true;
                System.out.println("User won!");
                return;
            }


        }
        currentPlayer = COMPUTER_TURN;
    }
    //toDo computer logic (CHECK)
    //tested on 11/2 @6:33 (CHECK)

    public void computerTurn() {


        if (currentPlayer == COMPUTER_TURN) {
            System.out.println("Computer's turn!");
            System.out.println(" ");//to make it easier to read

            int computerChooseGreen = 1;
            int computerChooseOrange = 2;
            int computerChooseYellow = 3;

            //Random randColor = new Random();
            //int x = randColor.nextInt(4);

            ArrayList<Integer> possibleColors = new ArrayList<Integer>();
            // possible colors are any colors with > 0 markers in them

            if (greenMarkers > 0) {
                // if the green markers are > 0, add to list
                possibleColors.add(1);
            }
            if (orangeMarkers > 0) {//if computer chose orange on its turn, it just outputs "computer's turn"
                possibleColors.add(2);
            }
            if (yellowMarkers > 0) {
                possibleColors.add(3);
            }
            Collections.shuffle(possibleColors);

            if(possibleColors.isEmpty()){
                gameFinished = true;
                currentPlayer = USER_TURN;
                return;
            }
            int x = (int)possibleColors.get(0);
            //int x = (int)(Math.random() * possibleColors.size());

            if(possibleColors.size()==1){
                if (x == 1){
                    greenMarkers = 0;
                }
                if (x == 2){
                    orangeMarkers = 0;
                }
                if (x == 3){
                    yellowMarkers = 0;
                }

                gameFinished = true;
                return;
            }


            if (x == computerChooseGreen) {

                System.out.println("Computer chose to remove the green markers!");
                System.out.println(" ");//to make it easier to read

                int howManyGreenComp = ThreadLocalRandom.current().nextInt(1, greenMarkers + 1);
                greenMarkers = greenMarkers - howManyGreenComp;

                System.out.println("Computer removed " +howManyGreenComp + " marker(s)");
                System.out.println(" ");

                if(greenMarkers == 1){
                    System.out.println("There is " +greenMarkers+ " green marker left");
                }
                if(greenMarkers == 0){
                    System.out.println("The are no more green markers left");
                }
                if(!(greenMarkers==1)&&!(greenMarkers==0)){
                    System.out.println("Computer's turn is complete, there are " + greenMarkers + " green markers left");
                    System.out.println(" ");//to make it easier to read
                }

            }

            if (x == computerChooseOrange) {

                System.out.println("Computer chose to remove the orange markers!");
                System.out.println(" ");//to make it easier to read


                int howManyOrangeComp = ThreadLocalRandom.current().nextInt(1, orangeMarkers + 1);
                orangeMarkers = orangeMarkers - howManyOrangeComp;

                System.out.println("Computer removed " +howManyOrangeComp + " marker(s)");
                System.out.println(" ");

                if(orangeMarkers == 1){
                    System.out.println("There is " +orangeMarkers+ " orange marker left");
                }
                if(orangeMarkers == 0){
                    System.out.println("The are no more orange markers left");
                }
                if(!(orangeMarkers==1)&&!(orangeMarkers==0)){
                    System.out.println("Computer's turn is complete, there are " + orangeMarkers + " orange markers left");
                    System.out.println(" ");//to make it easier to read
                }

            }

            if (x == computerChooseYellow) {

                System.out.println("Computer chose to remove the yellow markers!");
                System.out.println(" ");//to make it easier to read


                int howManyYellowComp = ThreadLocalRandom.current().nextInt(1, yellowMarkers + 1);
                yellowMarkers = yellowMarkers - howManyYellowComp;

                System.out.println("Computer removed " +howManyYellowComp + " marker(s)");
                System.out.println(" ");

                if(yellowMarkers == 1){
                    System.out.println("There is " +yellowMarkers+ " yellow marker left");
                }
                if(yellowMarkers == 0){
                    System.out.println("The are no more yellow markers left");
                }
                if(!(yellowMarkers==1)&&!(yellowMarkers==0)){
                    System.out.println("Computer's turn is complete, there are " + yellowMarkers + " yellow markers left");
                    System.out.println(" ");//to make it easier to read
                }


            }
            }
            currentPlayer = USER_TURN;

        }

    public void playGame() {

        welcomeScreen();
        chooseFirstPlayer();

        gameFinished = false;
        while (!gameFinished) {
            if (currentPlayer == USER_TURN) {
                playerTurn();
            }
            else if (currentPlayer == COMPUTER_TURN){
                computerTurn();
            }

        }
        if ((gameFinished) && currentPlayer == COMPUTER_TURN) {
            System.out.println("Game is finished! Computer Won!");
        }
        if ((gameFinished) && currentPlayer == USER_TURN){
            System.out.println("Game is finished! You won! Congratulation:)");
        }
    }
}











