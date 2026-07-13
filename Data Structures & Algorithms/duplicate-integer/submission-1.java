class Solution {
    public boolean hasDuplicate(int[] nums) {
        // int count=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                // count++;
                return true;
            }
        }
        return false;
    }
}