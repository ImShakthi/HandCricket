package com.sakthi.handcricket.model;

import java.util.Map;

import com.sakthi.handcricket.enumeration.Players;
import com.sakthi.handcricket.enumeration.Runs;
import com.sakthi.handcricket.model.interfaces.Game;

public class HandCricket implements Game {

	private final static int NO_OF_BALLS = 6;
	private HandCricketPlayer firstBatsMen;
	private HandCricketPlayer secondBatsMen;
	private Innings currentInnings;

	public HandCricket() {
		this(Players.A, Players.B);
	}

	public HandCricket(final Players firstBatsMenArg, final Players secondBatsmenArg) {
		this.firstBatsMen = new HandCricketPlayer(firstBatsMenArg);
		this.secondBatsMen = new HandCricketPlayer(secondBatsmenArg);
		this.currentInnings = new Innings();
	}

	@Override
	public void startGame() {

		System.out.println("1st innings: " + this.firstBatsMen.getPlayer() + " is batting...");
		startInnings(this.firstBatsMen, this.secondBatsMen);
		this.currentInnings.setSecondInnings(true);
		this.currentInnings.setTarget(this.currentInnings.getPlayerScoreCardMap().get(this.firstBatsMen).getScore());
		System.out.println("Target is " + this.currentInnings.getTarget() + " runs.");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("2nd innings: " + this.secondBatsMen.getPlayer() + " is batting...");
		startInnings(this.secondBatsMen, this.firstBatsMen);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	private void startInnings(final HandCricketPlayer batsMen, final HandCricketPlayer oppBatsMen) {

		boolean out = false;

		ScoreCard scoreCard = new ScoreCard();
		for (int ball = 1; ball <= NO_OF_BALLS; ball++) {
			Runs batsmen_throw = batsMen.getRandRun();
			Runs opp_throw = oppBatsMen.getRandRun();

			scoreCard.updateScore(batsmen_throw);

			StringBuffer status = new StringBuffer();
			status.append(batsMen.getPlayer() + " throws " + batsmen_throw.getRun() + " . ");
			status.append(oppBatsMen.getPlayer() + " throws " + opp_throw.getRun() + " . ");

			if (batsmen_throw.equals(opp_throw)) {
				out = true;
				status.append(batsMen.getPlayer() + " is out.");
			} else {
				status.append(batsMen.getPlayer() + " scores " + scoreCard.getScore());
			}

			System.out.println(status.toString());
			if (out || (this.currentInnings.isSecondInnings()
					&& this.currentInnings.getTarget() < scoreCard.getScore())) {
				break;
			}
		}
		this.currentInnings.updateScoreCard(batsMen, scoreCard);
	}

	@Override
	public Players getWinner() {
		Map<HandCricketPlayer, ScoreCard> playerScoreCardMap = currentInnings.getPlayerScoreCardMap();
		// System.out.println(playerScoreCardMap);
		if (playerScoreCardMap.get(firstBatsMen).getScore() > playerScoreCardMap.get(secondBatsMen).getScore()) {
			return firstBatsMen.getPlayer();
		} else if (playerScoreCardMap.get(firstBatsMen).getScore() < playerScoreCardMap.get(secondBatsMen).getScore()) {
			return secondBatsMen.getPlayer();
		}
		return null;
	}

}
