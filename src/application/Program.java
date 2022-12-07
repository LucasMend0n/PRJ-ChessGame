package application;

import chess.ChessMatch;

public class Program {
    
	public static void main(String[] args) {
    	ChessMatch chmatch = new ChessMatch(); 
    	UI.printBoard(chmatch.getPieces());
    	
    }
    
}
