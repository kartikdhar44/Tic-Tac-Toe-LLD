package org.kartik;

import org.kartik.ui.UI;

public class Main {
    public static void main(String[] args) {
        startGame();
    }



    //DEMO
   private static void startGame(){
        GameManager instance=initNewGame();

        instance.makeMove(0,0);
        instance.makeMove(1,0);
        instance.makeMove(0,1);
        instance.makeMove(1,1);
        instance.makeMove(0,2);
        UI.getInstance().display("---------------------------------------------------------------------");

        instance=initNewGame();

        instance.makeMove(0,0);
        instance.makeMove(1,0);
        instance.makeMove(0,1);
        instance.makeMove(1,1);
        instance.makeMove(2,2);
        instance.makeMove(1,2);
        UI.getInstance().display("---------------------------------------------------------------------");

        instance=initNewGame();

        instance.makeMove(0,0);
        instance.makeMove(0,1);
        instance.makeMove(0,2);
        instance.makeMove(1,1);
        instance.makeMove(1,0);
        instance.makeMove(1,2);
        instance.makeMove(2,1);
        instance.makeMove(2,0);
        instance.makeMove(2,2);
        UI.getInstance().display("---------------------------------------------------------------------");

       instance = initNewGame();

       instance.makeMove(0,0);
       instance.makeMove(0,1);
       instance.makeMove(1,1);
       instance.makeMove(0,2);
       instance.makeMove(2,2); // Player X wins

       UI.getInstance().display("---------------------------------------------------------------------");

       instance = initNewGame();

       instance.makeMove(0,2);
       instance.makeMove(0,0);
       instance.makeMove(1,1);
       instance.makeMove(1,0);
       instance.makeMove(2,0); // Player X wins

       UI.getInstance().display("---------------------------------------------------------------------");

       instance = initNewGame();

       instance.makeMove(0,2);
       instance.makeMove(0,0);
       instance.makeMove(1,2);
       instance.makeMove(1,0);
       instance.makeMove(2,2); // Player X wins (column 2)

       UI.getInstance().display("---------------------------------------------------------------------");



   }

   private static GameManager initNewGame(){
        GameManager instance=GameManager.createNewGame();
        instance.AddPlayer("Alice");
        instance.AddPlayer("Bob");
        instance.init();
        instance.printBoard();
        return instance;
    }


}