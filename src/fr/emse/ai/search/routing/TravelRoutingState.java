package fr.emse.ai.search.routing;

public class TravelRoutingState {
    // represent the coordinates
    private double x;
    private double y;

    public TravelRoutingState(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public boolean equals(double x, double y) {
        if (this.x == x && this.y == y) {
            return true;
        }
        return false;
    }
}
