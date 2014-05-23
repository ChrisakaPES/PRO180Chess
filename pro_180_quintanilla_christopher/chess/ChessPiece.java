package pro_180_quintanilla_christopher.chess;

public abstract class ChessPiece
{
	static final char COLADJUSTVALUE = 'a';
	protected Position pos;
	protected boolean isWhite;

	public abstract Position getPos();

	public abstract void setPos(Position pos);

	public abstract void placePiece();

	public abstract void movePiece();

	public abstract char getBoardRepresentation();

	// public Position createPosition(String loc)
	// {
	// char c = loc.charAt(0);
	// c = (char) (c - COLADJUSTVALUE);
	// int column = (int) c;
	// int row = Integer.parseInt(loc.substring(1));
	//
	// return new Position(column, row);
	// }

}
