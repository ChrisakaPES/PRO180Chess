package pro_180_quintanilla_christopher.chess;

public abstract class ChessPiece
{
	static final char COLADJUSTVALUE = 'a';
	protected Position pos;
	protected boolean isWhite;

	public abstract Position getPos();

	public abstract void setPos(Position pos);

	public abstract void placePiece();

	/**
	 * Will alter the position of the piece to match the input string if the
	 * move is valid it will return the new position if it is invalid it will
	 * return the same position
	 * 
	 * @throws InvalidMoveException
	 */
	public abstract Position determineMovePosition(String move);

	public abstract char getBoardRepresentation();

	// public Position createPosition(String loc)
	// {
	// char c = loc.charAt(0);
	// c = (char) (c - COLADJUSTVALUE);
	// int column = (int) c;
	// int row = Integer.parseInt(loc.substring(1));
	//
	// return new Position(row, column);
	// }

	public boolean isPositionOnBoard(Position p)
	{
		if (pos.getCol() > 8 || pos.getCol() < 1 || pos.getRow() > 8 || pos.getRow() < 1)
		{
			return false;
		}
		return true;
	}

	public abstract Position determineCapturingPosition(String move);

}
