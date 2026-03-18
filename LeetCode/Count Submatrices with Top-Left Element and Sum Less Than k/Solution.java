class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Array to store the prefix sums of the previous row
        int[] prevSums = new int[n];
        int count = 0;
        
        // Tracks the maximum valid columns we need to check. 
        // If a sum exceeds k at column j, we never need to check past j in future rows.
        int validCols = n; 
        
        for (int i = 0; i < m; i++) {
            int currentRowSum = 0;
            
            for (int j = 0; j < validCols; j++) {
                currentRowSum += grid[i][j];
                
                // Total submatrix sum = (Current row's prefix sum) + (Submatrix sum directly above)
                int totalSum = currentRowSum + prevSums[j];
                
                if (totalSum <= k) {
                    count++;
                    prevSums[j] = totalSum; // Save this sum for the next row to use
                } else {
                    validCols = j; // Prune columns for future rows
                    break;
                }
            }
        }
        
        return count;
    }
}



