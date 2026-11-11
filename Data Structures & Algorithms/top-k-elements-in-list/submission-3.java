class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Store counts
        Map<Integer, Integer> count = new HashMap();
        // Bucket (by frequencies)
        List<Integer>[] bucket = new List[nums.length + 1];

        // Store counts
        for (int i = 0; i < nums.length; ++i) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        // Init. buckets
        for (int i = 0; i < bucket.length; ++i) {
            bucket[i] = new ArrayList();
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            // Find the bucket of the count and put in the number
            bucket[entry.getValue()].add(entry.getKey());
        }

        // Build the result
        int index = 0;
        int[] res = new int[k];
        for (int i = bucket.length - 1; i > 0 && index < k; --i) {
            for (int num : bucket[i]) {
                res[index] = num;
                ++index;
                // Result obtained
                if (index == k) return res;
            }
        }

        return res;
    }
}
