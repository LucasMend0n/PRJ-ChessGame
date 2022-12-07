package application;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.Scanner;

public class Program {
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
    	ChessMatch chmatch = new ChessMatch();

		while (true){
			UI.printBoard(chmatch.getPieces());
			System.out.println();
			System.out.println("Origem: ");
			ChessPosition source = UI.readChessPosition(sc);

			System.out.println();

			System.out.println("Alvo: ");
			ChessPosition target = UI.readChessPosition(sc);

			ChessPiece capturedPiece = chmatch.performChessMove(source,target);
		}


    }
    
}
