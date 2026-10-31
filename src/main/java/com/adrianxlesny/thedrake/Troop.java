package com.adrianxlesny.thedrake;

/**
 * Predstavuje bojovú jednotku.
 * Každá strana jednotky (predná a zadná) môže mať vlastný pivot.
 */
public class Troop {
	private final String name;
	private final Offset2D frontPivot, backPivot;

	/**
	 * Vytvorí jednotku s rôznym pivotom pre prednú a zadnú stranu.
	 * @param name názov jednotky
	 * @param frontPivot pivot prednej strany
	 * @param backPivot pivot zadnej strany
	 */
	public Troop(String name, Offset2D frontPivot, Offset2D backPivot) {
		this.name = name;
		this.frontPivot = frontPivot;
		this.backPivot = backPivot;
	}

	/**
	 * Vytvorí jednotku s rovnakým pivotom na oboch stranách (prednej aj zadnej).
	 * @param name názov jednotky
	 * @param pivot pivot jednotky
	 */
	public Troop(String name, Offset2D pivot) {
		this(name, pivot, pivot);
	}

	/**
	 * Vytvorí jednotku s predvoleným pivotom {@code (1, 1)} pre obe strany (prednú aj zadnú).
	 * @param name názov jednotky
	 */
	public Troop(String name) {
		this(name, new Offset2D(1, 1));
	}

	/**
	 * Vráti názov jednotky.
	 * @return názov jednotky
	 */
	public String getName() {
		return name;
	}

	/**
	 * Vráti pivot pre zadanú stranu jednotky.
	 * @param face strana, ktorou je jednotka otočená nahor
	 * @return pivot zadanej strany
	 */
	public Offset2D getPivot(TroopFace face) {
		return face == TroopFace.FRONT ? frontPivot : backPivot;
	}
}