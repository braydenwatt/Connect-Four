import java.util.Random;

public class Board {
    private int columns;
    private int rows;
    private Piece[][] board;
    public Board(int n){
        this.columns = n;
        this.rows = n;
        board = new Piece[rows][columns];
        for (int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = new Piece("none", "none", 'N');
            }
        }
    }
    public void printBoard() {
        for(int i = 1; i <= columns; i ++){
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i = 1; i < columns*2; i ++){
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j].getState() == 'N'){
                    System.out.print("\u0000 ");
                } else {
                    System.out.print(board[i][j].getState() + " ");
                }
            }
            System.out.println();
        }
    }

    public String checkWin(){
        if(didPlayerWin("player 1")) return "player 1";
        if(didPlayerWin("player 2")) return "player 2";
        return "none";
    }
    public boolean didPlayerWin(String player){
        for(Piece[] row : board){
            for(int i = 0; i < row.length-3; i++){
                if(row[i].getPlayer() == player && row[i+1].getPlayer() == player && row[i+2].getPlayer() == player && row[i+3].getPlayer() == player){
                    return true;
                }
            }
        }
        //check vertical
        for(int c = 0; c < board[0].length; c++){
            for(int r = 0; r < board.length-3; r++){
                if(board[r][c].getPlayer() == player && board[r+1][c].getPlayer() == player && board[r+2][c].getPlayer() == player && board[r+3][c].getPlayer() == player){
                    return true;
                }
            }
        }
        //check diagonal
        for(int r = 0; r < board.length-3; r++){
            for(int c = 0; c < board[0].length-3; c++){
                if(board[r][c].getPlayer() == player && board[r+1][c+1].getPlayer() == player && board[r+2][c+2].getPlayer() == player && board[r+3][c+3].getPlayer() == player){
                    return true;
                }
            }
        }
        //check anti-diagonal
        for(int r = 0; r < board.length-3; r++){
            for(int c = 3; c < board[0].length; c++){
                if(board[r][c].getPlayer() == player && board[r+1][c-1].getPlayer() == player && board[r+2][c-2].getPlayer() == player && board[r+3][c-3].getPlayer() == player){
                    return true;
                }
            }
        }
        return false;
    }
   public  boolean moveDown(Piece piece, int c){
        for(int i = board.length - 1; i >= 0; i--){
            if(board[i][c - 1].getState() == 'N'){
                board[i][c-1] = piece;
                return true;
            }
        }
       System.out.println("column full, try again");
        return false;
    }
    public boolean validPlay(int play) {
        if (1 <= play && play <= columns) {
            return true;
        }
        System.out.println("invalid column number, try again");
        return false;
    }

}
