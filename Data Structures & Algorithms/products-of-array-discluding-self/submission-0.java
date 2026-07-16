class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Pass 1: Calculate prefix products (left of i)
        // The first element has nothing to its left, so its prefix product is 1
        result[0] = 1; 
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        
        // Pass 2: Calculate postfix products (right of i) on the fly
        // The last element has nothing to its right, so its postfix product is 1
        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * postfix; // prefix * postfix
            postfix = postfix * nums[i];     // update postfix for the next element to the left
        }
        
        return result;
    }
}