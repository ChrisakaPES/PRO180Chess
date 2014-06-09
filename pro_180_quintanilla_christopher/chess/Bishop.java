package pro_180_quintanilla_christopher.chess;

public class Bishop extends ChessPiece
{
	private final char boardRepresentation;

	public Bishop(boolean isWhite, Position p)
	{
		this.isWhite = isWhite;
		this.pos = p;
		if (isWhite)
		{
			boardRepresentation = 'b';
		} else
		{
			boardRepresentation = 'B';
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
			if ((Math.abs(newPos.getCol() - pos.getCol()) == Math.abs(newPos.getRow() - pos.getRow())))
			{
				// pos = newPos;
				return newPos;
			}
		}
		System.out.println("That move is invalid");
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
			if ((Math.abs(newPos.getCol() - pos.getCol()) == Math.abs(newPos.getRow() - pos.getRow())))
			{
				// pos = newPos;
				return newPos;
			}
		}
		System.out.println("That move is invalid");
		return pos;
	}

}
