package com.sakthi.handcricket.model;

import java.util.ArrayList;
import java.util.List;

import com.sakthi.handcricket.enumeration.Runs;

public class ScoreCard {

	private short score;
	private List<Short> throwsList;

	public ScoreCard() {
		this.score = 0;
		this.throwsList = new ArrayList<>();
	}

	public void updateScore(final Runs run) {
		this.score += run.getRun();
		this.throwsList.add((short) run.getRun());
	}

	public short getBalls() {
		return (short) this.throwsList.size();
	}

	public short getScore() {
		return score;
	}

	public void setScore(short score) {
		this.score = score;
	}

	public List<Short> getThrowsList() {
		return throwsList;
	}

	public void setThrowsList(List<Short> throwsList) {
		this.throwsList = throwsList;
	}

	@Override
	public String toString() {
		return "ScoreCard [score=" + score + ", throwsList=" + throwsList + "]";
	}

}
