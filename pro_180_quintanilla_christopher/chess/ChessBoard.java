package pro_180_quintanilla_christopher.chess;

import java.util.*;
import java.util.regex.Matcher;

public class ChessBoard
{
	public static final char COLADJUSTVALUE = 'a';
	char[][] board = new char[8][8];

	public ChessBoard()
	{
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				board[i][j] = '-';
			}
		}
	}

	public void displayBoard()
	{
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				System.out.print(board[i][j]);
			}
			System.out.println(i + 1);
		}
		for (int i = 0; i < 8; i++)
		{
			System.out.print((char) (i + COLADJUSTVALUE));
		}
		System.out.println();
	}

	public List<ChessPiece> setupBoard(List<String> moves)
	{
		ChessPiece piece;
		String pieceType;
		boolean isWhite;
		String loc;
		List<ChessPiece> piecesInPlay = new ArrayList<>();

		for (String move : moves)
		{

			Matcher m = FileIO.PLACING_PIECE_PATTERN.matcher(move);
			if (m.matches())
			{
				// String text = m.group(1);
				pieceType = FileIO.map.get(move.substring(0, 1));
				if (move.substring(1, 2).equals("l"))
				{
					isWhite = true;
				} else
				{
					isWhite = false;
				}

				isWhite = (move.substring(1, 2).equals("l"));

				loc = move.substring(2);
				piece = createPiece(pieceType, isWhite, loc);
				placePiece(piece);
				piecesInPlay.add(piece);
			}

		}
		return piecesInPlay;
	}

	public ChessPiece createPiece(String type, boolean side, String loc)
	{
		Position p = Position.createPosition(loc);
		ChessPiece cp = null;
		switch (type)
		{
		case "King":
			cp = new King(side, p);
			break;
		case "Queen":
			cp = new Queen(side, p);
			break;
		case "Rook":
			cp = new Rook(side, p);
			break;
		case "Bishop":
			cp = new Bishop(side, p);
			break;
		case "Knight":
			cp = new Knight(side, p);
			break;
		case "Pawn":
			cp = new Pawn(side, p);
			break;
		}

		return cp;

	}

	// public Position createPosition(String loc)
	// {
	// char c = loc.charAt(0);
	// c = (char) (c - (COLADJUSTVALUE - 1));
	// int col = (int) c;
	// int row = Integer.parseInt(loc.substring(1));
	//
	// return new Position(row, col);
	// }

	public void placePiece(ChessPiece cp)
	{
		Position placingTile = cp.getPos();
		board[placingTile.getRow() - 1][placingTile.getCol() - 1] = cp.getBoardRepresentation();
	}

	public void removePiece(ChessPiece cp)
	{
		Position placingTile = cp.getPos();
		board[placingTile.getRow() - 1][placingTile.getCol() - 1] = '-';
	}

	public boolean isPathClear(ChessPiece start, Position end)
	{
		if (start instanceof Knight)
		{
			return true;
		}
		int colDiff = start.getPos().getCol() - end.getCol();
		int rowDiff = start.getPos().getRow() - end.getRow();
		if (colDiff == 0)
		{
			if (rowDiff < 0) // piece moving down
			{
				for (int r = start.getPos().getRow(); r < end.getRow(); r++)
				{
					if (board[r - 1][start.getPos().getCol() - 1] != '-')
					{
						return false;
					}
				}
			} else
			// piece moving up
			{
				for (int r = start.getPos().getRow(); r > end.getRow(); r--)
				{
					if (board[r - 1][start.getPos().getCol() - 1] != '-')
					{
						return false;
					}
				}
			}
		} else if (rowDiff == 0)
		{
			if (colDiff < 0)// piece moving left
			{
				for (int c = start.getPos().getRow(); c < end.getRow(); c++)
				{
					if (board[start.getPos().getCol() - 1][c - 1] != '-')
					{
						return false;
					}
				}
			} else
			// piece moving right
			{
				for (int c = start.getPos().getCol(); c > end.getRow(); c--)
				{
					if (board[start.getPos().getRow() - 1][c - 1] != '-')
					{
						return false;

					}
				}
			}
		} else if (Math.abs(colDiff) == Math.abs(rowDiff)) // moving diagonally
		{
			if (rowDiff < 0 && colDiff < 0) // moving towards Bottom-Right
											// corner
			{
				int r = start.getPos().getRow();
				for (int c = start.getPos().getCol(); c < end.getCol(); c++)
				{
					if (board[r - 1][c - 1] != '-')
					{
						return false;
					}
					r++;
				}

			} else if (rowDiff < 0 && colDiff > 0) // moving towards Bottom-left
													// corner
			{
				int r = start.getPos().getRow();
				for (int c = start.getPos().getCol(); c > end.getCol(); c--)
				{
					if (board[r - 1][c - 1] != '-')
					{
						return false;
					}
					r++;
				}
			} else if (rowDiff > 0 && colDiff < 0) // moving towards top-right
													// corner
			{
				int r = start.getPos().getRow();
				for (int c = start.getPos().getCol(); c < end.getCol(); c++)
				{
					if (board[r - 1][c - 1] != '-')
					{
						return false;
					}
					r--;
				}
			} else if (rowDiff > 0 && colDiff > 0) // moving towards
													// Top-Left corner
			{
				int r = start.getPos().getRow();
				for (int c = start.getPos().getCol(); c > end.getCol(); c--)
				{
					if (board[r - 1][c - 1] != '-')
					{
						return false;
					}
					r--;
				}
			}
		}

		return true;

	}
}
