package pro_180_quintanilla_christopher.chess;

import java.io.*;

public class FileIO
{
	public FileIO()
	{
		File file = new File("src/ChessMoves.txt");
		FileInputStream fiStream = null;
		try
		{
			fiStream = new FileInputStream(file);
		} catch (FileNotFoundException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}