package chess;

import boardgame.BoardExeception;

public class ChessException extends BoardExeception {
    public static final long serialVersionUID = 1L;

    public ChessException(String msg){
        super(msg);
    }
}
