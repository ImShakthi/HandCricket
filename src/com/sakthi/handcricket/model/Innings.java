package com.sakthi.handcricket.model;

import java.util.HashMap;
import java.util.Map;

public class Innings {

	private int target;
	private boolean secondInnings;
	@Override
	public String toString() {
		return "Innings [target=" + target + ", secondInnings=" + secondInnings + ", playerScoreCardMap="
				+ playerScoreCardMap + "]";
	}

	private Map<HandCricketPlayer, ScoreCard> playerScoreCardMap;

	public Innings() {
		this.playerScoreCardMap = new HashMap<>();
	}

	public void updateScoreCard(final HandCricketPlayer player, final ScoreCard scoreCard) {
		this.playerScoreCardMap.put(player, scoreCard);
	}

	public Map<HandCricketPlayer, ScoreCard> getPlayerScoreCardMap() {
		return playerScoreCardMap;
	}

	public void setPlayerScoreCardMap(Map<HandCricketPlayer, ScoreCard> playerScoreCardMap) {
		this.playerScoreCardMap = playerScoreCardMap;
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	public boolean isSecondInnings() {
		return secondInnings;
	}

	public void setSecondInnings(boolean secondInnings) {
		this.secondInnings = secondInnings;
	}

	
}
