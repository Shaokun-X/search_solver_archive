package fr.emse.ai.search.river;

public class CrossRiverState {
	private int leftMissionaries;
	private int leftCannibals;
	private int rightMissionaries;
	private int rightCannibals;
	private int boatMissionaries;
	private int boatCannibals;
	private char boatPosition;
	
	public CrossRiverState() {
		this.setLeftBankCannibals(3);
		this.setLeftBankMissionaries(3);
		this.setRightBankCannibals(0);
		this.setRightBankMissionaries(0);
		this.setBoatCannibals(0);
		this.setBoatMissionaries(0);
		this.setBoatPosition('L');
	}
	
	public CrossRiverState(int leftCann, int leftMiss, int rightCann, int rightMiss, int boatCann, int boatMiss, char boatPos) {
		this.setLeftBankCannibals(leftCann);
		this.setLeftBankMissionaries(leftMiss);
		this.setRightBankCannibals(rightCann);
		this.setRightBankMissionaries(rightMiss);
		this.setBoatCannibals(boatCann);
		this.setBoatMissionaries(boatMiss);
		this.setBoatPosition(boatPos);
	}

	public int getRightBankCannibals() {
		return rightCannibals;
	}

	public void setRightBankCannibals(int rightBankCannibals) {
		this.rightCannibals = rightBankCannibals;
	}

	public int getRightBankMissionaries() {
		return rightMissionaries;
	}

	public void setRightBankMissionaries(int rightBankMissionaries) {
		this.rightMissionaries = rightBankMissionaries;
	}

	public int getLeftBankCannibals() {
		return leftCannibals;
	}

	public void setLeftBankCannibals(int leftBankCannibals) {
		this.leftCannibals = leftBankCannibals;
	}

	public int getLeftBankMissionaries() {
		return leftMissionaries;
	}

	public void setLeftBankMissionaries(int leftBankMissionaries) {
		this.leftMissionaries = leftBankMissionaries;
	}
	
	public int getBoatMissionaries() {
		return boatMissionaries;
	}

	public void setBoatMissionaries(int boatMissionaries) {
		this.boatMissionaries = boatMissionaries;
	}
	
	public int getBoatCannibals() {
		return boatCannibals;
	}

	public void setBoatCannibals(int boatCannibals) {
		this.boatCannibals = boatCannibals;
	}
	
	public char getBoatPosition() {
		return boatPosition;
	}

	public void setBoatPosition(char boatPosition) {
		this.boatPosition = boatPosition;
	}
	
	public void increaseLeftMissionaries(int n) {
	    leftMissionaries += n;
	}

	public void decreaseLeftMissionaries(int n){
	    leftMissionaries -= n;
	}

	public void increaseLeftCannibals(int n) {
	    leftCannibals += n;
	}

	public void decreaseLeftCannibals(int n){
	    leftCannibals -= n;
	}

	public void increaseRightMissionaries(int n) {
	    rightMissionaries += n;
	}

	public void decreaseRightMissionaries(int n){
	    rightMissionaries -= n;
	}

	public void increaseRightCannibals(int n) {
	    rightCannibals += n;
	}

	public void decreaseRightCannibals(int n){
	    rightCannibals -= n;
	}

	public void increaseBoatMissionaries(int n) {
	    boatMissionaries += n;
	}

	public void decreaseBoatMissionaries(int n){
	    boatMissionaries -= n;
	}

	public void increaseBoatCannibals(int n) {
	    boatCannibals += n;
	}

	public void decreaseBoatCannibals(int n){
	    boatCannibals -= n;
	}

	
	@Override
	public CrossRiverState clone() {
		return new CrossRiverState(
			this.leftCannibals,
			this.leftMissionaries,
			this.rightCannibals,
			this.rightMissionaries,
			this.boatCannibals,
			this.boatMissionaries,
			this.boatPosition
		);
	}

	public boolean validate() {
		
		// missionaries get eaten cases
		if (leftCannibals >= leftMissionaries && leftMissionaries > 0 && leftMissionaries != 3)
			return false;
		if (rightCannibals >= rightMissionaries && rightMissionaries > 0 && rightMissionaries != 3)
			return false;
		
		// not defined cases
		if (leftCannibals > 3 || leftMissionaries > 3 ||
				rightCannibals > 3 || rightMissionaries > 3 ||
				boatCannibals > 2 || boatMissionaries > 2)
			return false;
		if (leftCannibals < 0 || leftMissionaries < 0 ||
				rightCannibals < 0 || rightMissionaries < 0 ||
				boatCannibals < 0 || boatMissionaries < 0)
			return false;
		if (leftCannibals + rightCannibals + boatCannibals != 3 ||
				leftMissionaries + rightMissionaries + boatMissionaries != 3 ||
				boatCannibals + boatMissionaries > 2)
			return false;
		
		return true;
		
	}
	
	public String toString() {
		return String.format(
			"Left: %d M %d C | Boat: %d M %d C -%c | Right: %d M %d C",
			this.leftMissionaries,
			this.leftCannibals,
			this.boatMissionaries,
			this.boatCannibals,
			this.boatPosition,
			this.rightMissionaries,
			this.rightCannibals
		);
	}

	public boolean equals(Object state) {
		if (state instanceof CrossRiverState && state.toString() == this.toString()) {
			return true;
		} else {
			return false;
		}
	}

}
