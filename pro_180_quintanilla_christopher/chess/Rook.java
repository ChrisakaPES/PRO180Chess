package pro_180_quintanilla_christopher.chess;

public class Rook extends ChessPiece
{
	private final char boardRepresentation;

	public Rook(boolean isWhite, Position p)
	{
		this.isWhite = isWhite;
		this.pos = p;
		if (isWhite)
		{
			boardRepresentation = 'r';
		} else
		{
			boardRepresentation = 'R';
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