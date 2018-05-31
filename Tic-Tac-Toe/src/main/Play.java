package main;

import java.util.Scanner;

public class Play
{
	static Scanner k = new Scanner(System.in);

	// Play the game
	public static void play()
	{
		char[][] grid = new char[3][3];
		char turn = 0;
		while (true)
		{
			turn = playersTurn(turn);
			int[] positions = new int[2];
			while (true)
			{
				setPositionsOnGrid(positions);

				if (markedOnGrid(turn, positions, grid))
				{
					break;
				}
			}
			if (gameStatus(turn, grid))
			{
				displayCurrentGrid(grid);
			} else
			{
				displayCurrentGrid(grid);
				System.out.println("Player " + turn + " Wins!!!\n");
				System.out.println("Lets Play another Game !! ");
				break;
			}
		}
	}

	// Display the current game board with the markings
	private static void displayCurrentGrid(char[][] grid)
	{
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				System.out.printf("[ %s ]", grid[i][j]);
			}
			System.out.println();
		}

	}

	// return false when the game is over.
	private static boolean gameStatus(char turn, char[][] grid)
	{
		if (horizontalWin(turn, grid))
			return false;
		if (verticalWin(turn, grid))
			return false;
		if (leftDiagonal(turn, grid))
			return false;
		if (rightDiagonal(turn, grid))
			return false;
		if (draw(grid))
			return false;
		return true;
	}

	// Return true if the position is already marked else return false
	private static boolean markedOnGrid(char turn, int[] positions, char[][] grid)
	{
		if (grid[positions[0]][positions[1]] == 0)
		{
			grid[positions[0]][positions[1]] = turn;
		}
		else
		{
			System.out.println("Position is already Marked, Please try diffrent location");
			return false;
		}
		return true;
	}

	// Allows user to input the location of the block to be marked
	private static void setPositionsOnGrid(int[] positions)
	{
		System.out.print("Enter the positions..." + "\nRow number: ");
		positions[0] = k.nextInt();
		System.out.print("Column number: ");
		positions[1] = k.nextInt();
	}

	// Switch between players
	public static char playersTurn(char turn)
	{
		if (turn == 'X')
		{
			System.out.println("Player O's Turn");
			turn = 'O';
		} else if (turn == 'O')
		{
			System.out.println("Player X's Turn");
			turn = 'X';
		} else
		{
			while (turn != 'X' && turn != 'O')
			{
				System.out.print("Enter X or O : ");
				turn = k.next().charAt(0);
				turn = Character.toUpperCase(turn);
			}
		}
		return turn;
	}

	// If board becomes full before anyone wins then it is draw.
	private static boolean draw(char[][] grid)
	{
		loop: for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (grid[j][i] == 0)

				{
					break loop;
				} else if (i == 2 && j == 2 && grid[i][j] == 0)
				{
					System.out.println("Its a Draw.  Game Over!!\n");
					System.out.println("Lets Play Another Game !! ");
				}

			}
		}
		return false;
	}

	// returns true if left Diagonal Matches
	private static boolean leftDiagonal(char turn, char[][] grid)
	{
		int matchCount = 0;
		for (int i = 0; i < 3; i++)
		{
			if (grid[i][i] == turn)
				matchCount++;

			if (matchCount == 3)
				return true;
		}
		return false;
	}

	// returns true if right Diagonal Matches
	private static boolean rightDiagonal(char turn, char[][] grid)
	{
		int matchCount = 0;
		for (int i = 2; i >= 0; i--)
		{
			if (grid[(5 - i) % 3][i] == turn)
				matchCount++;

			if (matchCount == 3)
				return true;
		}
		return false;
	}

	// Return true if all the 3 marked positions are horizontally aligned
	private static boolean horizontalWin(char turn, char[][] grid)
	{
		int matchCount = 0;
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (grid[i][j] == turn)
				{
					matchCount++;
				}
				if (matchCount == 3)
				{
					System.out.println("Its a Horizontal win !!");
					return true;
				}
			}
			matchCount = 0;
		}
		return false;
	}

	// Return true if all the 3 marked positions are horizontally aligned
	private static boolean verticalWin(char turn, char[][] grid)
	{
		int matchCount = 0;
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (grid[j][i] == turn)
				{
					matchCount++;
				}
				if (matchCount == 3)
				{
					System.out.println("Its a Horizontal win !!");
					return true;
				}
			}
			matchCount = 0;
		}
		return false;
	}

}
