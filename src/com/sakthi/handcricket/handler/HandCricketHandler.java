package com.sakthi.handcricket.handler;

import java.util.Scanner;

import com.sakthi.handcricket.enumeration.Players;
import com.sakthi.handcricket.model.HandCricket;

public class HandCricketHandler {

	public static void main(String[] args) {
		System.out.println("~Hand Cricket~");
		HandCricketHandler handler = new HandCricketHandler();
		handler.init();
	}

	public void init() {
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			System.out.println("Enter a player name = ");
			String player_name = scanner.nextLine();

			Players batsMen = Players.contains(player_name);
			Players oppBatsMen = Players.getOpponent(batsMen);

			// System.out.println("batsMen " + batsMen + " opp=" + oppBatsMen);

			HandCricket handCricket = new HandCricket(batsMen, oppBatsMen);
			handCricket.startGame();

			System.out.println(handCricket.getWinnerStatus());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

}
