package com.adrianxlesny.thedrake;

/**
 * Jedno políčko hracej dosky.
 */
public interface Tile {
	/**
	 * Zistí, či môže jednotka vstúpiť na toto políčko.
	 * @return {@code true}, ak sa na políčko dá vstúpiť
	 */
	boolean canStepOn();

	/**
	 * Zistí, či na políčku stojí jednotka.
	 * @return {@code true}, ak je na políčku jednotka
	 */
	boolean hasTroop();
}