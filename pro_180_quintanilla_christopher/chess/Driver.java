package pro_180_quintanilla_christopher.chess;

import java.util.*;

public class Driver
{
	public static void main(String[] args)
	{
		FileIO f = new FileIO();
		ArrayList<String> moves = f.convertFileToArrayList("src/moves.txt");
		f.displayMoves(moves);
		ChessBoard b = new ChessBoard();
		List<ChessPiece> piecesInPlay = b.setupBoard(moves);

		b.displayBoard();
	}
}
