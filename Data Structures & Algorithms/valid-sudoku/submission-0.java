class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet[] rows = new HashSet[9];
        HashSet[] cols = new HashSet[9];
        HashSet[][] square = new HashSet[3][3];

        // Init.
        for (int i = 0; i < 9; ++i) {
            HashSet<Character> rowSet = new HashSet();
            HashSet<Character> colSet = new HashSet();
            rows[i] = rowSet;
            cols[i] = colSet;
        }

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                HashSet<Character> squareSet = new HashSet();
                square[i][j] = squareSet;
            }
        }

        for (int r = 0; r < 9; ++r) {
            for (int c = 0; c < 9; ++c) {
                char currentChar = board[r][c];
                
                if (currentChar == '.') continue;

                // Check rows and cols and squares
                if (rows[r].contains(currentChar) ||
                    cols[c].contains(currentChar) ||
                    square[r / 3][c / 3].contains(currentChar)
                ) {
                    return false;
                }

                // Add to the sets
                rows[r].add(currentChar);
                cols[c].add(currentChar);
                square[r / 3][c / 3].add(currentChar);
            }
        }
        return true;



    }
}
