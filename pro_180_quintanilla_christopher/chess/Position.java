package pro_180_quintanilla_christopher.chess;

public final class Position
{
	private static final char COLADJUSTVALUE = '`';
	private static final char ROWADJUSTVALUE = '0';
	private int col, row;

	public Position(int row, int col)
	{
		this.col = col;
		this.row = row;
	}

	public int getCol()
	{
		return col;
	}

	public void setCol(int col)
	{
		this.col = col;
	}

	public int getRow()
	{
		return row;
	}

	public void setRow(int row)
	{
		this.row = row;
	}

	public static Position createPosition(String loc)
	{
		char c = loc.charAt(0);
		c = (char) (c - COLADJUSTVALUE);
		int column = (int) c;
		int row = Integer.parseInt(loc.substring(1));

		return new Position(row, column);
	}

	public boolean equals(Object o)
	{
		if (o instanceof Position)
		{
			Position p = (Position) o;
			if (p.getCol() == this.getCol() && p.getRow() == this.getRow())
			{
				return true;
			}
		}
		return false;
	}

	public static String createStringRepOfPosition(Position p)
	{
		String rep = "";
		char c = (char) (p.getCol() + COLADJUSTVALUE);
		rep = rep + c;

		char r = (char) (p.getRow() + ROWADJUSTVALUE);
		rep = rep + r;

		return rep;
	}

}
