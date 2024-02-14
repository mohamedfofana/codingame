package main.java.codingame.game;

public class EnumPlanetTest {

	public static void main(String[] args) {
		System.out.println(Planet.MERCURY == Planet.MERCURY);
		System.out.println(Planet.MERCURY.equals(Planet.MERCURY));
		System.out.println(Planet.MERCURY.equals(Planet.MERCURY.toString()));
//		System.out.println(Planet.MERCURY.toString() == Planet.MERCURY); // Exception
		System.out.println(Planet.MERCURY == Planet.EARTH);
		System.out.println("MERCURY".equals(Planet.MERCURY));
	}
	enum Planet {
		MERCURY, VENUS, EARTH
	}
}
