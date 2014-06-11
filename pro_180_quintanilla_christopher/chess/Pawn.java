package pro_180_quintanilla_christopher.chess;

public class Pawn extends ChessPiece
{
	private final char boardRepresentation;
	private boolean isPastFirstMove;

	public Pawn(boolean isWhite, Position p)
	{
		this.isWhite = isWhite;
		this.pos = p;
		if (isWhite)
		{
			boardRepresentation = 'p';
		} else
		{
			boardRepresentation = 'P';
		}
		isPastFirstMove = false;
	}

	@Override
	public void placePiece()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public Position determineMovePosition(String move)
	{
		Position newPos = Position.createPosition(move.substring(5));
		if (isPositionOnBoard(newPos))
		{
			if (isPastFirstMove)
			{
				if (newPos.getCol() == pos.getCol() && Math.abs(newPos.getRow() - pos.getRow()) == 1)
				{
					return newPos;
				}

			} else
			{
				if (newPos.getCol() == pos.getCol() && Math.abs(newPos.getRow() - pos.getRow()) <= 2)
				{
					isPastFirstMove = true;
					return newPos;
				}
			}

		}
		return pos;

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

	public char getBoardRepresentation()
	{
		return boardRepresentation;
	}

	@Override
	public Position determineCapturingPosition(String move)
	{
		// TODO Auto-generated method stub
		Position newPos = Position.createPosition(move.substring(5, 7));
		if (isPositionOnBoard(newPos))
		{
			if (Math.abs(newPos.getCol() - pos.getCol()) == 1 && Math.abs(newPos.getRow() - pos.getRow()) == 1)
			{
				if (!isPastFirstMove)
				{
					isPastFirstMove = true;
				}
				return newPos;
			}

		}
		return pos;
	}

}
