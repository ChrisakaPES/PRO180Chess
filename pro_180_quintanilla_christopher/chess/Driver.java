package pro_180_quintanilla_christopher.chess;

import java.util.*;
import java.util.regex.Matcher;

public class Driver
{
	public static void main(String[] args)
	{
		FileIO f = new FileIO();
		ArrayList<String> moves = f.convertFileToArrayList("src/moves.txt");
		f.displayMoves(moves);
		ChessBoard board = new ChessBoard();
		List<ChessPiece> piecesInPlay = board.setupBoard(moves);
		Iterator<String> iterableMoveList = moves.iterator();

		while (iterableMoveList.hasNext())
		{
			String currentMove = iterableMoveList.next();
			Matcher m = null;
			for (ChessPiece c : piecesInPlay)
			{
				if ((m = FileIO.PLACING_PIECE_PATTERN.matcher(currentMove)).matches())
				{

				} else if ((m = FileIO.MOVING_PIECE_PATTERN.matcher(currentMove)).matches())
				{
					Position p = Position.createPosition(currentMove.substring(1, 3));
					if (c.getPos().equals(p))
					{
						board.removePiece(c);
						Position temp = c.determineMovePosition(currentMove);
						if (c.getPos().equals(temp))
						{
							System.out.println("Move Ignored due to error");
						} else
						{
							if (board.isPathClear(c, temp))
							{
								c.getPos().setCol(temp.getCol());
								c.getPos().setRow(temp.getRow());

							} else
							{
								System.out.println("Path was not clear");
							}
						}
						board.placePiece(c);

						board.displayBoard();
						break;
					}

				} else if ((m = FileIO.CAPTURING_PIECE_PATTERN.matcher(currentMove)).matches())
				{
					Position p = Position.createPosition(currentMove.substring(1, 3));
					if (c.getPos().equals(p))
					{
						board.removePiece(c);
						Position temp = c.determineCapturingPosition(currentMove);
						if (c.getPos().equals(temp))
						{
							System.out.println("Move Ignored due to error");
						} else
						{
							if (board.isPathClear(c, temp))
							{
								for (ChessPiece toBeCaptured : piecesInPlay)
								{
									if (toBeCaptured.getPos().equals(temp))
									{
										board.removePiece(toBeCaptured);
										break;
									}
								}
								c.getPos().setCol(temp.getCol());
								c.getPos().setRow(temp.getRow());

							} else
							{
								System.out.println("Path was not clear");
							}
						}
						board.placePiece(c);

						board.displayBoard();
						break;

					} else if ((m = FileIO.MOVING_TWO_PIECES_PATTERN.matcher(currentMove)).matches())
					{

					}
				}
			}

			// board.displayBoard();
		}
	}

}
