package edu.wofford;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleMain {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		TicTacToeModel game = new TicTacToeModel();
		int row = -1;
		int col = -1;
		String input = "";
		String[] splitInput = new String[3];

		while (!game.isOver()) {
			System.out.println(game.toString());
			input = keyboard.nextLine();
			
			if (input.length() == 3 && input.charAt(1) == ' ') {
				splitInput = input.split(" ");
				try {
					row = Integer.parseInt(splitInput[0]);
					col = Integer.parseInt(splitInput[1]);
				} catch (Exception e) {
					row = -1;
					col = -1;
				}
			}

			game.markBoard(row, col);
			
		}

		System.out.println(game.toString());
		if (game.hasWinner()) {
			System.out.println(game.getPlayerTurn() + " wins");
		} else {
			System.out.println("Tie");
		}

	}
}