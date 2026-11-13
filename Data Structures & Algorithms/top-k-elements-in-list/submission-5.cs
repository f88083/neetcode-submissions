public class Solution {
    public int[] TopKFrequent(int[] nums, int k) {

        var count = new Dictionary<int, int>();
        foreach (var num in nums) {
            if (!count.ContainsKey(num)) {
                count.Add(num, 1);
            } else {
                ++count[num];
            }
        }

        List<int[]> arr = count.Select(entry => new int[]{
            entry.Value,
            entry.Key
        }).ToList();

        arr.Sort((a, b) => b[0].CompareTo(a[0]));

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i][1];
        }

        return res;
    }
}
