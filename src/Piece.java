public class Piece {
    private String color;
    private String player;
    private char state;

    public Piece(String color, String player, char state){
        switch(color) {
            case "red":
                color = "\u001B[31m";
                break;
            case "blue":
                color = "\u001B[34m";
                break;
        }
        this.color = color;
        this.player = player;
        this.state = state;
    }

    public String getPlayer() {
        return player;
    }
    public char getState(){
        return state;
    }
    public String getColor(){
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public void setState(char state) {
        this.state = state;
    }
}
