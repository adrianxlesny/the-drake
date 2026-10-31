package com.adrianxlesny.thedrake;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Offset2DTest {
	@Test
	public void test() {
		Offset2D offset2D = new Offset2D(10, -5);

		assertEquals(10, offset2D.x());
		assertEquals(-5, offset2D.y());

		assertTrue(offset2D.equalsTo(10, -5));
		assertFalse(offset2D.equalsTo(9, -5));
		assertFalse(offset2D.equalsTo(10, -4));
		assertFalse(offset2D.equalsTo(0, 1));

		assertTrue(offset2D.yFlipped().equalsTo(10, 5));
		assertTrue(offset2D.yFlipped().yFlipped().equalsTo(10, -5));
		assertNotEquals(offset2D.yFlipped(), offset2D);
	}
}