public class Solution {

    public string Encode(IList<string> strs) {
        if (strs.Count == 0) return "";

        var sb = new StringBuilder("");
        var res = "";

        // Store sizes
        foreach (var str in strs) {
            sb.Append(str.Length).Append(',');
        }
        sb.Append('#');
        // Stroe strings
        foreach (var str in strs) {
            sb.Append(str);
        }
        return sb.ToString();
    }

    public List<string> Decode(string s) {
        if (s.Length == 0) return [];

        var sizes = new List<int>();
        var res = new List<string>();
        int i = 0;
        // Find counts
        while (s[i] != '#') {
            int j = i;
            while (s[j] != ',') {
                ++j;
            }
            sizes.Add(int.Parse(s.Substring(i, j - i)));
            i = j + 1;
        }
        i++; // Skip '#'
        // Decode
        foreach (var item in sizes) {
            res.Add(s.Substring(i, item));
            i += item;
        }
        return res;
   }
}
