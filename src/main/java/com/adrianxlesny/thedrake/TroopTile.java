package com.adrianxlesny.thedrake;

/**
 * Políčko, na ktorom stojí jednotka.
 * @param troop jednotka stojaca na políčku
 * @param side strana hráča, ktorému jednotka patrí
 * @param face strana, ktorou je jednotka otočená nahor
 */
public record TroopTile(Troop troop, PlayingSide side, TroopFace face) implements Tile {
	@Override
	public boolean canStepOn() {
		return false;
	}

	@Override
	public boolean hasTroop() {
		return true;
	}

	/**
	 * Vytvorí nové políčko s tou istou jednotkou otočenou na druhú stranu.
	 * @return nové políčko s opačnou stranou jednotky
	 */
	public TroopTile flipped() {
		return new TroopTile(troop, side, face.flipped());
	}
}