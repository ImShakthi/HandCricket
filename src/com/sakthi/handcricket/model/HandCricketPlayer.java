package com.sakthi.handcricket.model;

import com.sakthi.handcricket.enumeration.Players;
import com.sakthi.handcricket.enumeration.Runs;
import com.sakthi.handcricket.model.interfaces.Player;

public class HandCricketPlayer implements Player {

	private Players player;
	private boolean out;

	public HandCricketPlayer(final Players playerArg) {
		this.player = playerArg;
	}

	@Override
	public Players getPlayer() {
		return this.player;
	}

	public Runs getRandRun() {
		int index = ((int) (Math.random() * 100)) % Runs.getRuns().length;
		return Runs.getRuns()[index];
	}

	public void setName(Players name) {
		this.player = name;
	}

	public boolean isOut() {
		return out;
	}

	public void setOut(boolean out) {
		this.out = out;
	}

	public void setPlayer(Players player) {
		this.player = player;
	}

	@Override
	public String toString() {
		return "HandCricketPlayer [player=" + player + ", out=" + out + "]";
	}


}
