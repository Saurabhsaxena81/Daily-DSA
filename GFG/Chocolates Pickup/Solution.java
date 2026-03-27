class Solution {
    public int maxChocolate(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int dp[][] = new int[m][m];

        for(int j1 = 0; j1 < m; j1++){
            for(int j2 = 0; j2 < m; j2++){
                if(j1 == j2) dp[j1][j2] = grid[n-1][j1];
                else dp[j1][j2] = grid[n-1][j1] + grid[n-1][j2];
            }
        }

        for(int i = n-2; i >= 0; i--){
            int curr[][] = new int[m][m];

            for(int j1 = 0; j1 < m; j1++){
                for(int j2 = 0; j2 < m; j2++){
                    int max = Integer.MIN_VALUE;

                    for(int dj1 = -1; dj1 <= 1; dj1++){
                        for(int dj2 = -1; dj2 <= 1; dj2++){
                            int value;

                            if(j1 == j2) value = grid[i][j1];
                            else value = grid[i][j1] + grid[i][j2];

                            if(j1 + dj1 >= 0 && j1 + dj1 < m &&
                               j2 + dj2 >= 0 && j2 + dj2 < m){
                                value += dp[j1 + dj1][j2 + dj2];
                            } else {
                                value += -(int)1e8;
                            }

                            max = Math.max(max, value);
                        }
                    }

                    curr[j1][j2] = max;
                }
            }
            dp = curr;
        }

        return dp[0][m-1];
    }
}

