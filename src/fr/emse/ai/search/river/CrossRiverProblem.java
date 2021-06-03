package fr.emse.ai.search.river;

import java.util.ArrayList;
import java.util.Collection;

import fr.emse.ai.search.core.Problem;

public class CrossRiverProblem implements Problem {

	@Override
	public Object getInitialState() {
		return new CrossRiverState();
	}

	@Override
	public boolean isGoal(Object o) {
		if (o instanceof CrossRiverState) {
			CrossRiverState state = (CrossRiverState) o; 
			if (state.getRightBankCannibals() == 3 &&
					state.getRightBankMissionaries() == 3) {
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public Collection<Object> getActions(Object state) {
		ArrayList<Object> actions = new ArrayList<Object>();

		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				for (CrossRiverAction.Direction cannDir: CrossRiverAction.Direction.values()) {
					for (CrossRiverAction.Direction missDir: CrossRiverAction.Direction.values()) {
						if (!(i == 0 && j == 0)) {							
							CrossRiverAction action = new CrossRiverAction(cannDir, missDir, i, j);
							if (testAction(state, action)) {
								actions.add(action);
							}
						}

					}
				}
			}	
		}
		return actions;
	}

	@Override
	public Object getNextState(Object s, Object a) {
		CrossRiverState state = ((CrossRiverState) s).clone();
		CrossRiverAction action = (CrossRiverAction) a;
		
		if (state.getBoatPosition() == 'L') {
			switch (action.getCannibalsDirection()) {
				case TO_BOAT:
					state.decreaseLeftCannibals(action.getCannibals());
					state.increaseBoatCannibals(action.getCannibals());
					break;
				case TO_BANK:
					state.increaseLeftCannibals(action.getCannibals());
					state.decreaseBoatCannibals(action.getCannibals());
					break;
				default:
					System.out.println("Invalid action!");
					break;
			}
			switch (action.getMissionariesDirection()) {
				case TO_BOAT:
					state.decreaseLeftMissionaries(action.getMissionaries());
					state.increaseBoatMissionaries(action.getMissionaries());
					break;
				case TO_BANK:
					state.increaseLeftMissionaries(action.getMissionaries());
					state.decreaseBoatMissionaries(action.getMissionaries());
					break;
				default:
					System.out.println("Invalid action!");
					break;
			}
			state.setBoatPosition('R');
		} else if (state.getBoatPosition() == 'R') {
			switch (action.getCannibalsDirection()) {
				case TO_BOAT:
					state.decreaseRightCannibals(action.getCannibals());
					state.increaseBoatCannibals(action.getCannibals());
					break;
				case TO_BANK:
					state.increaseRightCannibals(action.getCannibals());
					state.decreaseBoatCannibals(action.getCannibals());
					break;
				default:
					System.out.println("Invalid action!");
					break;
			}
			switch (action.getMissionariesDirection()) {
				case TO_BOAT:
					state.decreaseRightMissionaries(action.getMissionaries());
					state.increaseBoatMissionaries(action.getMissionaries());
					break;
				case TO_BANK:
					state.increaseRightMissionaries(action.getMissionaries());
					state.decreaseBoatMissionaries(action.getMissionaries());
					break;
				default:
					System.out.println("Invalid action!");
					break;
			}
			state.setBoatPosition('L');
		}

		return state;
	}
	
	private boolean testAction(Object s, Object a) {
		CrossRiverState nextState = (CrossRiverState) getNextState(s, a);
//		System.out.println(nextState.validate() + "|" + nextState);
		return nextState.validate();
	}

	@Override
	public double getStepCost(Object start, Object action, Object dest) {
		return 1;
	}
	

}
