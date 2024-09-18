public class Player {
    private String name;
    private int score;
    private char symbol;


    public Player(String name, char symbol) {
        this.name = name;
        this.score = 0;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }



    public int getScore() {
        return score;
    }



    public char getSymbol() {
        return symbol;
    }

 public void increaseScore() {
        score ++;

 }
}
