import java.util.*;

/* Time:  O(n * m) where n is the length of garden, and m is height  
   Space: O(n * m)  Space required for auxillary grid
*/

public class Main
{
	public static void main(String[] args) {
	int[][] flowers = {
                            {5, 0, 0, 8},
                            {0, 0, 0, 3},
                            {7, 2, 0, 0},
                            {6, 0, 0, 6},
                        
		                };
		                
		 System.out.println(Arrays.toString(mostFragrantFlower(flowers, 2, 1)));               
	}
	
	public static int[] mostFragrantFlower(int[][] garden, int visitX, int visitY){
	  int[] result = new int[] {-1, -1};    //resulting array
	  int[][] builtGarden = garden;   // auxillary fragrance garden
	  
	  //double for loop to build auxillary fragrance garden...
	  for (int i = 0; i < garden.length; i++){
	    for (int j = 0; j < garden[i].length; j++){
	      if (garden[i][j] > 0){
	        int fragranceStrength = garden[i][j];
	        buildFragranceGrid(garden, builtGarden, fragranceStrength, i, j);
	      }
	    }
	  }
	  
	  while (true){  //run until current is greater than all of its neighbors
	    
	    int currentVal = builtGarden[visitX][visitY];    //gets current val of visitX, visitY
	    int[] maxPos = maxNeighbor(builtGarden, visitX, visitY);  //finds max neighbor of current
	    int valOfMax = builtGarden[maxPos[0]][maxPos[1]];  //gets value of max neighbor
	    
	    if (valOfMax > currentVal){  //if max > current, update visitX, visitY,
	      visitX = maxPos[0];
	      visitY = maxPos[1];
	    }else{  //otherwise, current is the max, update result and return
	      result[0] = visitX;
	      result[1] = visitY;
	      return result;
	    }
	  }
	  
	}
	
	public static void buildFragranceGrid(int[][]garden, int[][]builtGarden, int fragrance, int x, int y){

	  if (x < 0 || x >= garden.length || y < 0 || y >= garden[0].length || fragrance <= 0){  
	    return;  //if coordinate out of bounds or fragrance at coordinate <= 0, do nothing
	  }
	  
	  
	  if (fragrance > 0 && fragrance > builtGarden[x][y]){
	    //if there is a fragrance AND if its greater than the fragrance that's already there, update
	    builtGarden[x][y] = fragrance;
	  }
	  
	  //run recursively on four neighbors with one less fragrance..
	  buildFragranceGrid(garden, builtGarden, fragrance - 1, x-1, y);
	  buildFragranceGrid(garden, builtGarden, fragrance - 1, x + 1, y);
	  buildFragranceGrid(garden, builtGarden, fragrance - 1, x, y - 1);
	  buildFragranceGrid(garden, builtGarden, fragrance - 1, x, y + 1);
	}
	
	public static int[] maxNeighbor(int[][] builtGarden, int x, int y){
	  //finds maximum neighbor of given cordinate.
	  
	  int max = Integer.MIN_VALUE;   //initialize to negative infiniti;
	  int up;
	  int down;
	  int left;
	  int right;
	  int[] result = new int[2];
	  
	  up = (x == 0) ? Integer.MIN_VALUE : builtGarden[x-1][y];
	  //ternary; if out of bounds, set to -inf otherwise get value above
	  if (up > max){ //if greater than current max, update
	    result[0] = x - 1;
	    result[1] = y;
	    max = up;
	  }
	  
	  down = (x >= builtGarden.length - 1) ? Integer.MIN_VALUE : builtGarden[x+1][y];
	    //ternary; if out of bounds, set to -inf otherwise get value down
	  if (down > max){  //update if needed
	    result[0] = x + 1;
	    result[1] = y;
	    max = down;
	  }
	  
	  
	  left = (y == 0) ? Integer.MIN_VALUE : builtGarden[x][y-1];
	    //ternary; if out of bounds, set to -inf otherwise get value left
	    if (left > max){ //update if needed
	    result[0] = x;
	    result[1] = y-1;
	    max = left;
	  }
	  
	  right = (y >= builtGarden[0].length - 1) ? Integer.MIN_VALUE : builtGarden[x][y+1];
	    //ternary; if out of bounds, set to -inf otherwise get value right
	  if (right > max){//update if needed
	    result[0] = x;
	    result[1] = y+1;
	    max = right;
	  }
	 
	 //return max coordinate as int array [x, y]
	 return result;
	}
}
