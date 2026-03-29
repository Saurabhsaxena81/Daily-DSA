class Solution {
    public int countPartitions(int[] arr, int diff) {
        int totalSum = 0;
        for (int i : arr) {
            totalSum += i;
        }
        
        // BIT MANIPULATION 1: Checking for odd/even.
        // Bitwise AND with 1 checks the least significant bit.
        // We just add "== 1" to satisfy Java's boolean requirement.
        if (totalSum - diff < 0 || ((totalSum + diff) & 1) == 1) {
            return 0;
        }
        
        // BIT MANIPULATION 2: Dividing by 2.
        // A bitwise right shift (>> 1) mathematically halves the integer.
        int target = (totalSum + diff) >> 1;
        
        int[] dp = new int[target + 1];
        int MOD = 1000000007;
        
        dp[0] = 1;
        
        for (int num : arr) {
            for (int j = target; j >= num; j--) {
                dp[j] = (dp[j] + dp[j - num]) % MOD; 
            }
        }
        
        return dp[target];
    }
}