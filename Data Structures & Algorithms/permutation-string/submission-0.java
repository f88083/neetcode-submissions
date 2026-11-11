class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Arr = new int[26];

        Arrays.fill(s1Arr, 0);

        for (char c : s1.toCharArray()) {
            s1Arr[c - 'a']++;
        }

        int s1Size = s1.length();

        int[] s2Arr = new int[26];
        Arrays.fill(s2Arr, 0);

        for (int i = 0; i < s2.length(); ++i) {
            s2Arr[s2.charAt(i) - 'a']++;

            if (i >= s1Size - 1) {
                if (Arrays.equals(s1Arr, s2Arr)) return true;
                // Eject the window in s2
                s2Arr[s2.charAt(i - s1Size + 1) - 'a']--;
            }
        }

        return false;
    }
}
