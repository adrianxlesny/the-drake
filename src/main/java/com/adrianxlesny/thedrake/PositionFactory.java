package com.adrianxlesny.thedrake;

/**
 * Vytvára pozície na hracej doske zadanej veľkosti.
 * @param dimension rozmer hracej dosky
 */
public record PositionFactory(int dimension) {
	public PositionFactory {
		if (dimension < 0) {
			throw new IllegalArgumentException("Dimension cannot be negative.");
		}
	}

	/**
	 * Prevedie písmeno stĺpca na jeho index.
	 * @param column písmeno stĺpca, napríklad {@code 'a'}
	 * @return index stĺpca počítaný od {@code 0}
	 */
	private int columnIndex(char column) {
		return column - 'a';
	}

	/**
	 * Prevedie číslo riadku na jeho index.
	 * @param row číslo riadku počítané od {@code 1}
	 * @return index riadku počítaný od {@code 0}
	 */
	private int rowIndex(int row) {
		return row - 1;
	}

	/**
	 * Vytvorí pozíciu podľa indexov stĺpca a riadku.
	 * @param i index stĺpca počítaný od {@code 0}
	 * @param j index riadku počítaný od {@code 0}
	 * @return pozícia na hracej doske
	 */
	public BoardPos position(int i, int j) {
		return new BoardPos(dimension, i, j);
	}

	/**
	 * Vytvorí pozíciu podľa označenia stĺpca a čísla riadku.
	 * @param column písmeno stĺpca, napríklad {@code 'a'}
	 * @param row číslo riadku počítané od {@code 1}
	 * @return pozícia na hracej doske
	 */
	public BoardPos position(char column, int row) {
		return position(columnIndex(column), rowIndex(row));
	}

	/**
	 * Vytvorí pozíciu z textového zápisu, napríklad {@code "a1"} alebo {@code "c10"}.
	 * @param coordinates písmeno stĺpca, za ktorým nasleduje číslo riadku
	 * @return pozícia na hracej doske
	 */
	public BoardPos position(String coordinates) {
		return position(coordinates.charAt(0), Integer.parseInt(coordinates.substring(1)));
	}
}