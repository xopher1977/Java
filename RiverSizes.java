/*  
     24:37
		 
		 Time:  O(wh)  width of matrix times height of matrix
		 Space: O(wh)  same as above, except these are on recursive call stack.(Not sure??)
*/

import java.util.*;

class Program {
	static int currentSize = 0;
	
  public static List<Integer> riverSizes(int[][] matrix) {
   
		List<Integer> sizes = new ArrayList<Integer>();
		
		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix[i].length; j++){
				if (matrix[i][j] == 1){ //river found...
					fill(matrix, i, j);
					sizes.add(currentSize);
					currentSize=0;
				}
			}
		}
		
    return sizes;
  }
	
	private static void fill(int[][] matrix, int i, int j){
		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length ||
				 matrix[i][j] != 1	){
			return;  //?? this might not work as expected...
		}
		
		currentSize++;
		
		matrix[i][j] = 0;  //fill
		fill(matrix, i+1, j);
		fill(matrix, i-1, j);
		fill(matrix, i, j+1);
		fill(matrix, i, j-1);

	}
}
