/**
 * Game of Nim Project
 * 
 * Board Class for the Game Of Nim
 */

public class Board 
{
    //variable
    private static int numPieces = 0;

    //mutator
    /**
     * The method is to populate the board with 10 pieces
     */
    public static void populate()
    {
        setNumPieces(10);
    }

    //constructor
    /**
     * The method is to return the numPieces to the Game.java
     * @returns the number of pieces
     */
    public static int getNumPieces()
    {
        return numPieces;
    }

    //mutator
    /**
     * THe method is to set the numPieces variable to a specific integer
     */
    public static void setNumPieces(int pieces)
    {
        numPieces = pieces;
    }
}
