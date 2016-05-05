package edu.cis232.SemesterProject;

public class NegativeQuantityException extends IllegalArgumentException {

	/**
	 * thrown when the quantity of an item is below 1
	 */
	private static final long serialVersionUID = 1L;

	public NegativeQuantityException(int q){
		super(String.format("%d is out of the range of valid quantity (1-infinity)",q));
	}
}
