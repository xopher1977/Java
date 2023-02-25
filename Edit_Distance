/*   Time:  O(nm)  n is length of str1 m is length of str2
	 Space:  O(min(n,m)) 
*/

class Solution {
    public int minDistance(String word1, String word2) {
        	
		/*determine smallest and largest string */
        String small = word2.length() < word1.length() ? word2 : word1;
		String big = word2.length() >= word1.length() ? word2 : word1;
		
		/* set up final two rows in dp table, (one needs to be even, other odd) */
		int[] evenEdits = new int[small.length() + 1];
		int[] oddEdits = new int[small.length() + 1];
				
		/*set up first row as base case*/
		/*first row is 0, so therefore use evenEdits*/
		for (int j = 0; j < small.length() + 1; j++){
			evenEdits[j] = j;
		}
		
		/* keep track of current and previous edits, these will point to either 'even' or 'odd'*/
		int[] currentEdits;
		int[] previousEdits;
		
		/* before updating even/odd determine if you're on even row or odd row.*/
		for (int i = 1; i < big.length() + 1; i++){
			if (i % 2 == 0){
				currentEdits = evenEdits;
				previousEdits = oddEdits;
			}else{
				currentEdits = oddEdits;
				previousEdits = evenEdits;
			}
			
			currentEdits[0] = i; //Keep track of first column
			
			//now apply levenstein formula for both strings....
			for (int j = 1; j < small.length() + 1; j++){
				
					int diagonalUp = previousEdits[j-1];
					int left = currentEdits[j-1];
					int up = previousEdits[j];
					if (big.charAt(i-1) == small.charAt(j-1)){
					 	  currentEdits[j] = diagonalUp;
						 }else{
							currentEdits[j] =	1 + minThree(diagonalUp, left, up);					
				 		}
			}			
		}
        
		
        return (big.length() % 2 == 0) ? evenEdits[small.length()] : oddEdits[small.length()];
  }
	
	private static int minThree(int a, int b, int c){
		return Math.min(a, Math.min(b, c));
	}
    
}
