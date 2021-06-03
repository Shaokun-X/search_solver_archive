package fr.emse.ai.search.routing;

import java.util.ArrayList;
import java.util.Collection;

import fr.emse.ai.search.core.InformedProblem;
import fr.emse.ai.search.core.Node;

public class TravelRoutingProblem implements InformedProblem {

    private final double DestX = 7;
    private final double DestY = 6;

    @Override
    public Object getInitialState() {
        return new TravelRoutingState(0, 0);
    }

    @Override
    public boolean isGoal(Object state) {
        TravelRoutingState s = (TravelRoutingState) state;
        return s.equals(DestX, DestY);
    }

    @Override
    public Collection<Object> getActions(Object state) {
        TravelRoutingState s = (TravelRoutingState) state;
        Collection<Object> actions = new ArrayList<>();
        if (s.equals(0, 0)) {
            actions.add(new TravelRoutingAction(1, 2));
            actions.add(new TravelRoutingAction(2, 1));
        }
        if (s.equals(1, 2)) {
            actions.add(new TravelRoutingAction(0, 0));
            actions.add(new TravelRoutingAction(2, 1));
            actions.add(new TravelRoutingAction(1, 5));
        }
        if (s.equals(2, 1)) {
            actions.add(new TravelRoutingAction(0, 0));
            actions.add(new TravelRoutingAction(1, 2));
            actions.add(new TravelRoutingAction(2, 3));
            actions.add(new TravelRoutingAction(5, 3));
            actions.add(new TravelRoutingAction(5, 0));
        }
        if (s.equals(2, 3)) {
            actions.add(new TravelRoutingAction(1, 5));
            actions.add(new TravelRoutingAction(2, 1));
        }
        if (s.equals(1, 5)) {
            actions.add(new TravelRoutingAction(1, 2));
            actions.add(new TravelRoutingAction(2, 3));
            actions.add(new TravelRoutingAction(4, 4));
            actions.add(new TravelRoutingAction(4, 6));
        }
        if (s.equals(5, 0)) {
            actions.add(new TravelRoutingAction(2, 1));
            actions.add(new TravelRoutingAction(7, 2));
        }
        if (s.equals(5, 3)) {
            actions.add(new TravelRoutingAction(4, 4));
            actions.add(new TravelRoutingAction(2, 1));
        }
        if (s.equals(4, 4)) {
            actions.add(new TravelRoutingAction(1, 5));
            actions.add(new TravelRoutingAction(7, 6));
            actions.add(new TravelRoutingAction(6, 4));
            actions.add(new TravelRoutingAction(5, 3));
        }
        if (s.equals(7, 2)) {
            actions.add(new TravelRoutingAction(6, 4));
            actions.add(new TravelRoutingAction(5, 0));
        }
        if (s.equals(6, 4)) {
            actions.add(new TravelRoutingAction(4, 4));
            actions.add(new TravelRoutingAction(7, 2));
        }
        if (s.equals(4, 6)) {
            actions.add(new TravelRoutingAction(1, 5));
            actions.add(new TravelRoutingAction(7, 6));
        }
        if (s.equals(7, 6)) {
            actions.add(new TravelRoutingAction(4, 6));
            actions.add(new TravelRoutingAction(4, 4));
        }

        return actions;
    }

    @Override
    public Object getNextState(Object state, Object action) {
        TravelRoutingAction a = (TravelRoutingAction) action;
        return new TravelRoutingState(a.getMoveToX(), a.getMoveToY());
    }

    @Override
    public double getStepCost(Object start, Object action, Object dest) {
        TravelRoutingState s = (TravelRoutingState) start;
        TravelRoutingState d = (TravelRoutingState) dest;
        return Math.sqrt(Math.pow(s.getX() - d.getX(), 2) + Math.pow(s.getY() - d.getY(), 2));
    }

    @Override
    public double getHeuristic(Node node) {
        TravelRoutingState s = (TravelRoutingState) node.getState();
        return Math.sqrt(Math.pow(s.getX() - DestX, 2) + Math.pow(s.getY() - DestY, 2));
    }

}
