package org.kartik;


import lombok.Getter;
import org.kartik.context.PlayerInputContext;
import org.kartik.exception.GameLogicException;
import org.kartik.exception.Handler;
import org.kartik.observer.Subject;
import org.kartik.player.Player;

public class GameManager {

    private static GameManager Instance;

    @Getter private Player player1;
    @Getter private Player player2;

    Subject<Player> playerSubject;
    Subject<PlayerInputContext> playerInputContextSubject;
    @Getter private Board board;

    @Getter
    private Player currentPlayer;



    public void fireMatchWin(Player data){
        playerSubject.notifyObservers(data);
    }

    private void firePlayerInput(int row, int col){
        PlayerInputContext playerInputContext=PlayerInputContext.builder().player(currentPlayer)
                .row(row).column(col).build();
        playerInputContextSubject.notifyObservers(playerInputContext);
        switchCurrentPlayer();
    }


    public void switchCurrentPlayer(){
        currentPlayer=currentPlayer==player1?player2:player1;
    }

    public void printBoard(){
        board.display();
    }



    public void AddPlayer(String name){
       if(player1==null){
           AddPlayer1(name);
       }
       else{
           Handler.checkState(player2==null,"Player 2 already initialized");
           AddPlayer2(name);
       }
    }

    public void makeMove(int row, int col){
        firePlayerInput(row,col);
    }




    private void AddPlayer1(String name){
        player1=new Player(name, Player.PlayerState.IN_PROGRESS, 'O');
        System.out.println("Player 1 : " + player1.getName() + " Symbol : " + player1.getSymbol());
    }

    private void AddPlayer2(String name){
        player2=new Player(name, Player.PlayerState.IN_PROGRESS, 'X');
        System.out.println("Player 2 : " + player2.getName() + " Symbol : " + player2.getSymbol());
    }

    public void init(){
        Handler.checkState(player2!=null && player1!=null,"Player 1 and Player 2 not initialized");
        playerSubject=new Subject<>();
        playerSubject.register(player1);
        playerSubject.register(player2);
        currentPlayer=player1;
        playerInputContextSubject=new Subject<>();
        board=new Board(3,3);
        board.initBoard();
        playerInputContextSubject.register(board);
    }

    public static GameManager createNewGame(){
        Instance=new GameManager();
        return Instance;
    }



    public static GameManager getInstance() {
        if(Instance==null){
            throw new GameLogicException("Game not initialized");
        }
        return Instance;
    }

}
