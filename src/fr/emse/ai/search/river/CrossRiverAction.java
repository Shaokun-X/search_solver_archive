package fr.emse.ai.search.river;

public class CrossRiverAction {
	
	public static enum Direction {
		TO_BOAT,
		TO_BANK
	}
	
	private Direction cannibalsDirection;
	private Direction missionariesDirection;
	// number of transfered cannibals in the action
	private int cannibals;
	// number of transfered missionaries in the action
	private int missionaries;
	
	public CrossRiverAction(Direction cannDir, Direction missDir, int cann, int miss) {
		setCannibalsDirection(cannDir);
		setMissionariesDirection(missDir);
		cannibals = cann;
		missionaries = miss;
	}
	

	public int getCannibals() {
		return cannibals;
	}
	
	public void setCannibals(int cannibals) {
		this.cannibals = cannibals;
	}
	
	public int getMissionaries() {
		return missionaries;
	}
	
	public void setMissionaries(int missionaries) {
		this.missionaries = missionaries;
	}


	public Direction getMissionariesDirection() {
		return missionariesDirection;
	}


	public void setMissionariesDirection(Direction missionariesDirection) {
		this.missionariesDirection = missionariesDirection;
	}


	public Direction getCannibalsDirection() {
		return cannibalsDirection;
	}


	public void setCannibalsDirection(Direction cannibalsDirection) {
		this.cannibalsDirection = cannibalsDirection;
	}

	@Override
	public String toString() {
		String str = "";
		switch (cannibalsDirection) {
			case TO_BANK:
				str += "Move " + cannibals + " cannibal(s) from boat to bank, " ;
				break;
			case TO_BOAT:
				str += "Move " + cannibals + " cannibal(s) from bank to boat, ";
				break;
			default:
				break;
		}

		switch (missionariesDirection) {
			case TO_BANK:
				str += cannibals + " missionary(ies) from boat to bank, ";
				break;
			case TO_BOAT:
				str += cannibals + " missionary(ies) from bank to boat, ";
				break;
			default:
				break;
		}

		str += "drive the boat to the other side";
		return str;
	}
}
