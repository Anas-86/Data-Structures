package TicTacToe_MinMax_Algorithmus;

import java.util.Collection;
import java.util.LinkedList;

public class TTTPosition {

    private char[][] field;

    public TTTPosition(){
        field = new char[3][3];
    }

    public TTTPosition(TTTPosition pos){
        super();
        for(int i = 0; i < field.length; i++){
            for (int j = 0; j < field.length; j++){
                field[i][j] = pos.getPos(i, j);
            }
        }

    }


    public Collection<TTTPosition> getPossiblePositions(TTTPlayer player){
        LinkedList<TTTPosition> list = new LinkedList<>();

        for(int i = 0; i < field.length; i++){
            for (int j = 0; j < field.length; j++){
                if(field[i][j] == ' '){
                    TTTPosition pos = new TTTPosition();
                    pos.setPos(i, j, player);
                    list.add(pos);
                }
            }
        }
        return list;
    }

    public void setPos(int i, int j, TTTPlayer player){
        field[i][j] = player.getChar();
    }

    public char getPos(int i, int j){
        return field[i][j];
    }

    public boolean hasWon(TTTPlayer player){
        boolean hasWonCol;
        boolean hasWonRow;
        boolean hasWonDia1;
        boolean hasWonDia2;

        for(int i = 0; i < field.length; i++){
            hasWonCol = true;
            hasWonRow = true;
            for (int j = 0; j < field.length; j++){
                hasWonCol = hasWonCol&&(field[i][j] == player.getChar());
                hasWonRow = hasWonRow&&(field[j][i] == player.getChar());
            }
            if(hasWonCol || hasWonRow){
                return true;
            }
        }

/* & ... nur bitweise verknüpfung
   && ... prüft ganzen ausdruck
*/

        hasWonDia1 = true;
        hasWonDia2 = true;
        for(int i = 0; i < field.length; i++){
            hasWonDia1 = hasWonDia1 &&(field[i][i] == player.getChar());
            hasWonDia2 = hasWonDia2 &&(field[i][field.length-1-i] == player.getChar());
        }

        return hasWonDia1||hasWonDia2;

    }

}
