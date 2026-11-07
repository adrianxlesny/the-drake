package com.adrianxlesny.thedrake;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TroopTileTest {
	@Test
	public void test() {
		Troop monk = new Troop("Monk", new Offset2D(1, 1));
		TroopTile tile = new TroopTile(monk, PlayingSide.BLUE, TroopFace.FRONT);

		assertFalse(tile.canStepOn());
		assertTrue(tile.hasTroop());
		assertSame(monk, tile.troop());
		assertSame(PlayingSide.BLUE, tile.side());
		assertSame(TroopFace.FRONT, tile.face());
		assertSame(TroopFace.BACK, tile.flipped().face());
		assertNotEquals(tile.flipped(), tile);

		Troop drake = new Troop("Drake");
		tile = new TroopTile(drake, PlayingSide.ORANGE, TroopFace.BACK);

		assertFalse(tile.canStepOn());
		assertTrue(tile.hasTroop());
		assertSame(drake, tile.troop());
		assertSame(PlayingSide.ORANGE, tile.side());
		assertSame(TroopFace.BACK, tile.face());
		assertSame(TroopFace.FRONT, tile.flipped().face());
	}
}