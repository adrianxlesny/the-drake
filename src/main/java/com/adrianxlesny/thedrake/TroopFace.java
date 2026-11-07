package com.adrianxlesny.thedrake;

/**
 * Strana jednotky, ktorou je jednotka práve otočená nahor.
 */
public enum TroopFace {
	FRONT, BACK;

	/**
	 * Vráti opačnú stranu jednotky.
	 * @return {@code BACK} pre {@code FRONT} a naopak
	 */
	public TroopFace flipped() {
		return this == FRONT ? BACK : FRONT;
	}
}