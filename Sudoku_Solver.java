class Solution {
    
    int SIZE = 3;
    public void solveSudoku(char[][] board) {
	solveCurrentBoard(0, 0, board);	
   // System.out.println((char) (SIZE + '0'));
  }
	
	public boolean solveCurrentBoard(int row, int column, char[][] board){
		int currentRow = row;
		int currentColumn = column;
		
		if (currentColumn == SIZE * SIZE){
			currentRow++;
			currentColumn = 0;
			if (currentRow == SIZE * SIZE) {
				return true;
			}
		}
		
		if (board[currentRow][currentColumn] == '.'){
			return tryPosition(currentRow, currentColumn, board);
		}
		
		return solveCurrentBoard(currentRow, currentColumn + 1, board);
		
    }
	public boolean tryPosition(int row, int column, char[][] board){
		for (int number = 1; number < 10; number++){
			if(valueIsValidAtPosition(number, row, column, board)){
				board[row][column] = (char) (number + '0');
				if (solveCurrentBoard(row, column + 1, board)){
					return true;
				}
			}
		}
		
		board[row][column] = '.'; 
		return false;
	}
	
	public boolean valueIsValidAtPosition(int value, int row, int column, char[][] board){
		
	 	return notInRowAndColumn(value, row, column, board) && notInSubsquare(value, row, column, board);
	
	}
					 
	public boolean notInRowAndColumn(int value, int row, int column, char[][] board){
		
        for (int c = 0; c < SIZE*SIZE; c++){
            if (board[row][c] == (char) (value + '0')){
                return false;
            }
        }
        
        for (int r = 0; r < SIZE*SIZE; r++){
            if (board[r][column] == (char) (value + '0')){
                return false;
            }
        }
        	
		return true;
        
	}
	
	public boolean notInSubsquare(int value, int row, int column, char[][] board){
		
        int topLeftX = row - (row % SIZE);
        int topLeftY = column - (column % SIZE);
	                
        for (int i = topLeftX; i < (topLeftX + SIZE); i++){
             for (int j = topLeftY; j < (topLeftY + SIZE); j++){ 
                  if (board[i][j] == (char) (value + '0')){
						return false; 
                     }             
             }
        }
	    return true; 
	}
}
