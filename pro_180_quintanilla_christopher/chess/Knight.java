package pro_180_quintanilla_christopher.chess;

public class Knight extends ChessPiece
{
	private final char boardRepresentation;

	public Knight(boolean isWhite, Position p)
	{
		this.isWhite = isWhite;
		this.pos = p;
		if (isWhite)
		{
			boardRepresentation = 'n';
		} else
		{
			boardRepresentation = 'N';
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
