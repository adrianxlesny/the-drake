package com.adrianxlesny.thedrake;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TroopTest {
	@Test
	public void test() {
		Troop archer = new Troop("Archer", new Offset2D(1, 1), new Offset2D(0, 1));
		assertEquals("Archer", archer.getName());
		assertTrue(archer.getPivot(TroopFace.FRONT).equalsTo(1, 1));
		assertTrue(archer.getPivot(TroopFace.BACK).equalsTo(0, 1));

		Troop monk = new Troop("Monk", new Offset2D(1, 1));
		assertEquals("Monk", monk.getName());
		assertTrue(monk.getPivot(TroopFace.FRONT).equalsTo(1, 1));
		assertTrue(monk.getPivot(TroopFace.BACK).equalsTo(1, 1));

		Troop drake = new Troop("Drake");
		assertEquals("Drake", drake.getName());
		assertTrue(drake.getPivot(TroopFace.FRONT).equalsTo(1, 1));
		assertTrue(drake.getPivot(TroopFace.BACK).equalsTo(1, 1));
	}
}