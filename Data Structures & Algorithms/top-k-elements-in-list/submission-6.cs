public class Solution {
    public int[] TopKFrequent(int[] nums, int k) {

        var count = new Dictionary<int, int>();
        var freq = new List<int>[nums.Length + 1];

        for (int i = 0; i < freq.Length; i++) {
            freq[i] = new List<int>();
        }

        foreach (var num in nums) {
            if (!count.ContainsKey(num)) {
                count.Add(num, 1);
            } else {
                ++count[num];
            }
        }

        foreach (var item in count) {
            freq[item.Value].Add(item.Key);
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = freq.Length - 1; i >= 0; i--) {
            foreach (var item in freq[i]) {
                res[index] = item;
                ++index;
                if (index == k) return res;
            }
        }

        return res;
    }
}
