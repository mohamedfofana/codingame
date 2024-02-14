package main.java.codingame.game;

public class QueensAttack {
	// Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        int numCase = 0;
        r_q--;
        c_q--;
        //top left
        boolean next = true;
        for(int i=1; r_q-i>=0 && c_q-i>=0 && next; i++)
            if (!isObstacle(r_q-i, c_q-i, obstacles))
                numCase++;
            else
                next = false;
        // top right
        next = true;
        for(int i=1; c_q+i<n && r_q-i>=0 && next; i++)
            if (!isObstacle(r_q-i, c_q+i, obstacles))
                numCase++;
            else
                next = false;
        // bottom left
        next = true;
        for(int i=1; r_q+i<n && c_q-i>=0 && next; i++)
            if (!isObstacle(r_q+i, c_q-i, obstacles))
                numCase++;
            else
                next = false;
        // bottom right
        next = true;
        for(int i=1; r_q+i<n && c_q+i<n && next; i++)
            if (!isObstacle(r_q+i, c_q+i, obstacles))
                numCase++;
            else
                next = false;
        // left
        next = true;
        for(int i=1; c_q-i>=0 && next; i++)
            if (!isObstacle(r_q, c_q-i, obstacles))
                numCase++;
            else
                next = false;
        // right
        next = true;
        for(int i=1; c_q+i<n && next; i++)
            if (!isObstacle(r_q, c_q+i, obstacles))
                numCase++;
            else
                next = false;
        // top
        next = true;
        for(int i=1; r_q-i>=0 && next; i++)
            if (!isObstacle(r_q-i, c_q, obstacles))
                numCase++;
            else
                next = false;
        // bottom
        next = true;
        for(int i=1; r_q+i<n && next; i++)
            if (!isObstacle(r_q+i, c_q, obstacles))
                numCase++;
            else
                next = false;
        return numCase;
    }
    
    static boolean isObstacle(int r, int c, int[][] obstacles){
        if(obstacles.length>0)
            for (int i = 0; i < obstacles.length; i++)
                if (r==obstacles[i][0]-1 && c==obstacles[i][1]-1)
                    return true;
        return false;
    }
    // Complete the queensAttack function below.
    static int queensAttack2(int n, int k, int r_q, int c_q, int[][] obstacles) {
      int hLeft = c_q-1;
      int hRight = n-c_q;
      int vTop = r_q-1;
      int vBottom = n-r_q;
      int diagTopLeft = Math.min(r_q-1, c_q-1);
      int diagTopRight = Math.min(n-r_q, n-c_q);
      int diagBottomLeft = Math.min(n-r_q, c_q-1);
      int diagBottomRight = Math.min(r_q-1, n-c_q);
      for (int i = 0; i < obstacles.length; i++) { 
          if ( r_q > obstacles[i][0] && c_q > obstacles[i][1] && 
                  r_q-obstacles[i][0] == c_q-obstacles[i][1] ) 
              diagTopLeft = Math.min(diagTopLeft, r_q-obstacles[i][0]-1); 
    
          if ( obstacles[i][0] > r_q && obstacles[i][0] > c_q && 
                  obstacles[i][0]-r_q == obstacles[i][1]-c_q ) 
              diagBottomLeft = Math.min( diagBottomLeft, obstacles[i][0]-r_q-1); 
    
          if ( obstacles[i][0] > r_q && c_q > obstacles[i][1] && 
                  obstacles[i][0]-r_q == c_q-obstacles[i][1] ) 
              diagTopRight = Math.min(diagTopRight, obstacles[i][0]-r_q-1); 
    
          if ( r_q > obstacles[i][0] && obstacles[i][1] > c_q && 
                      r_q-obstacles[i][0] == obstacles[i][1]-c_q ) 
              diagBottomRight = Math.min(diagBottomRight, r_q-obstacles[i][0]-1); 
    
          if ( r_q == obstacles[i][0] && obstacles[i][1] < c_q ) 
              hLeft = Math.min(hLeft, c_q-obstacles[i][1]-1); 
    
          if ( r_q == obstacles[i][0] && obstacles[i][1] > c_q ) 
              hRight = Math.min(hRight, obstacles[i][1]-c_q-1); 
    
          if ( c_q == obstacles[i][1] && obstacles[i][0] < r_q ) 
              vTop = Math.min(vTop, r_q-obstacles[i][0]-1); 
    
          if ( c_q == obstacles[i][1] && obstacles[i][0] > r_q ) 
              vBottom = Math.min(vBottom, obstacles[i][0]-r_q-1); 
      } 
    
      return diagTopLeft + diagBottomLeft + diagTopRight + diagBottomRight + hLeft + hRight + vTop + hRight; 
    }
    
    
    public static void main(String[] args) {

		for(int i=0; i<8; i++) {

			for(int j=0; j<8; j++)

				System.out.print(i+","+j+"   ");

			System.out.println();

		}

	}
}
