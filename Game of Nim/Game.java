/**
 * The Game Of Nim
 * 
 * The Game Class for the Game of Nim
 */

// going to need a scanner to find out what the user's put in
import java.util.Scanner;

public class Game {

    //variables that are set in place first hand
    private Player player1; //player
    private Player player2; //player
    boolean retry; //boolean

    /**
     * This method is to set the game up with the players name and setting the retry to true
     */
    public Game()
    {
        player1 = new Player();
        player2 = new Player();
        retry = true;
    }

    /**
     * This method is where the game will start.
     */
    public void play()
    {
        //variables needed for the whole game
        boolean gamePlay = true; //to see if the game is in progress still
        int currentPlayer = 1; //which player's turn is it

        //variables needed for the naming system and the turns as well
        String player1Name = player1.getName(); //name
        boolean player1Turn = false; //Just in case.
        boolean player2Turn = false; //Just in case.
        String player2Name = player2.getName(); //name

        //Scanner needed for player input
        Scanner input = new Scanner(System.in);

        //While loop that contains if the gameplay and retry are both true
        while(gamePlay && retry)
        {
            int currentPieces = Board.getNumPieces(); //current pieces on the board
            int tempPieces = currentPieces; //temporary pieces that will get the results

            int currentPlayer1Points = player1.getPoints(); //player1 points
            int currentPlayer2Points = player2.getPoints(); //player2 points

            System.out.println("There are " + currentPieces + " on the board.");

            //the if statement here is if the first player is having their turn
            if(currentPlayer == 1)
            {
                player1Turn = true; //validation for the while loop below
                while(player1Turn) //basically if the player puts in any foreign object, then it'll still be their turn
                {
                    String playerInput = ""; //input space for the player
                    System.out.println(player1Name + ", You have " + currentPlayer1Points + " points."); //current points
                    System.out.println(player1Name + ", it's your turn. How many will you take? (1 or 2)"); //prompt the player if they want to take one or two
                    playerInput = input.nextLine();
                    if(playerInput.equals("1")) //if they take one, the point will be added and the piece will be taken off
                    {
                        player1.addPoints();
                        tempPieces -= 1;
                        Board.setNumPieces(tempPieces);
                        if(tempPieces == 0) //if after taking the piece and there are no more pieces, then it'll turn the player's turn to false which would not meet the while player1turn loop and break the while loop.
                        {
                            player1Turn = false;
                            break;
                        }
                        currentPlayer = 2;
                        player1Turn = false;
                    }else if(playerInput.equals("2")) //if they take two, the poinst will be added and the pieces will be taken off
                    {
                        player1.addPoints();
                        player1.addPoints();
                        tempPieces -= 2;
                        Board.setNumPieces(tempPieces);
                        if(tempPieces == 0) //if after taking the piece and there are no more pieces, then it'll turn the player's turn to false which would not meet the while player turn loop and break the while loop.
                        {
                            player1Turn = false;
                            break;
                        }
                        currentPlayer = 2;
                        player1Turn = false;
                    }else{ //just in case for the foreign object, then the loop restarts
                        System.out.println("What was that? You need to say 1 or 2.");
                    }
                }
                //the if statement here is if the second player is having their turn
            }else if(currentPlayer == 2)
            {
                player2Turn = true; //validation for the while loop below
                while(player2Turn) //basically if the player puts in any foreign object, then it'll still be their turn
                {
                    String playerInput = ""; //inputs!
                    System.out.println(player2Name + ", You have " + currentPlayer2Points + " points.");
                    System.out.println(player2Name + ", it's your turn. How many will you take? (1 or 2)");
                    playerInput = input.nextLine();
                    if(playerInput.equals("1")) //if they take one, the point will be added and the piece will be taken off
                    {
                        player2.addPoints();
                        tempPieces -= 1;
                        Board.setNumPieces(tempPieces);
                        if(tempPieces == 0) //if after taking the piece and there are no more pieces, then it'll turn the player's turn to false which would not meet the while player turn loop and break the while loop.
                        {
                            player2Turn = false;
                            break;
                        }
                        currentPlayer = 1;
                        player2Turn = false;
                    }else if(playerInput.equals("2")) //if they take two, the poinst will be added and the pieces will be taken off
                    {
                        player2.addPoints();
                        player2.addPoints();
                        tempPieces -= 2;
                        Board.setNumPieces(tempPieces);
                        if(tempPieces == 0) //if after taking the piece and there are no more pieces, then it'll turn the player's turn to false which would not meet the while player turn loop and break the while loop.
                        {
                            player2Turn = false;
                            break;
                        }
                        currentPlayer = 1;
                        player2Turn = false;
                    }else{ //just in case for the foreign object, then the loop restarts
                        System.out.println("What was that? You need to say 1 or 2.");
                    }
                }
            }

            //what happens if one of the players took the last item, they'll win, then they'll have the option to retry
            if(currentPlayer == 1 && tempPieces == 0)
            {
                String playerInput = "";
                System.out.println("Congratulations, " + player1Name + ", You've won!");

                //while loop in case for foreign objects
                while(true)
                {
                    //ask the user if they want to try again
                    System.out.println("Do you want to try again? (yes/no)");
                    playerInput = input.nextLine(); //input!
                    if(playerInput.equals("yes")) //if they say yes, then the board would populate and the game would start again
                    {
                        System.out.println("Alright! Good luck!");
                        Board.populate();
                        break;
                    }else if(playerInput.equals("no")) //if they say no, then they'll list out the pieces each player has took
                    {
                        System.out.println("Ok! Let's see the results.");
                        System.out.println(player1Name + ", you have took " + currentPlayer1Points + " pieces.");
                        System.out.println(player2Name + ", you have took " + currentPlayer2Points + " pieces.");
                        System.out.println("gg!");
                        gamePlay = false;
                        retry = false;
                        break;
                    }else{
                        System.out.println("What was that? You have to say 'yes' or 'no'"); //just in case for the foreign object, then the loop restarts
                    }
                }

            }else if(currentPlayer == 2 && tempPieces == 0)
            {
                String playerInput = "";
                System.out.println("Congratulations, " + player2Name + ", You've won!");
                
                while(true) //while loop in case for foreign objects
                {
                    System.out.println("Do you want to try again?"); //asks the player if they want to try again
                    playerInput = input.nextLine(); //input!
                    if(playerInput.equals("yes")) //if they say yes, then the board would populate and the game would start again
                    {
                        System.out.println("Alright! Good luck!");
                        Board.populate();
                        break;
                    }else if(playerInput.equals("no")) //if they say no, then they'll list out the pieces each player has took
                    {
                        System.out.println("Ok! Let's see the results.");
                        System.out.println(player1Name + ", you have took " + currentPlayer1Points + " pieces.");
                        System.out.println(player2Name + ", you have took " + currentPlayer2Points + " pieces.");
                        System.out.println("gg!");
                        gamePlay = false;
                        retry = false;
                        break;
                    }else{
                        System.out.println("What was that? You have to say 'yes' or 'no'"); //just in case for the foreign object, then the loop restarts
                    }
                }
            }
        }

    }

    
}
