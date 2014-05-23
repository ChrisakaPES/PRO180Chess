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
	public void movePiece()
	{
		// TODO Auto-generated method stub

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

}
