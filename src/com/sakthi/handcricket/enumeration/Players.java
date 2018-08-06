package com.sakthi.handcricket.enumeration;

public enum Players {

	A("A"), B("B");

	private String name;

	Players(final String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static Players contains(final String name) {
		Players[] players = Players.values();
		for (int index = 0; index < players.length; index++) {
			if (players[index].getName().equalsIgnoreCase(name)) {
				return players[index];
			}
		}
		return null;
	}

	public static Players getOpponent(final Players player) {
		Players[] players = Players.values();
		for (int index = 0; index < players.length; index++) {
			if (!players[index].equals(player)) {
				return players[index];
			}
		}
		return null;
	}

		
}
