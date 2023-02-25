/*  Improvement over previous Space: O(n) solution that used an auxillary array
    ==============================================================================
    
    Time:  O(n)  |  Space:  O(1) 
        Time is originally O(3n), but because constants are 
        ignored in Big O notation, the actual Big O Time notation is O(n)
        
*/

class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        int number;
        int newIdx;
        
        //set all negative numbers' indexes to 0;
        for (int i = 0; i < len; i++){
            if (nums[i] < 0){
                    nums[i] = 0;
            }
        }
        
     //   System.out.println("nums with no negative numbers  " + Arrays.toString(nums));
        
        //iterate through updated array and mark all valid positive value index's to a negative to indicate that number is in array (if not already negative)
        for (int j = 0; j < len; j++){
            number = Math.abs(nums[j]);     //get absolute value of nums[j] 
            newIdx = number - 1;
            if (number >= 1 && number <= len){   //if abs(nums[j] is in range
                if (nums[newIdx] > 0){
                    nums[newIdx] *= -1;   //set index at number - 1 to negative if not already negative
                }else if(nums[newIdx] == 0){  //if 0, set it to a value that is always out of range (i.e. length + 1)
                    
                    nums[newIdx] = -1 * (len + 1);
                }
            }
        }
        
       /*
        //verify final array
       System.out.println(Arrays.toString(nums));
       */
        
        
        //find first positive in updated array and return its index, this indicates that index is not in array
       for (int firstPositive = 1; firstPositive <= nums.length; firstPositive++){
            if (nums[firstPositive - 1] >= 0){
                //System.out.println(nums[firstPositive-1]);
                return firstPositive;
            }
        }
        
        //if previous loop completes, then all numbers from 1 to nums.length is in array, return the next expected number
        return nums.length + 1;
    }
}
