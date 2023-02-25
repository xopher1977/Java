/* Time:  O(n) | Space:  O(n) */
class Solution {
    public int trap(int[] height) {
        int[] allMaxes = new int[height.length];
        int totalArea = 0;
        
        int leftHighest = 0;
        for (int i = 0; i < height.length; i++){
          //  int maxHeight = height[i];
            allMaxes[i] = leftHighest;
            leftHighest = Math.max(leftHighest, height[i]);
        }
        
        
        int rightHighest = 0;  
        for (int j = height.length-1; j >= 0; j--){
            int maxHeight = height[j];  
            int minHeight = Math.min(rightHighest, allMaxes[j]);  
            if (minHeight > maxHeight){   
                allMaxes[j] = minHeight - maxHeight;
            }else{
               allMaxes[j] = 0;
            }    
            rightHighest = Math.max(rightHighest, maxHeight);
        }
        
        for (int water : allMaxes){
            totalArea += water;
        }
        
        return totalArea;
    }
}
