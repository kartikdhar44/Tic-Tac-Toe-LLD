package org.kartik.player;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.kartik.observer.IObserver;
import org.kartik.ui.UI;


@AllArgsConstructor
public class Player implements IObserver<Player> {

    @Getter
    private final String name;

   private  PlayerState state;

   @Getter
   private final char symbol;


    @Override
    public void update(Player data) {
        if(data.getName().equals(name)){
            state=PlayerState.Won;
            UI.getInstance().display("Player " + name + " won");
        }
    }


    public enum PlayerState{
        IN_PROGRESS,
        Won,
        Lost,
    }
}
