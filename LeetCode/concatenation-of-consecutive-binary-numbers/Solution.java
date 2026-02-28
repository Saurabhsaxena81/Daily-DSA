class Solution {
    public int concatenatedBinary(int n) {
        long result = 0;
        int MOD = 1_000_000_007;
        int length = 0; // Tracks the bit length of the current number i
        
        for (int i = 1; i <= n; i++) {
            // Check if i is a power of 2. If it is, the bit length increases by 1.
            if ((i & (i - 1)) == 0) {
                length++;
            }
            
            // Shift the current result left by 'length' bits, then append 'i'
            // We can use bitwise OR (|) instead of addition (+) for performance
            result = ((result << length) | i) % MOD;
        }
        
        return (int) result;   
    }
}