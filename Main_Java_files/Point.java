public class Point {
    private double x_coord;
    private double y_coord;

    // Constructor for Point
    public Point(double x, double y) {
        this.x_coord = x;
        this.y_coord = y;
    }

    // Get x coordinate
    public double getXCoord() {
        return x_coord;
    }
    // Get y coordinate
    public double getYCoord() {
        return y_coord;
    }

    // Convert point to string
    public String toString() {
        return "(" + x_coord + "," + y_coord + ")";
    }
}
