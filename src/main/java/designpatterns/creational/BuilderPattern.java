package main.java.designpatterns.creational;

/**
 * Builder is widely used in Java core libraries:

java.lang.StringBuilder#append() (unsynchronized)
java.lang.StringBuffer#append() (synchronized)
java.nio.ByteBuffer#put() (also in CharBuffer, ShortBuffer, IntBuffer, LongBuffer, FloatBuffer and DoubleBuffer)
javax.swing.GroupLayout.Group#addComponent()
All implementations java.lang.Appendable
 */
public class BuilderPattern {
	/**
	 * BuilderPattern class is immutable, and all parameter default values are
	 * in one place. The builder’s setter methods return the builder itself 
	 * so that invocations can be chained, resulting in a fluent API. Here’s how the client code looks
	 */
	private final int calories; 
	private final int fat; 

	/**
	 * Builder Design Pattern in Java
	 * Let’s see how we can implement builder design pattern in java.
	 * 1 - First of all you need to create a static nested class and then copy all the arguments from the outer class to the Builder class.
	 * 2 - Java Builder class should have a public constructor with all the required attributes as parameters.
	 * 3 - Java Builder class should have methods to set the optional parameters and it should 
	 *     return the same Builder object after setting the optional attribute.
	 * 1 - The final step is to provide a build() method in the builder class that will return the Object needed by client program. 
	 *     For this we need to have a private constructor in the Class with Builder class as argument.
	 */
	public static class Builder { // Required parameters private final int servingSize; private final int servings;
		// Optional parameters - initialized to default values 
		private int calories = 0; 
		private int fat= 0;

		public Builder() {
		}
		public Builder(int calories, int fat) { 
			this.calories = calories; 
			this.fat = fat;
		}

		public Builder calories(int val) { 
			calories = val;

			return this;
		}
		public Builder fat(int val) { 
			fat = val;

			return this;
		}

		public BuilderPattern build() { 
			return new BuilderPattern(this);
		} 
	}
	
	private BuilderPattern(Builder builder) { 
		calories = builder.calories; 
		fat	= builder.fat; 
	}
	
	public static void main(String[] args) {
		BuilderPattern cocaCola = new BuilderPattern.Builder(240, 8).calories(100).build();
		BuilderPattern fanta = new BuilderPattern.Builder().calories(100).build();
	}

}
