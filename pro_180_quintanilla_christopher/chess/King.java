package pro_180_quintanilla_christopher.chess;

public class King extends ChessPiece
{
	private final char boardRepresentation;

	public King(boolean isWhite, Position p)
	{
		this.isWhite = isWhite;
		this.pos = p;
		if (isWhite)
		{
			boardRepresentation = 'k';
		} else
		{
			boardRepresentation = 'K';
		}
	}

	@Override
	public void placePiece()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public Position determineMovePosition(String move)
	{
		// TODO Auto-generated method stub
		Position newPos = Position.createPosition(move.substring(5));
		if (isPositionOnBoard(newPos))
		{
			if (Math.abs(newPos.getCol() - pos.getCol()) > 1 || Math.abs(newPos.getRow() - pos.getRow()) > 1)
			{
				System.out.println("That move is invalid");
				return pos;
			}
		} else
		{
			System.out.println("That move is invalid");
			return pos;
		}
		// pos = newPos;
		return newPos;

	}

	public Position determineCapturingPosition(String move)
	{
		Position newPos = Position.createPosition(move.substring(5, 7));
		if (isPositionOnBoard(newPos))
		{
			if (Math.abs(newPos.getCol() - pos.getCol()) > 1 || Math.abs(newPos.getRow() - pos.getRow()) > 1)
			{
				System.out.println("That move is invalid");
				return pos;
			}
		} else
		{
			System.out.println("That move is invalid");
			return pos;
		}
		// pos = newPos;
		return newPos;
	}

	public char getBoardRepresentation()
	{
		return boardRepresentation;
	}

	@Override
	public Position getPos()
	{
		// TODO Auto-generated method stub
		return pos;
	}

	@Override
	public void setPos(Position pos)
	{
		// TODO Auto-generated method stub
		this.pos = pos;
	}

}
