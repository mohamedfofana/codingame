package main.java.codingame.game;

public class KariakooGame {

	static int getPositionAt(int n) {
	    int realPosition = n;  
	   
    	if (realPosition>=6){
    	    realPosition = realPosition%6;   
    	}
        if (realPosition == 0){
            return 0;
        }
        else if (realPosition == 1){
             return 1;
        }
        else if (realPosition == 2){
            return -1;
        }
        else if (realPosition == 3){
            return -4;
        }
        else if (realPosition == 4){
            return -5;
        }
        else{ // realPosition == 5
            return -3;
        }
     
	}
	
	public static void main(String[] args) {
		System.out.println(getPositionAt(0)); // 0
		System.out.println(getPositionAt(1)); // 1
		System.out.println(getPositionAt(2)); // -1
		System.out.println(getPositionAt(3)); // -4
		System.out.println(getPositionAt(4)); // -5
		System.out.println(getPositionAt(5)); // -3
		System.out.println(getPositionAt(6)); // 0
		System.out.println(getPositionAt(7)); // 1
		System.out.println(getPositionAt(8)); // -1
		System.out.println(getPositionAt(9)); // -4
		System.out.println(getPositionAt(10)); // -5
		System.out.println(getPositionAt(11)); // -3
		System.out.println(getPositionAt(12)); // 0
		System.out.println(getPositionAt(13)); // 1
	}
	
//	R�sultat
//	Les positions sont correctes avec un jeu de donn�es simple : Succ�s
//	Les positions aux �tapes 0, 1 et 2 sont correctes : Succ�s
//	La position reste correcte pour n autour de 100 000 : Succ�s
//	La complexit� algorithmique est d'ordre O(1) : Succ�s
//	Lisibilit� du code : 100%

}

