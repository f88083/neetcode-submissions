class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;

        while (l < r) {
            int left = numbers[l];
            int right = numbers[r];

            if (left + right == target && left != right) {
                return new int[]{l + 1, r + 1};
            } else if (left + right > target) {
                --r;
            } else if (left + right < target) {
                ++l;
            } else {
                ++l;
            }
        }

        return new int[]{-1, -1};
    }
}
