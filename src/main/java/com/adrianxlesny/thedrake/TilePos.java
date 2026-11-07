package com.adrianxlesny.thedrake;

import java.util.List;

/**
 * Pozícia políčka.
 * Stĺpce sa označujú písmenami a riadky číslami ({@code a1}).
 */
public interface TilePos {
	TilePos OFF_BOARD = new TilePos() {
		@Override
		public int i() {
			throw new UnsupportedOperationException();
		}

		@Override
		public int j() {
			throw new UnsupportedOperationException();
		}

		@Override
		public char column() {
			throw new UnsupportedOperationException();
		}

		@Override
		public int row() {
			throw new UnsupportedOperationException();
		}

		@Override
		public TilePos step(int columnStep, int rowStep) {
			throw new UnsupportedOperationException();
		}

		@Override
		public TilePos step(Offset2D offset) {
			throw new UnsupportedOperationException();
		}

		@Override
		public List<TilePos> neighbours() {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean isNextTo(TilePos position) {
			throw new UnsupportedOperationException();
		}

		@Override
		public TilePos stepByPlayingSide(Offset2D offset, PlayingSide side) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean equalsTo(int i, int j) {
			return false;
		}
	};

	/**
	 * Vráti index stĺpca.
	 * @return index stĺpca počítaný od {@code 0}
	 */
	int i();

	/**
	 * Vráti index riadku.
	 * @return index riadku počítaný od {@code 0}
	 */
	int j();

	/**
	 * Vráti označenie stĺpca.
	 * @return písmeno stĺpca, napríklad {@code 'a'}
	 */
	char column();

	/**
	 * Vráti číslo riadku.
	 * @return číslo riadku počítané od {@code 1}
	 */
	int row();

	/**
	 * Vráti pozíciu posunutú o zadaný počet stĺpcov a riadkov.
	 * @param columnStep posun po stĺpcoch
	 * @param rowStep posun po riadkoch
	 * @return nová pozícia po posune
	 */
	TilePos step(int columnStep, int rowStep);

	/**
	 * Vráti pozíciu posunutú o zadaný posun.
	 * @param offset posun, o ktorý sa má pozícia zmeniť
	 * @return nová pozícia po posune
	 */
	TilePos step(Offset2D offset);

	/**
	 * Vráti susedné pozície vľavo, vpravo, hore a dole.
	 * @return zoznam susedných pozícií
	 */
	List<? extends TilePos> neighbours();

	/**
	 * Zistí, či je zadaná pozícia susedná s touto pozíciou.
	 * @param position pozícia, ktorá sa porovnáva
	 * @return {@code true}, ak sú pozície susedné
	 */
	boolean isNextTo(TilePos position);

	/**
	 * Vráti pozíciu posunutú o zadaný posun z pohľadu daného hráča.
	 * Pre jedného z hráčov sa zložka y posunu otočí, takže "dopredu" znamená pre oboch hráčov smer k súperovi.
	 * @param offset posun z pohľadu hráča
	 * @param side strana hráča, z ktorej pohľadu sa posúva
	 * @return nová pozícia po posune
	 */
	TilePos stepByPlayingSide(Offset2D offset, PlayingSide side);

	/**
	 * Zistí, či má táto pozícia zadané indexy.
	 * @param i index stĺpca
	 * @param j index riadku
	 * @return {@code true}, ak sa indexy zhodujú
	 */
	boolean equalsTo(int i, int j);
}