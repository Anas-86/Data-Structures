package TicTacToe_MinMax_Algorithmus;

import java.util.Collection;

public class TTTMiniMax {

    TTTPlayer maxPlayer;
    TTTPlayer minPlayer;

    public TTTMiniMax(){
        maxPlayer = new TTTPlayer('x');
        minPlayer = new TTTPlayer('o');
    }

    public TTTPosition solve(TTTPosition startPos){
        int score = Integer.MIN_VALUE;
        int alpha = Integer.MIN_VALUE;
        int beta = Integer.MAX_VALUE;
        TTTPosition bestPos = null;

        for(TTTPosition pos : startPos.getPossiblePositions(maxPlayer)){
            int value = minValue(pos, alpha, beta);
            if (score < value){
                bestPos = pos;
                score = value;
                alpha = Math.max(alpha, value);
            }
        }
        return bestPos;
    }

    public int minValue(TTTPosition pos, int alpha, int beta){
        int value = 1;

        // won = 1 ... gewonnen (max)
        // won = -1 ... nicht gewonnen (max)
        int won = 1;

        if(pos.hasWon(maxPlayer)) {
            return won;
        }

        Collection<TTTPosition> positions = pos.getPossiblePositions(minPlayer);

        if (positions.isEmpty()){
            return 0;
        }

        for(TTTPosition subPos : positions){
            value = Math.min(value, minValue(subPos, alpha, beta));
            if(value<=alpha){
                return value;
            }
            beta = Math.min(beta, value);

        }

        return value;
    }

    public int maxValue(TTTPosition pos, int alpha, int beta){
        int value = -1;

        // won = 1 ... gewonnen (min)
        // won = -1 ... nicht gewonnen (max)
        int won = -1;

        if(pos.hasWon(minPlayer)) {
            return won;
        }

        Collection<TTTPosition> positions = pos.getPossiblePositions(maxPlayer);

        if (positions.isEmpty()){
            return 0;
        }

        for(TTTPosition subPos : positions){
            value = Math.max(value, minValue(subPos, alpha, beta));
            if(value>=beta){
                return value;
            }
            alpha = Math.max(alpha, value);
        }

        return value;
    }

}
