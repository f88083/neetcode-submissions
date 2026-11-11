class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        backtrack(nums, new ArrayList<Integer>(), 0);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> elements, int index) {
        res.add(new ArrayList<>(elements));

        for (int i = index; i < nums.length; ++i) {
            elements.add(nums[i]);
            backtrack(nums, elements, i + 1);
            elements.remove(elements.size() - 1);
        }
    }
}
