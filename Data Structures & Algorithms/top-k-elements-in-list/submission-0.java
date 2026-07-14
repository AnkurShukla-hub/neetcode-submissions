
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies (where you started!)
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Create buckets where the index represents the frequency
        // nums.length + 1 handles the case where an element appears nums.length times
        List<Integer>[] buckets = new List[nums.length + 1];
        
        for (int key : map.keySet()) {
            int frequency = map.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        
        // Step 3: Gather the top k frequent elements from right to left
        int[] result = new int[k];
        int index = 0;
        
        for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    result[index++] = num;
                    if (index == k) {
                        return result;
                    }
                }
            }
        }
        
        return result;
    }
}