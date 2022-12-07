package application;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
    	ChessMatch chmatch = new ChessMatch();
    	List<ChessPiece> captured = new ArrayList<>();  

		while (true){
			try {
				UI.clearScreen();
				UI.printMatch(chmatch, captured);
				System.out.println();
				System.out.print("Origem: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				boolean[][] possibleMoves = chmatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chmatch.getPieces(), possibleMoves);
	
				System.out.println();
	
				System.out.print("Alvo: ");
				ChessPosition target = UI.readChessPosition(sc);
	
				ChessPiece capturedPiece = chmatch.performChessMove(source,target);
				
				if(capturedPiece != null) {
					captured.add(capturedPiece); 
				}
			}
			catch (ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			
		}


    }
    
}
