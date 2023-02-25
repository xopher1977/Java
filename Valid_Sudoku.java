class Solution {
    
    final int SIZE = 3;
    public boolean isValidSudoku(char[][] board) {      
        
         for (int x = 0; x < SIZE*SIZE; x++){
	        for (int y = 0; y < SIZE*SIZE; y++){
                if (board[x][y]!='.'){
                    if (inSquare(x,y,board)){  //check square first
                     //   System.out.println("DUP IN SQUARE");
                       return false;     
                    }else if (inRow(x,y,board)){   //no dup in square, check row
                      //  System.out.println("DUP IN ROW");
                        return false;
                    }else if (inColumn(x,y,board)){  //no dup in row, check column
                     //   System.out.println("DUP IN COLUMN");
                        return false;
                    }  
                }          
            } 
         } 
                    
        return true;  //no dups found in square, row, or column, return true;  
    } 
            
 
     boolean inRow(int x, int y, char[][] sud){
         
	    char val = sud[x][y];
        int yOffset = (y + (SIZE - (y % SIZE))); 
         
	   for (int i = yOffset; i < SIZE*SIZE; i++){
	       if (sud[x][i]!='.'){   
           if ((sud[x][i])==val){
	               return true;
	            }
	        }
       }
	    return false;
	}
	
	
    
	 boolean inColumn(int x, int y, char[][] sud){
         
	    char val = sud[x][y];
        int xOffset = (x + (SIZE - (x % SIZE)));
	    
	    for (int i = xOffset; i < SIZE*SIZE; i++){
           if (sud[i][y]!='.'){
	            if ((sud[i][y])==val){
	               return true;
	            }
	        } 
        }
	    return false;
	}
    
    
	 boolean inSquare(int x, int y, char[][] sud){
	
         //x = 0;
         //y = 0;
	    char val = sud[x][y]; //5
         
         
        int topLeftX = x - (x % SIZE);  //0
        int topLeftY = y - (y % SIZE);  //0
	                
        for (int i = topLeftX; i < (topLeftX + SIZE); i++){
             for (int j = topLeftY; j < (topLeftY + SIZE); j++){
            if (sud[i][j]!='.'){   //[0, 2] = '.'  
                if (!((x == i) && (y == j))){ 
                 if (sud[i][j] == sud[x][y]){
                         return true;
                     }             
                 }
            }
             }
        }
	    return false;  
	}
}
