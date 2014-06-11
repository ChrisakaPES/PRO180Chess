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
		boolean isWhitesTurn = true;

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
						if (c.isWhite() == isWhitesTurn)
						{
							String whoseTurn = isWhitesTurn ? "White " : "Black ";
							if (Driver.checkForCheck(piecesInPlay, board, isWhitesTurn))
							{
								System.out.println(whoseTurn + "King is in check");
							} else
							{
								System.out.println(whoseTurn + "King is not in check");
							}

							board.removePiece(c);
							Position temp = c.determineMovePosition(currentMove);
							if (c.getPos().equals(temp))
							{
								System.out.println(c.getBoardRepresentation() + ": Move Ignored due to error");
							} else
							{
								if (board.isPathClear(c, temp))
								{
									c.getPos().setCol(temp.getCol());
									c.getPos().setRow(temp.getRow());
									isWhitesTurn = !isWhitesTurn;

								} else
								{
									System.out.println(c.getBoardRepresentation() + ": Path was not clear");
								}
							}
							board.placePiece(c);

							board.displayBoard();
							break;
						} else
						{
							System.out.println(c.getBoardRepresentation() + ": Turn ignored to sustain proper move order");
							break;
						}
					}

				} else if ((m = FileIO.CAPTURING_PIECE_PATTERN.matcher(currentMove)).matches())
				{
					Position p = Position.createPosition(currentMove.substring(1, 3));

					if (c.getPos().equals(p))
					{
						if (c.isWhite() == isWhitesTurn)
						{
							String whoseTurn = isWhitesTurn ? "White " : "Black ";
							if (Driver.checkForCheck(piecesInPlay, board, isWhitesTurn))
							{
								System.out.println(whoseTurn + "King is in check");
							} else
							{
								System.out.println(whoseTurn + "King is not in check");
							}

							board.removePiece(c);
							Position temp = c.determineCapturingPosition(currentMove);
							if (c.getPos().equals(temp))
							{
								System.out.println(c.getBoardRepresentation() + ": Move Ignored due to error");

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
									isWhitesTurn = !isWhitesTurn;

								} else
								{
									System.out.println(c.getBoardRepresentation() + ": Path was not clear");
								}
							}
							board.placePiece(c);

							board.displayBoard();
							break;
						} else
						{
							System.out.println(c.getBoardRepresentation() + ": Turn ignored to sustain proper move order");
							break;
						}

					} else if ((m = FileIO.MOVING_TWO_PIECES_PATTERN.matcher(currentMove)).matches())
					{

					}
				}
			}

		}
	}

	public static boolean checkForCheck(List<ChessPiece> pieces, ChessBoard board, boolean isWhitesTurn)
	{
		King k = null;
		char kingChar = isWhitesTurn ? 'k' : 'K';
		for (ChessPiece c : pieces)
		{
			if (c.getBoardRepresentation() == kingChar)
			{
				k = (King) c;
				break;
			}

			// if (isWhitesTurn)
			// {
			// if (c.getBoardRepresentation() == 'k')
			// {
			// k = (King) c;
			// break;
			// }
			// } else
			// {
			// if (c.getBoardRepresentation() == 'K')
			// {
			// k = (King) c;
			// break;
			// }
			// }
		}
		Position temp = null;
		for (ChessPiece c : pieces)
		{
			if (c.isWhite() != isWhitesTurn)
			{
				String potentialCheckMove = Character.toUpperCase(c.getBoardRepresentation()) + Position.createStringRepOfPosition(c.getPos()) + " "
						+ Character.toUpperCase(c.getBoardRepresentation()) + Position.createStringRepOfPosition(k.getPos()) + "*";
				if (!c.getPos().equals(temp = c.determineCapturingPosition(potentialCheckMove)))
				{
					board.removePiece(c);
					boolean clear = board.isPathClear(c, k.getPos());
					board.placePiece(c);
					if (clear)
					{
						return true;
					}

				}
			}
		}
		return false;
	}

}
