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

		while (!chmatch.getCheckMate()) {
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

				ChessPiece capturedPiece = chmatch.performChessMove(source, target);

				if (capturedPiece != null) {
					captured.add(capturedPiece);
				}

				if (chmatch.getPromoted() != null) {
					System.out.print("Enter piece for promotion (B/C/T/Q): ");
					String type = sc.nextLine().toUpperCase();
					while (!type.equals("B") && !type.equals("C") && !type.equals("T") & !type.equals("Q")) {
						System.out.print("Invalid value! Enter piece for promotion (B/C/T/Q): ");
						type = sc.nextLine().toUpperCase();
					}
					chmatch.replacePromotedPiece(type);
				}
			} catch (ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}

		}
		UI.clearScreen();
		UI.printMatch(chmatch, captured);

	}

}
