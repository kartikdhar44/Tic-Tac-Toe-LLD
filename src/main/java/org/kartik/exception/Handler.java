package org.kartik.exception;


import lombok.experimental.UtilityClass;

@UtilityClass
public class Handler {

    public void checkState(boolean expression, String message){
        if(!expression){
            throw new GameLogicException(message);
        }
    }

}
