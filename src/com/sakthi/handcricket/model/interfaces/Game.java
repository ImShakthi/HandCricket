package com.sakthi.handcricket.model.interfaces;

import com.sakthi.handcricket.enumeration.Players;

public interface Game {

	String WINNER_IS = "Winner is ";
	String GAME_IS_TIE = "Game is a tie.";

	void startGame();

	Players getWinner();

	default String getWinnerStatus() {
		Players winner = getWinner();
		if (winner != null) {
			return WINNER_IS + winner.getName();
		}
		return GAME_IS_TIE;
	}
}
