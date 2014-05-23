package pro_180_quintanilla_christopher.chess;

public final class Position
{
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

}
