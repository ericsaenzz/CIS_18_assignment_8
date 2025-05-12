// Eric Chang 
// CIS 18 ASSIGNMENT 8

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Quadrilateral {
    private Point point1;
    private Point point2;
    private Point point3;
    private Point point4;

    // Constructor four points
    public Quadrilateral(Point p1, Point p2, Point p3, Point p4) {
        // Check if points are null
        if (p1 == null || p2 == null || p3 == null || p4 == null) {
            System.out.println(">> Error: POINTS are MISSING!");
            return;
        }
        this.point1 = p1;
        this.point2 = p2;
        this.point3 = p3;
        this.point4 = p4;
    }
    // Getters for points
    public Point get_point1() { return point1; }
    public Point get_point2() { return point2; }
    public Point get_point3() { return point3; }
    public Point get_point4() { return point4; }

    // quad as string
    public String toString() {
        String result = "Quadrilateral: ";
        result += point1.toString() + ", ";
        result += point2.toString() + ", ";
        result += point3.toString() + ", ";
        result += point4.toString();
        return result;
    }
}
class Trapezoid extends Quadrilateral {
    public Trapezoid(Point p1, Point p2, Point p3, Point p4) {
        super(p1, p2, p3, p4);
    }
    // area of trapezoid
    public double get_area() {
        // Formula: (base1 + base2) * height / 2
        double base1_length = Math.sqrt(
            (get_point2().getXCoord() - get_point1().getXCoord()) * 
            (get_point2().getXCoord() - get_point1().getXCoord()) +
            (get_point2().getYCoord() - get_point1().getYCoord()) * 
            (get_point2().getYCoord() - get_point1().getYCoord())
        );
        double base2_length = Math.sqrt(
            (get_point4().getXCoord() - get_point3().getXCoord()) * 
            (get_point4().getXCoord() - get_point3().getXCoord()) +
            (get_point4().getYCoord() - get_point3().getYCoord()) * 
            (get_point4().getYCoord() - get_point3().getYCoord())
        );
        double height = Math.abs(get_point1().getYCoord() - get_point3().getYCoord());
        double area = (base1_length + base2_length) * height / 2;
        return area;
    }
    public String toString() {
        return ">> Trapezoid with points: " + super.toString();
    }
}

class Parallelogram extends Trapezoid {
    public Parallelogram(Point p1, Point p2, Point p3, Point p4) {
        super(p1, p2, p3, p4);
    }
    // Area
    public double get_area() {
        double base = Math.sqrt(
            Math.pow(get_point2().getXCoord() - get_point1().getXCoord(), 2) +
            Math.pow(get_point2().getYCoord() - get_point1().getYCoord(), 2)
        );
        double height = Math.abs(get_point3().getYCoord() - get_point1().getYCoord());
        return base * height;
    }

    public String toString() {
        return "Parallelogram: " + super.toString();
    }
}

class Rectangle extends Parallelogram {
    public Rectangle(Point p1, Point p2, Point p3, Point p4) {
        super(p1, p2, p3, p4);
    }
    public double get_area() {
        double width = Math.abs(get_point2().getXCoord() - get_point1().getXCoord());
        double height = Math.abs(get_point3().getYCoord() - get_point1().getYCoord());
        double area = width * height;
        return area;
    }

    public String toString() {
        return "Rectangle with points: " + super.toString();
    }
}

class Square extends Rectangle {
    public Square(Point p1, Point p2, Point p3, Point p4) {
        super(p1, p2, p3, p4);
    }

    // Area is side * side
    public double get_area() {
        double side_length = Math.abs(get_point2().getXCoord() - get_point1().getXCoord());
        return side_length * side_length;
    }

    public String toString() {
        return "Square: " + super.toString();
    }
}

class QuadrilateralHierarchy {
    public static void main(String[] args) {
        // Test square
        Square sq = new Square(
            new Point(0, 0),
            new Point(6, 0),
            new Point(6, 2),
            new Point(0, 6)
        );
        System.out.println("Square area: " + sq.get_area());
        // Test rectangle
        Rectangle rect = new Rectangle(
            new Point(0, 0),
            new Point(5, 0),
            new Point(5, 4),
            new Point(0, 4)
        );
        System.out.println("Rectangle area: " + rect.get_area());
           // Test trapezoid
        Trapezoid trap = new Trapezoid(
            new Point(0, 0),
            new Point(7, 0),
            new Point(6, 5),
            new Point(4, 5)
        );
        System.out.println("Trapezoid area: " + trap.get_area());

        // Test parallelogram
        Parallelogram para = new Parallelogram(
            new Point(0, 0),
            new Point(6, 0),
            new Point(4, 1),
            new Point(0, 1)
        );
        System.out.println("Parallelogram area : " + para.get_area()+"\n");

        //DATE AND TIME FORMATTER
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MM-dd-yyyy , (HH:mm:ss a)");
        String Date_and_time = now.format(formatter);
       

        System.out.println(">> Thank you for using Eric's Calculator Shape application");
        System.out.print("Time of Calculation is: " + Date_and_time+"\n");
        System.exit(0);
    }
}



