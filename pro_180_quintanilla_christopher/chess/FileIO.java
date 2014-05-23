package pro_180_quintanilla_christopher.chess;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class FileIO
{
	static final Pattern PLACING_PIECE_PATTERN = Pattern.compile("([K,Q,R,B,N,P][l,d][a-h][1-8])");
	static final Pattern MOVING_PIECE_PATTERN = Pattern.compile("([K,Q,R,B,N,P][a-h][1-8]\\s[K,Q,R,B,N,P][a-h][1-8])");
	static final Pattern CAPTURING_PIECE_PATTERN = Pattern.compile("([K,Q,R,B,N,P][a-h][1-8]\\s[K,Q,R,B,N,P][a-h][1-8][*])");
	static final Pattern MOVING_TWO_PIECES_PATTERN = Pattern.compile("([K,Q,R,B,N,P][a-h][1-8]\\s[K,Q,R,B,N,P][a-h][1-8] [K,Q,R,B,N,P][a-h][1-8]\\s[K,Q,R,B,N,P][a-h][1-8])");
	static Map<String, String> map;
	static
	{
		map = new HashMap<>();
		map.put("K", "King");
		map.put("Q", "Queen");
		map.put("R", "Rook");
		map.put("B", "Bishop");
		map.put("N", "Knight");
		map.put("P", "Pawn");
	}

	ArrayList<String> parts;

	public ArrayList<String> convertFileToArrayList(String pathname)
	{
		File file = new File(pathname);
		parts = new ArrayList<String>();
		try
		{
			FileInputStream fiStream = new FileInputStream(file);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while (reader.ready())
			{
				parts.add(reader.readLine());
			}
		} catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return parts;
	}

	public void displayMoves(ArrayList<String> parts)
	{
		Matcher m = null;
		String piece = "";
		String location = "";
		for (String s : parts)
		{
			if ((m = PLACING_PIECE_PATTERN.matcher(s)).find())
			{
				String move = m.group(1);
				String side = "";
				piece = map.get(move.substring(0, 1));
				if (move.substring(1, 2).equals("l"))
				{
					side = "Light";
				} else
				{
					side = "Dark";
				}
				location = move.substring(2).toUpperCase();
				System.out.println(side + " " + piece + " is placed on " + location + ".");

			} else if ((m = MOVING_PIECE_PATTERN.matcher(s)).find())
			{
				String move = m.group(1);
				piece = map.get(move.substring(0, 1));
				location = move.substring(1, 3).toUpperCase();
				String finalLoc = move.substring(5).toUpperCase();
				// System.out.println(move);
				System.out.println(piece + " on tile " + location + " is moved to tile " + finalLoc + ".");

			} else if ((m = CAPTURING_PIECE_PATTERN.matcher(s)).find())
			{
				String move = m.group(1);
				piece = map.get(move.substring(0, 1));
				location = move.substring(1, 3).toUpperCase();
				String finalLoc = move.substring(5, 7).toUpperCase();
				// System.out.println(move);
				System.out.println(piece + " on tile " + location + " is moved to tile " + finalLoc + " and has captured the piece on " + finalLoc + ".");
			} else if ((m = MOVING_TWO_PIECES_PATTERN.matcher(s)).find())
			{
				String move = m.group(1);
				piece = map.get(move.substring(0, 1));
				location = move.substring(1, 3).toUpperCase();
				String finalLoc1 = move.substring(5, 7).toUpperCase();
				String piece2 = map.get(move.substring(8, 9));
				String location2 = move.substring(9, 11).toUpperCase();
				String finalLoc2 = move.substring(13, 15).toUpperCase();
				// System.out.println(move);
				System.out.println(piece + " on tile " + location.toUpperCase() + " is moved to tile " + finalLoc1 + " and " + piece2 + " on tile " + location2 + " is moved to tile " + finalLoc2
						+ ".");

			}

		}
	}

	public static void main(String[] args)
	{
		FileIO f = new FileIO();
		ArrayList<String> moves = f.convertFileToArrayList("src/Chessmoves.txt");
		f.displayMoves(moves);
	}
}