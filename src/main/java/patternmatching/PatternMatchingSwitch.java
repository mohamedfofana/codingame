package main.java.patternmatching;

public class PatternMatchingSwitch {
	
	// old switch
	public static double getPerimeter(ShapeRecord shape) throws IllegalArgumentException {
		if (shape instanceof RectangleRecord r) {
			return 2 * r.length() + 2 * r.width();
		} else if (shape instanceof CircleRecord c) {
			return 2 * c.radius() * Math.PI;
		} else {
			throw new IllegalArgumentException("Unrecognized shape");
		}
	}

	// Not available yet
	// ou can rewrite this code to use a pattern switch expression as follows:
//	public static double getPerimeterPattern(ShapeRecord shape) throws IllegalArgumentException {
//		return switch (shape) {
//		case RectangleRecord r -> 2 * r.length() + 2 * r.width();
//		case CircleRecord c    -> 2 * c.radius() * Math.PI;
//		default          -> throw new IllegalArgumentException("Unrecognized shape");
//		};
//	}

	// The following example uses a switch statement instead of a switch expression:
//	public static double getPerimeterStatement(ShapeRecord shape) throws IllegalArgumentException {
//		switch (shape) {
//		case RectangleRecord r: return 2 * r.length() + 2 * r.width();
//		case CircleRecord c:    return 2 * c.radius() * Math.PI;
//		default:          throw new IllegalArgumentException("Unrecognized shape");
//		}
//	}
}

interface ShapeRecord {}
record RectangleRecord(double length, double width) implements ShapeRecord {}
record CircleRecord(double radius) implements ShapeRecord { }