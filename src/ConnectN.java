import java.util.*;

public class ConnectN {
    private static int n = 0;
    private static final String RESET = "\u001B[0m";
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        play();
    }
    public static void play() {
        System.out.println("Choose board size (size x size)");
        n = scan.nextInt();
        scan.nextLine();
        Board board = new Board(n);
        int turn = 0;

        System.out.println("Player 1, choose piece shape (Char only)");
        char p1state = scan.nextLine().charAt(0);
        Piece p1 = new Piece("none","player 1", p1state);
        System.out.println("Player 2, choose piece shape (Char only)");
        char p2state = scan.nextLine().charAt(0);
        Piece p2 = new Piece("none","player 2",p2state);

        while(board.checkWin().equals("none")){
            board.printBoard();
            Piece currPiece;
            if(turn >=  n*n) {
                System.out.println("tie in " + turn + " turns");
                break;
            }
            if(turn % 2 == 0){
                System.out.println("Player 1, select a column: ");
                currPiece = p1;
            } else {
                System.out.println("Player 2, select a column: ");
                currPiece = p2;
            }
            boolean validPlay = false;
            int play = 0;
            while(!validPlay) {
                try {
                    play = scan.nextInt();
                    validPlay = true;
                } catch (Exception e){
                    System.out.println("invalid column number, try inputting an integer");
                    scan.next();
                }
            }
            if(!(board.validPlay(play)) || !(board.moveDown(currPiece, play))){
                turn--;
            }
            turn++;
        }
        board.printBoard();
        String winner = board.checkWin();
        if(winner != "none") {
            System.out.println("Congratulations, " + winner + "! You won in " + (turn / 2) + " turns");
        }
    }
    /*public static Player checkWin(Player player){
        //check horizontal
        for(Piece[] row : board){
            for(int i = 0; i < row.length-3; i++){
                if(row[i].getPlayer() == player && row[i+1].getPlayer() == player && row[i+2].getPlayer() == player && row[i+3].getPlayer() == player){
                    return player;
                }
            }
        }
        //check vertical
        for(int c = 0; c < board[0].length; c++){
            for(int r = 0; r < board.length-3; r++){
                if(board[r][c].getPlayer() == player && board[r+1][c].getPlayer() == player && board[r+2][c].getPlayer() == player && board[r+3][c].getPlayer() == player){
                    return player;
                }
            }
        }
        //check diagonal
        for(int r = 0; r < board.length-3; r++){
            for(int c = 0; c < board[0].length-3; c++){
                if(board[r][c].getPlayer() == player && board[r+1][c+1].getPlayer() == player && board[r+2][c+2].getPlayer() == player && board[r+3][c+3].getPlayer() == player){
                    return player;
                }
            }
        }
        //check anti-diagonal
        for(int r = 0; r < board.length-3; r++){
            for(int c = 3; c < board[0].length; c++){
                if(board[r][c].getPlayer() == player && board[r+1][c-1].getPlayer() == player && board[r+2][c-2].getPlayer() == player && board[r+3][c-3].getPlayer() == player){
                    return player;
                }
            }
        }
        return null;
    }*/
}
