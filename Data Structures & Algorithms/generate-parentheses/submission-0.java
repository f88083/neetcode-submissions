class Solution {
    List<String> res;
    StringBuilder sb;
    int n;
    
    public List<String> generateParenthesis(int n) {
        res = new ArrayList();
        sb = new StringBuilder("");
        this.n = n;
        backtracking(0, 0);
        return res;
    }

    private void backtracking(int openN, int closeN) {
        if (openN == n && closeN == n) {
            res.add(sb.toString());
            return;
        }

        // When ( is not enough
        if (openN < n) {
            sb.append("(");
            backtracking(openN + 1, closeN);
            sb.deleteCharAt(sb.length() - 1);
        }

        // When ) is not enough
        if (closeN < openN) {
            sb.append(")");
            backtracking(openN, closeN + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        return;
    }
}
