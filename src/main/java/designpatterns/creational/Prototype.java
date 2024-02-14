package main.java.designpatterns.creational;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Usage examples: The Prototype pattern is available in Java out of the box with a Cloneable interface.

Any class can implement this interface to become cloneable.

java.lang.Object#clone() (class should implement the java.lang.Cloneable interface)
 */
public class Prototype {
	/**
	 * Prototype is a creational design pattern that allows cloning objects, even complex ones, without coupling to their specific classes.
	 * All prototype classes should have a common interface that makes it possible to copy objects even if their concrete classes are unknown. 
	 * Prototype objects can produce full copies since objects of the same class can access each other’s private fields.
	 * 
	 * Implements Equals
	 */
	abstract class Shape {
	    public int x;
	    public int y;
	    public String color;

	    public Shape() {
	    }

	    public Shape(Shape target) {
	        if (target != null) {
	            this.x = target.x;
	            this.y = target.y;
	            this.color = target.color;
	        }
	    }

	    public abstract Shape clone();

	    @Override
	    public boolean equals(Object object2) {
	        if (!(object2 instanceof Shape)) return false;
	        Shape shape2 = (Shape) object2;
	        return shape2.x == x && shape2.y == y && Objects.equals(shape2.color, color);
	    }
	}
	
	class Circle extends Shape {
	    public int radius;

	    public Circle() {
	    }

	    public Circle(Circle target) {
	        super(target);
	        if (target != null) {
	            this.radius = target.radius;
	        }
	    }

	    @Override
	    public Shape clone() {
	        return new Circle(this);
	    }

	    @Override
	    public boolean equals(Object object2) {
	        if (!(object2 instanceof Circle) || !super.equals(object2))
	        	return false;
	        Circle shape2 = (Circle) object2;
	        
	        return shape2.radius == radius;
	    }
	}
	
	class Rectangle extends Shape {
	    public int width;
	    public int height;

	    public Rectangle() {
	    }

	    public Rectangle(Rectangle target) {
	        super(target);
	        if (target != null) {
	            this.width = target.width;
	            this.height = target.height;
	        }
	    }

	    @Override
	    public Shape clone() {
	        return new Rectangle(this);
	    }

	    @Override
	    public boolean equals(Object object2) {
	        if (!(object2 instanceof Rectangle) || !super.equals(object2)) 
	        	return false;
	        Rectangle shape2 = (Rectangle) object2;
	        
	        return shape2.width == width && shape2.height == height;
	    }
	}
	
	class Demo {
	    public static void main(String[] args) {
	    	Prototype prototype = new Prototype();
	        List<Shape> shapes = new ArrayList<>();
	        List<Shape> shapesCopy = new ArrayList<>();

	        Circle circle = prototype.new Circle();
	        circle.x = 10;
	        circle.y = 20;
	        circle.radius = 15;
	        circle.color = "red";
	        shapes.add(circle);

	        Circle anotherCircle = (Circle) circle.clone();
	        shapes.add(anotherCircle);

	        Rectangle rectangle = prototype.new Rectangle();
	        rectangle.width = 10;
	        rectangle.height = 20;
	        rectangle.color = "blue";
	        shapes.add(rectangle);

	        cloneAndCompare(shapes, shapesCopy);
	    }

	    private static void cloneAndCompare(List<Shape> shapes, List<Shape> shapesCopy) {
	        for (Shape shape : shapes) {
	            shapesCopy.add(shape.clone());
	        }

	        for (int i = 0; i < shapes.size(); i++) {
	            if (shapes.get(i) != shapesCopy.get(i)) {
	                System.out.println(i + ": Shapes are different objects (yay!)");
	                if (shapes.get(i).equals(shapesCopy.get(i))) {
	                    System.out.println(i + ": And they are identical (yay!)");
	                } else {
	                    System.out.println(i + ": But they are not identical (booo!)");
	                }
	            } else {
	                System.out.println(i + ": Shape objects are the same (booo!)");
	            }
	        }
	    }
	}
}
