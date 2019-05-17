package main.java.codingame;

public class MonteCarloPi {
	// Soit un cercle de rayon r = 1 dans un carré de coté c avec c = 2r;
	// La surface du cercle est (Pi * r*r) = (Pi * 1*1).
	// soit p point dans le cercle 
	// Proba point dans cercle est Pi/4 = nbPointsInCircle/nbPoints ==> Pi = 4 * nbPointsInCircle / nbPoints
	public static void main (String [] args) {
		int nbPoints = 100000;
		int nbPointsInCircle = 0;
		for (int i = 0; i < nbPoints; i++) {
			double x = Math.random();
			double y = Math.random();
			if (Math.pow(x, 2) +Math.pow(y, 2) <=1) {
				nbPointsInCircle++;
			}
		}
		double pi = 0.0;
		if (nbPointsInCircle != 0)
			pi = 4.0 * nbPointsInCircle /nbPoints;
		
		System.out.println("Approximation de pi = " + pi + " sur " + nbPoints + " points.");
	}
}
