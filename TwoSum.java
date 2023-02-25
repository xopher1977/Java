class Solution {
    public int[] twoSum(int[] nums, int target) {
           
        int first = 0;
        int second = 1;
       
        int length = nums.length;

        for (int i = 0; i < length - 1; i++){
            for (int j = i+1; j < length; j++){
                if ((nums[i] + nums[j]) == target){
                    
                    return new int[]{i, j};
                }
            }
        }
        
        return null;
    }
}
