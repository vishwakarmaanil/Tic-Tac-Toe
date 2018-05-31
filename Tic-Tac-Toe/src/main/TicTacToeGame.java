package main;

import java.util.Scanner;

public class TicTacToeGame
{
	static Scanner k = new Scanner(System.in);

	public static void main(String args[])
	{
		System.out.println(">>>>>>Welcome to Tic-Tac-Toe!<<<<<<");
		while (true)
		{
			System.out.println("Grid Map : Each Block represents [ROW_Number  Column_Number]");
			for (int i = 0; i < 3; i++)
			{
				for (int j = 0; j < 3; j++)
				{
					System.out.printf("[%d %d]", i, j);
				}
				System.out.println();
			}
			Play p = new Play();
			p.play();
		}
	}

}
