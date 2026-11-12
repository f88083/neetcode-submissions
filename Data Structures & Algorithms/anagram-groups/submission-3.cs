public class Solution {
    public List<List<string>> GroupAnagrams(string[] strs) {
        var res = new Dictionary<string, List<string>>();

        foreach (string str in strs) {
            var freq = new int[26];

            for (int i = 0; i < str.Length; ++i) {
                ++freq[str[i] - 'a'];
            }

            // Without zero could cause 2 identical string but different content
            string freqStr = string.Join(",", freq);

            if (!res.TryGetValue(freqStr, out var group)){
                group = new List<string>();
                res[freqStr] = group;
            }

            group.Add(str);
        }

        return res.Values.ToList();
    }
}
