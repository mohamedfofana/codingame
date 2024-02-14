package main.java.patternmatching;

public class PatternMatchingInstanceOf {

}
interface Shape {
	public static double getPerimeterMid(Shape shape) throws IllegalArgumentException {
        if (shape instanceof Rectangle r) {
            return 2 * r.length() + 2 * r.width();
        } else if (shape instanceof Circle c) {
            return 2 * c.radius() * Math.PI;
        } else {
        	// You can use a pattern variable in the expression of an if statement:
        	// Because the conditional-AND operator (&&) is short-circuiting, the program can reach the r.length() > 5 expression only if the instanceof operator is true.
        	 if (shape instanceof Rectangle r && r.length() > 5) {
                 // ...
             }
        	 // Conversely, you can't pattern match with the instanceof operator in this situation:
        	 // The program can reach the r.length() || 5 if the instanceof is false; thus, you cannot use the pattern variable r here.
//        	 if (shape instanceof Rectangle r || r.length() > 5) {
//        		 // ...
//        	 }
            throw new IllegalArgumentException("Unrecognized shape");
        }
    }
	
	public static double getPerimeterOld(Shape shape) throws IllegalArgumentException {
		if (shape instanceof Rectangle) {
			Rectangle r = (Rectangle) shape;
			return 2 * r.length() + 2 * r.width();
		} else if (shape instanceof Circle) {
			Circle c = (Circle) shape;
			return 2 * c.radius() * Math.PI;
		} else {
			throw new IllegalArgumentException("Unrecognized shape");
		}
	}
}

class Rectangle implements Shape {
	final double length;
	final double width;    
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}    
	double length() { return length; }
	double width() { return width; }
}

class Circle implements Shape {
	final double radius;
	public Circle(double radius) {
		this.radius = radius;
	}  
	double radius() { return radius; }
}