class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        int res = Integer.MAX_VALUE;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            // Smaller element on the right side
            if (nums[mid] > nums[nums.length - 1]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
            res = Math.min(res, nums[mid]);
        }
        return res;
    }
}
