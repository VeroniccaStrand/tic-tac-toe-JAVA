
import java.util.Scanner;

public class Game {
    static Scanner input = new Scanner(System.in);
    private Board board;
    private Player[] players;
    private int currentPlayer;
    private boolean running;

    public static Player[] initialize(){
        System.out.println("Welcome to the tici taki toei Game!");
        System.out.println("Let us start with your names");
        Player[] players = new Player[2];



        char[] symbols = {'X', 'O'};

        for (int i = 0; i < 2; i++) {
            System.out.println("Name of Player " + (i + 1) + ": ");
            String playerName = input.next();

            char symbol = symbols[i % 2];

            players[i] = new Player(playerName, symbol);

            System.out.println(playerName + " is assigned marker: " + symbol);
        }
        return players;
    }

    public Game(Player[] players){
       this.players = players;
       this.currentPlayer = 0;

       this.running = true;
    }

    public void startGame() {
        boolean keepPlaying = true;

        while (keepPlaying) {

            board = new Board();
            running = true;
            play();


            System.out.println("Do you want to play again? (yes/no)");
            String answer = input.next().trim().toLowerCase();

            if (!answer.equals("yes")) {
                keepPlaying = false;
            }
        }


        System.out.println("Final scores:");
        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.getScore() + " points");
        }
    }

    public void play() {
        int turns = 0;

        while (running && turns < 9) {
            board.draw();

            takeTurn(players[currentPlayer], board);

            if(board.checkWin()){
                System.out.println(players[currentPlayer].getName() + " won!");
                running = false;
                board.draw();
                players[currentPlayer].increaseScore();
            }else {

                currentPlayer = (currentPlayer + 1) % 2;
                turns++;
            }

            if (turns == 9 && running) {
                System.out.println("It's a tie!");
                running = false;
        } }

    }
public void takeTurn(Player player, Board board ) {
    System.out.println("Player " + player.getName() + " takes turn!");
    boolean valid = false;
    while (!valid) {
        System.out.println("Enter position for your mark ( 0-8 ) :");
        int position = input.nextInt();

       if(board.placeSymbol(position, player.getSymbol())){
           valid = true;
        }else {
            System.out.println("That is not a valid move");
        }
    }

}
}
