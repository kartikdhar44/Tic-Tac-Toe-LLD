package org.kartik;

import org.kartik.context.PlayerInputContext;
import org.kartik.enums.State;
import org.kartik.exception.Handler;
import org.kartik.observer.IObserver;
import org.kartik.player.Player;
import org.kartik.strategy.DiagonalCheckStrategy;
import org.kartik.strategy.HorizontalCheckStrategy;
import org.kartik.strategy.IBoardCheckStrategy;
import org.kartik.strategy.VerticalCheckStrategy;
import org.kartik.ui.UI;

import java.util.Arrays;
import java.util.List;

import static org.kartik.enums.State.DRAW;

public class Board implements IObserver<PlayerInputContext> {

    private static final char X='X';
    private static final char O='O';
    private static final char EMPTY='E';


    private List<IBoardCheckStrategy> checkStrategyList;


    private final char[][] grid;
    private int cellsFilled;
    private int size;
    private State state;


    public Board(int rowCount, int columnCount){
        grid=new char[rowCount][columnCount];
        size=rowCount*columnCount;
        cellsFilled=0;
        initBoard();
        checkStrategyList=List.of(
                new HorizontalCheckStrategy(),
                new DiagonalCheckStrategy(),
                new VerticalCheckStrategy()
        );
        state=State.IN_PROGRESS;
    }

   public void display(){
        for(char[] row:grid){
            UI.getInstance().display(Arrays.toString(row));
        }
        UI.getInstance().display("<-----------------------------Matrix Ended----------------------------------------->");
   }


    public boolean DrawState(){
        return state==DRAW;
    }

    public boolean EndState(){
        return state==State.END;
    }



    public void initBoard(){
        for(char[] row:grid){
            Arrays.fill(row,EMPTY);
        }
    }

    private void checkBoardState(Player player){
         for(IBoardCheckStrategy strategy:checkStrategyList){
             char result=strategy.check(grid);
             if(result!=EMPTY) {
                 state=State.END;
                 GameManager.getInstance().fireMatchWin(player);
                 break;
             }
         }
    }

    private void checkBoard(int row, int column){
        Handler.checkState(row<grid.length && column<grid[0].length,"Invalid row or column");
        Handler.checkState(grid[row][column]==EMPTY,"Cell already filled");
        Handler.checkState(cellsFilled<9,"Board is full");
    }

    @Override
    public void update(PlayerInputContext data) {
        int column=data.getColumn();
        int row=data.getRow();
        checkBoard(row,column);
        grid[row][column]=data.getPlayer().getSymbol();
        display();
        checkBoardState(data.getPlayer());
        cellsFilled++;
        if(cellsFilled==size){
            state= DRAW;
            UI.getInstance().display("Match Ended in a Draw");
        }
    }


}
