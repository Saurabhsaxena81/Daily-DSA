class Solution {
    public boolean canPartition(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        long[] rowSums = new long[m];
        long[] colSums = new long[n];
        long totalSum = 0;
        
        // Step 1: Calculate row sums, column sums, and the total sum
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                long val = grid[i][j];
                rowSums[i] += val;
                colSums[j] += val;
                totalSum += val;
            }
        }
        
        // Step 2: If the total sum is odd, it cannot be divided into two equal parts
        if (totalSum % 2 != 0) {
            return false;
        }
        
        long target = totalSum / 2;
        
        // Step 3: Check for a valid horizontal cut
        long currentSum = 0;
        // We go up to m - 1 to ensure the bottom section is non-empty
        for (int i = 0; i < m - 1; i++) { 
            currentSum += rowSums[i];
            if (currentSum == target) {
                return true;
            }
        }
        
        // Step 4: Check for a valid vertical cut
        currentSum = 0;
        // We go up to n - 1 to ensure the right section is non-empty
        for (int j = 0; j < n - 1; j++) { 
            currentSum += colSums[j];
            if (currentSum == target) {
                return true;
            }
        }
        
        // No valid cuts were found
        return false;
    }
}