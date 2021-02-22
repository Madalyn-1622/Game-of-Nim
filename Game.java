import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    private boolean playAgain = false;
    public Game()
    {
        player1 = new Player();
        player2 = new Player();
    }
    public void play()
    {
        Scanner sc = new Scanner(System.in);
      
        while (playAgain == true)
        {
            Player starterPlayer;
            int currPlayer = (int)(Math.random() + 1);
            if (currPlayer == 1)
            {
                starterPlayer = player1;
            }
            else 
            {
                starterPlayer = player2;
            }
            //loops until game ends
            while (Board.getNumPieces() > 1)
            {
                System.out.println("There are " + Board.getNumPieces() + " pieces.");
                System.out.println(starterPlayer.getName() + " you are first");
                System.out.println(" How many pieces you you like to remove?");
                int num = sc.nextInt();
                //check valid response
                while(num < 1 || num > Board.getNumPieces()/2)
                {
                    System.out.println(" How many pieces you you like to remove?");
                    num = sc.nextInt();
                }
                //removes pieces
                Board.removePieces(num);
                //switch players
                if (currPlayer == 1)
                {
                    currPlayer = 2;
                    starterPlayer = player2;
                }
                else 
                {
                    currPlayer = 1;
                    starterPlayer = player1;
                }
            }//game has ended
            playAgain = false; 
            int winnerPoints = 0;
            winnerPoints++;
            System.out.println(starterPlayer + " is the winner!");
            System.out.println("You have" + winnerPoints);
            System.out.println("Would you like to play again?");
            String play = sc.nextLine();
            if (play.equals("yes"))
            {
                playAgain = true;
            }
            //if they ask to play again repopulate the board
        }  
    }
}
