package org.kartik.context;


import lombok.Builder;
import lombok.Getter;
import org.kartik.player.Player;


@Builder
public class PlayerInputContext {

    private final int row;
    private final int column;

    @Getter
    private final Player player;

    public int getRow(){
        return row;
    }

    public int getColumn(){
        return column;
    }

}
