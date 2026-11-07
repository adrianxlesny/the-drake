package com.adrianxlesny.thedrake;

/**
 * Políčko hracej dosky, na ktorom nestojí žiadna jednotka.
 */
public enum BoardTile implements Tile {
	EMPTY(true), MOUNTAIN(false);

	private final boolean canStepOn;

	/**
	 * Vytvorí typ políčka.
	 * @param canStepOn či môže jednotka na políčko vstúpiť
	 */
	BoardTile(boolean canStepOn) {
		this.canStepOn = canStepOn;
	}

	@Override
	public boolean canStepOn() {
		return canStepOn;
	}

	@Override
	public boolean hasTroop() {
		return false;
	}
}