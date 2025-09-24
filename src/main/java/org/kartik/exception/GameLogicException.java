package org.kartik.exception;

public class GameLogicException extends RuntimeException {




    public GameLogicException(String message) {
        super(message);
    }


    public GameLogicException(String message, Throwable cause) {
        super(message, cause);
    }


    public GameLogicException(Throwable cause) {
        super(cause);
    }
}
