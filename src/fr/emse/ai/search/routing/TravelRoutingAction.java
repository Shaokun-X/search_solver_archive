package fr.emse.ai.search.routing;

public class TravelRoutingAction {
    private double moveToX;
    private double moveToY;

    public TravelRoutingAction(double x, double y) {
        moveToX = x;
        moveToY = y;
    }

    public double getMoveToX() {
        return moveToX;
    }

    public double getMoveToY() {
        return moveToY;
    }

    @Override
    public String toString() {
        return "move to " + "(" + moveToX + ", " + moveToY + ")";
    }
    
}
