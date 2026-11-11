public class Solution {
    public int[] TwoSum(int[] nums, int target) {
        Dictionary<int, int> map = new();

        for (int i = 0; i < nums.Length; ++i) {
            int comp = target - nums[i];
            
            if (map.ContainsKey(comp)) {
                return [map[comp], i];
            } else {
                map.Add(nums[i], i);
            }
        }

        return [-1,-1];
    }
}
