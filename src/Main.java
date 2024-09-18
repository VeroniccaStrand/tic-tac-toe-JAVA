import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Player[] players = Game.initialize();
        Game game = new Game(players);
        game.startGame();



}}