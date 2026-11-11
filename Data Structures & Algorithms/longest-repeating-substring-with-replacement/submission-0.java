class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0, res = 0;

        int[] count = new int[26];

        for (int j = 0; j < s.length(); ++j) {
            count[s.charAt(j) - 'A']++;

            while ((j - i + 1 - maxVal(count)) > k) {
                count[s.charAt(i) - 'A']--;
                ++i;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }

    private int maxVal(int[] arr) {
        int res = -1;
        for (int num : arr) {
            res = Math.max(num, res);
        }
        return res;
    }
}
