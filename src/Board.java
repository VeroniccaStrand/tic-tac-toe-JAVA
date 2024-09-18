

public class Board {
    private char[] board;


    public Board() {
        board = new char[9];
        for (int i = 0; i < 9; i++) {
            board[i] = ' ';
        }

    }

    public void draw(){
        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2] + " ");
        System.out.println("---|---|---");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5] + " ");
        System.out.println("---|---|---");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8] + " ");
    }

    public boolean placeSymbol(int position, char symbol ){
        if(position >= 0 && position <=9 && board[position] == ' '){
            board[position] = symbol;
            return true;
        }else {
            System.out.println("Invalid position");
            return false;
        }
    }

    public boolean checkWin() {

        int[][] winConditions = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8},
                {0, 3, 6},
                {1, 4, 7},
                {2, 5, 8},
                {0, 4, 8},
                {2, 4, 6}
        };


        for (int[] condition : winConditions) {
            if (board[condition[0]] == board[condition[1]] &&
                    board[condition[1]] == board[condition[2]] &&
                    board[condition[0]] != ' ') {
                return true;
            }
        }
        return false;
}}
