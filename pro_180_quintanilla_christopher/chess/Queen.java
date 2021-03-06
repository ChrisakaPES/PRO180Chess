package pro_180_quintanilla_christopher.chess;

public class Queen extends ChessPiece
{
	private final char boardRepresentation;

	public Queen(boolean isWhite, Position p)
	{
		this.isWhite = isWhite;
		this.pos = p;
		if (isWhite)
		{
			boardRepresentation = 'q';
		} else
		{
			boardRepresentation = 'Q';
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
			if (newPos.getCol() != pos.getCol() && newPos.getRow() != pos.getRow())
			{
				if ((Math.abs(newPos.getCol() - pos.getCol()) == Math.abs(newPos.getRow() - pos.getRow())))
				{
					// pos = newPos;
					return newPos;
				}
			} else if (newPos.getCol() == pos.getCol() || newPos.getRow() == pos.getRow())
			{

				return newPos;
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
			if (newPos.getCol() != pos.getCol() && newPos.getRow() != pos.getRow())
			{
				if ((Math.abs(newPos.getCol() - pos.getCol()) == Math.abs(newPos.getRow() - pos.getRow())))
				{
					return newPos;
				}
			} else if (newPos.getCol() == pos.getCol() || newPos.getRow() == pos.getRow())
			{

				return newPos;
			}
		}
		return pos;
	}

}
