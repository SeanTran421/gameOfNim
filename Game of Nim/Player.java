/**
 * Game of Nim Project
 * 
 * Player Class for the Game of Nim
 */

 //we're going to need a scanner to get the user's input of their names
import java.util.Scanner;

public class Player
{
    /// standard variables for said things
    private String name = "";
    private int points = 0;

    /// methods -> not sure which ones are constructors or mutators
    public Player()
    {
        ///ask user for name
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your name?");
        name = sc.nextLine();
        System.out.println(name);

        ///set the user's points
        points = 0;
    }

    ///constructors?
    public String getName()
    {
        return name; //will get you the name
    }
    
    public int getPoints()
    {
        return points; //will get you the points
    }

    ///mutators?
    public void addPoints()
    {
        points++; //will add the points
    }
}