public class Solution {
    public bool IsAnagram(string s, string t) {
        if (s.Length != t.Length) return false;

        var sArr = new int[26];
        var tArr = new int[26];

        for (int i = 0; i < s.Length; ++i) {
            sArr[s[i] - 97]++;
            tArr[t[i] - 97]++;
        }

        for (int i = 0; i < 26; ++i) {
            if (sArr[i] != tArr[i]) return false;
        }

        return true;
    }
}
