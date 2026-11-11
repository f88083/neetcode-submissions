class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder("");
        for (String str : strs) {
            int len = str.length();

            sb.append(len);
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList();

        int len = 0;

        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);

            if (c >= 48 && c <= 57) {
                len = (len * 10) + (c - 48);
            } else if (c == '#') {
                StringBuilder sb = new StringBuilder("");
                for (int j = 1; j <= len; ++j) {
                    sb.append(str.charAt(i + j));
                }
                res.add(sb.toString());
                i += len;
                len = 0;
            }
        }

        return res;
    }
}
