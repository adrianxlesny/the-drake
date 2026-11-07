package com.adrianxlesny.thedrake;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Pozícia políčka na štvorcovej hracej doske.
 */
public class BoardPos implements TilePos {
	private static final int[][] DIRECTIONS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
	private final int dimension, i, j;

	/**
	 * Vytvorí pozíciu na doske zadanej veľkosti.
	 * @param dimension počet stĺpcov a riadkov dosky
	 * @param i index stĺpca počítaný od {@code 0}
	 * @param j index riadku počítaný od {@code 0}
	 */
	public BoardPos(int dimension, int i, int j) {
		this.dimension = dimension;
		this.i = i;
		this.j = j;
	}

	@Override
	public int i() {
		return i;
	}

	@Override
	public int j() {
		return j;
	}

	@Override
	public char column() {
		return (char) ('a' + i);
	}

	@Override
	public int row() {
		return j + 1;
	}

	@Override
	public TilePos step(int columnStep, int rowStep) {
		int newI = i + columnStep;
		int newJ = j + rowStep;

		if (newI >= 0 && newI < dimension && newJ >= 0 && newJ < dimension) {
			return new BoardPos(dimension, newI, newJ);
		}

		return TilePos.OFF_BOARD;
	}

	@Override
	public TilePos step(Offset2D offset) {
		return step(offset.x(), offset.y());
	}

	@Override
	public List<BoardPos> neighbours() {
		List<BoardPos> neighbours = new ArrayList<>();

		for (int[] direction : DIRECTIONS) {
			TilePos position = step(direction[0], direction[1]);

			if (position != TilePos.OFF_BOARD) {
				neighbours.add((BoardPos) position);
			}
		}

		return neighbours;
	}

	@Override
	public boolean isNextTo(TilePos position) {
		if (position == TilePos.OFF_BOARD) {
			return false;
		}

		return Math.abs(i - position.i()) + Math.abs(j - position.j()) == 1;
	}

	@Override
	public TilePos stepByPlayingSide(Offset2D offset, PlayingSide side) {
		return side == PlayingSide.BLUE ? step(offset) : step(offset.yFlipped());
	}

	@Override
	public boolean equalsTo(int i, int j) {
		return this.i == i && this.j == j;
	}

	@Override
	public int hashCode() {
		return Objects.hash(i, j);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		BoardPos other = (BoardPos) obj;
		return i == other.i && j == other.j;
	}
}