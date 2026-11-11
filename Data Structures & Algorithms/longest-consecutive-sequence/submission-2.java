class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        
        HashSet<Integer> set = new HashSet();

        for (int num : nums) {
            set.add(num);
        }

        int res = 1;

        for (int i = 0; i < nums.length; ++i) {
            if (!set.contains(nums[i] - 1)) continue;

            int num = nums[i];
            int len = 1;

            while (set.contains(num)) {
                ++len;
                ++num;
            }

            res = Math.max(res, len);
        }

        return res;
    }
}
