class Solution {
    public int[] twoSum(int[] nums, int target) {
        // value -> index
        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums.length; ++i) {
            int compensate = target - nums[i];

            if (map.containsKey(compensate)) 
                return new int[]{map.get(compensate), i};
            else
                map.put(nums[i], i);
        }
        return new int[2];
    }
}
