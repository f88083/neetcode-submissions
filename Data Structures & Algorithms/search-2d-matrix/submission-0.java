class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        final int ROWS = matrix.length, COLS = matrix[0].length;

        int l = 0, r = ROWS * COLS - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            int row = mid / COLS, col = mid % COLS;
            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}
