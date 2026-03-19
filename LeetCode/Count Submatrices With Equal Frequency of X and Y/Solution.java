class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int validSubmatrices = 0;
        
        // 1D arrays to store the accumulated column sums for 'X' and 'Y'
        int[] countX = new int[cols];
        int[] countY = new int[cols];
        
        for (int r = 0; r < rows; r++) {
            // Keep track of counts for the current row as we move right
            int rowPrefixX = 0;
            int rowPrefixY = 0;
            
            for (int c = 0; c < cols; c++) {
                // Update row prefix sums
                if (grid[r][c] == 'X') {
                    rowPrefixX++;
                } else if (grid[r][c] == 'Y') {
                    rowPrefixY++;
                }
                
                // Add current row's counts to the accumulated column counts
                // This gives us the total count for the submatrix from (0,0) to (r,c)
                countX[c] += rowPrefixX;
                countY[c] += rowPrefixY;
                
                // Check if the current submatrix is valid
                if (countX[c] > 0 && countX[c] == countY[c]) {
                    validSubmatrices++;
                }
            }
        }
        
        return validSubmatrices;
    }
}

