package main.java.codingame;

import java.io.IOException;
import java.util.Arrays;

public class LeaderBoard {
	 // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] results = new int[alice.length];  
        int j ; 
        int rank;   
        int lastIndex=scores.length-1;  
        for (int i = 0; i < alice.length; i++) {            
            rank = 1;
            j = 0;
            boolean next = true;
            while (j <lastIndex && next) {
                if(alice[i]>=scores[j]){
                    results[i]=rank;                    
                    next=false;
                }else if (scores[j]!=scores[j+1]){
                    rank++;
                    if(alice[i]<scores[j] && alice[i]>scores[j+1]){
                        results[i]=rank;                    
                        next=false;
                    }
                }               
                j++;
            } 
            lastIndex = j;   
            if(results[i]==0){
                if (alice[i] > scores[scores.length-1])
                    results[i]=--rank;  
                else if(alice[i] < scores[scores.length-1])
                    results[i]=++rank;  
                else
                    results[i]=rank;
            }      
        }
        return results;
    }
    static int[] climbingLeaderboardOptimized(int[] scores, int[] alice) {
        int[] results = new int[alice.length];  
        int j ; 
        int rank;   
        int lastIndex=scores.length-1;  
        for (int i = 0; i < alice.length; i++) {            
            rank = 1;
            j = 0;
            boolean next = true;
            while(alice[i]>scores[lastIndex/2])
            	lastIndex = lastIndex/2;
            	
            while (j <lastIndex && next) {
                if(alice[i]>=scores[j]){
                    results[i]=rank;                    
                    next=false;
                }else if (scores[j]!=scores[j+1]){
                    rank++;
                    if(alice[i]<scores[j] && alice[i]>scores[j+1]){
                        results[i]=rank;                    
                        next=false;
                    }
                }               
                j++;
            } 
            lastIndex = j;   
            if(results[i]==0){
                if (alice[i] > scores[scores.length-1])
                    results[i]=--rank;  
                else if(alice[i] < scores[scores.length-1])
                    results[i]=++rank;  
                else
                    results[i]=rank;
            }      
        }
        return results;
    }

    public static void main(String[] args) throws IOException {
    	int[] scores = {100, 100, 50, 40, 40, 20, 10};
    	int[] alice = {5, 25, 50, 120};
        int[] result = climbingLeaderboard(scores, alice);
        Arrays.stream(result).forEach(System.out::println); //6 4 2 1
    }
}
