package com.adrianxlesny.thedrake;

/**
 * Reprezentuje posun na hracej doske.
 * @param x posun po horizontálnej osi
 * @param y posun po vertikálnej osi
 */
public record Offset2D(int x, int y) {
	/**
	 * Zistí, či sa tento offset zhoduje so zadanými súradnicami.
	 * @param x horizontálna zložka na porovnanie
	 * @param y vertikálna zložka na porovnanie
	 * @return {@code true}, ak sa obe zložky zhodujú
	 */
	public boolean equalsTo(int x, int y) {
		return this.x == x && this.y == y;
	}

	/**
	 * Vytvorí nový offset so zrkadlovo otočenou vertikálnou zložkou.
	 * @return nový offset {@code (x, -y)}
	 */
	public Offset2D yFlipped() {
		return new Offset2D(x, -y);
	}
}