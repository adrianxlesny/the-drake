package com.adrianxlesny.thedrake;

import java.util.Arrays;

/**
 * Hracia doska bez jednotiek.
 */
public class Board {
	private final int dimension;
	private final BoardTile[][] tiles;

	/**
	 * Vytvorí dosku, na ktorej sú všetky políčka prázdne.
	 * @param dimension rozmer hracej dosky
	 */
	public Board(int dimension) {
		this.dimension = dimension;
		tiles = new BoardTile[dimension][dimension];

		for (BoardTile[] column : tiles) {
			Arrays.fill(column, BoardTile.EMPTY);
		}
	}

	/**
	 * Vytvorí kópiu zadanej dosky.
	 * @param other hracia doska, z ktorej sa vytvorí kópia
	 */
	private Board(Board other) {
		dimension = other.dimension;
		tiles = new BoardTile[dimension][dimension];

		for (int i = 0; i < tiles.length; i++) {
			tiles[i] = other.tiles[i].clone();
		}
	}

	/**
	 * Vráti rozmer hracej dosky.
	 * @return rozmer hracej dosky
	 */
	public int getDimension() {
		return dimension;
	}

	/**
	 * Vráti políčko na zadanej pozícii.
	 * @param position pozícia políčka
	 * @return políčko na zadanej pozícii
	 */
	public BoardTile tileAt(TilePos position) {
		return tiles[position.i()][position.j()];
	}

	/**
	 * Vytvorí novú dosku, na ktorej sú zadané políčka nahradené.
	 * @param placements políčka a pozície, na ktoré sa majú umiestniť
	 * @return nová doska so zmenenými políčkami
	 */
	public Board withTiles(TilePlacement... placements) {
		Board newBoard = new Board(this);

		for (TilePlacement placement : placements) {
			newBoard.tiles[placement.pos().i()][placement.pos().j()] = placement.tile();
		}

		return newBoard;
	}

	/**
	 * Vytvorí továreň na pozície pre túto dosku.
	 * @return továreň na pozície s rozmerom tejto dosky
	 */
	public PositionFactory positionFactory() {
		return new PositionFactory(dimension);
	}

	/**
	 * Políčko spolu s pozíciou, na ktorú sa má umiestniť.
	 * @param pos pozícia na hracej doske
	 * @param tile políčko, ktoré sa na pozíciu umiestni
	 */
	public record TilePlacement(BoardPos pos, BoardTile tile) {}
}