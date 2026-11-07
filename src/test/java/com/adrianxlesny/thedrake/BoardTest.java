package com.adrianxlesny.thedrake;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
	@Test
	public void test() {
		Board emptyBoard = new Board(3);
		assertEquals(3, emptyBoard.getDimension());

		PositionFactory pf = emptyBoard.positionFactory();

		assertSame(BoardTile.EMPTY, emptyBoard.tileAt(pf.position("a1")));
		assertSame(BoardTile.EMPTY, emptyBoard.tileAt(pf.position("b1")));
		assertSame(BoardTile.EMPTY, emptyBoard.tileAt(pf.position("c1")));
		assertSame(BoardTile.EMPTY, emptyBoard.tileAt(pf.position("a2")));
		assertSame(BoardTile.EMPTY, emptyBoard.tileAt(pf.position("b2")));
		assertSame(BoardTile.EMPTY, emptyBoard.tileAt(pf.position("c2")));
		assertSame(BoardTile.EMPTY, emptyBoard.tileAt(pf.position("a3")));
		assertSame(BoardTile.EMPTY, emptyBoard.tileAt(pf.position("b3")));
		assertSame(BoardTile.EMPTY, emptyBoard.tileAt(pf.position("c3")));

		Board board = emptyBoard.withTiles(
				new Board.TilePlacement(pf.position(0, 0), BoardTile.MOUNTAIN),
				new Board.TilePlacement(pf.position(1, 2), BoardTile.MOUNTAIN),
				new Board.TilePlacement(pf.position(2, 1), BoardTile.MOUNTAIN)
		);
		assertEquals(3, board.getDimension());

		pf = board.positionFactory();
		assertSame(BoardTile.MOUNTAIN, board.tileAt(pf.position("a1")));
		assertSame(BoardTile.EMPTY, board.tileAt(pf.position("b1")));
		assertSame(BoardTile.EMPTY, board.tileAt(pf.position("c1")));
		assertSame(BoardTile.EMPTY, board.tileAt(pf.position("a2")));
		assertSame(BoardTile.EMPTY, board.tileAt(pf.position("b2")));
		assertSame(BoardTile.MOUNTAIN, board.tileAt(pf.position("c2")));
		assertSame(BoardTile.EMPTY, board.tileAt(pf.position("a3")));
		assertSame(BoardTile.MOUNTAIN, board.tileAt(pf.position("b3")));
		assertSame(BoardTile.EMPTY, board.tileAt(pf.position("c3")));

		Board board2 = board.withTiles(
				new Board.TilePlacement(pf.position(0, 1), BoardTile.MOUNTAIN),
				new Board.TilePlacement(pf.position(0, 2), BoardTile.MOUNTAIN),
				new Board.TilePlacement(pf.position(2, 1), BoardTile.EMPTY)
		);

		assertEquals(3, board2.getDimension());

		pf = board2.positionFactory();
		assertSame(BoardTile.MOUNTAIN, board2.tileAt(pf.position("a1")));
		assertSame(BoardTile.EMPTY, board2.tileAt(pf.position("b1")));
		assertSame(BoardTile.EMPTY, board2.tileAt(pf.position("c1")));
		assertSame(BoardTile.MOUNTAIN, board2.tileAt(pf.position("a2")));
		assertSame(BoardTile.EMPTY, board2.tileAt(pf.position("b2")));
		assertSame(BoardTile.EMPTY, board2.tileAt(pf.position("c2")));
		assertSame(BoardTile.MOUNTAIN, board2.tileAt(pf.position("a3")));
		assertSame(BoardTile.MOUNTAIN, board2.tileAt(pf.position("b3")));
		assertSame(BoardTile.EMPTY, board2.tileAt(pf.position("c3")));

		assertSame(BoardTile.EMPTY, emptyBoard.tileAt(pf.position("a1")));
		assertSame(BoardTile.EMPTY, emptyBoard.tileAt(pf.position("b1")));
		assertSame(BoardTile.EMPTY, emptyBoard.tileAt(pf.position("c1")));
		assertSame(BoardTile.EMPTY, emptyBoard.tileAt(pf.position("a2")));
		assertSame(BoardTile.EMPTY, emptyBoard.tileAt(pf.position("b2")));
		assertSame(BoardTile.EMPTY, emptyBoard.tileAt(pf.position("c2")));
		assertSame(BoardTile.EMPTY, emptyBoard.tileAt(pf.position("a3")));
		assertSame(BoardTile.EMPTY, emptyBoard.tileAt(pf.position("b3")));
		assertSame(BoardTile.EMPTY, emptyBoard.tileAt(pf.position("c3")));
	}
}