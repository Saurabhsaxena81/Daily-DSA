class Solution {
    public int countPrimeSetBits(int L, int R) {
        int ans = 0;
        for (int x = L; x <= R; ++x)
            if (isSmallPrime(Integer.bitCount(x)))
                ans++;
        return ans;
    }

    public boolean isSmallPrime(int x) {
        return (x == 2 || x == 3 || x == 5 || x == 7 ||
                x == 11 || x == 13 || x == 17 || x == 19);
    }
}

// Complexity Analysis
// Time Complexity: O(D), where D=R−L is the number of integers considered. In a
// bit complexity model, this would be O(DlogD) as we have to count the bits in
// O(logD) time.

// Space Complexity: O(1).