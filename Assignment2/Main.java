import java.util.ArrayList;
import java.util.List;

// chessBoard [x][y]
// x-Axis: intAxis X numeric 0 - 7
// y-Axis: charAxis Y character a-b

public class Main {
    public static void main(String[] args) {





        Board board = new Board();
        Players players = new Players();
        Reader reader = new Reader();
        players.createPlayers();

        board.printBoard();

        //TODO resolve issue with Players List Array
        List<Player> allPlayers = players.getPlayers();
        boolean gameEnded = false;
        while(!gameEnded) {
            for (Player player : allPlayers) {

                //TODO Player take turn

                //TODO Jonas isCheck() aufrufen
                System.out.println("It's your turn, "+player.getName() +" (" +player.getColourSTR()+ ")");
                System.out.println();
                if(board.isCheck(player, players)){
                    if(board.isCheckMated(player,players)){
                        System.out.println("Your checkmated");//add good print
                        //gameEnded = true;
                    }
                    else{
                        System.out.println("You are in check");
                    }
                    System.out.println();}


                Boolean possibleMove = false;
                while (!possibleMove) {
                    ArrayList moveArray = reader.readMove(); //let player input move
                    if(board.tryMove(moveArray, player, players)) { //check if move is possible
                        possibleMove = true;
                        board.printBoard();
                    }
                }
                // int[] moveArray = reader.readMove();;
            }
        }
    }
}
