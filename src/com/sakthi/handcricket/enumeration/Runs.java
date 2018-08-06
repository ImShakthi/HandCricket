package com.sakthi.handcricket.enumeration;

public enum Runs {
	ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4), SIX(6);

	private int run;
	
	Runs(final int run){
		this.run = run;
	}

	public int getRun() {
		return run;
	}

	public void setRun(int run) {
		this.run = run;
	}

	public static Runs[] getRuns() {
		return Runs.values();
	}

	
}
