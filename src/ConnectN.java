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

}
