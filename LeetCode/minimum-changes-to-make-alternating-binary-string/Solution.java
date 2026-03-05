class Solution {
    public int minOperations(String s) {
        int start0 = 0;
        int start1 = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '0') {
                    start1++;
                } else {
                    start0++;
                }
            } else {
                if (s.charAt(i) == '1') {
                    start1++;
                } else {
                    start0++;
                }
            }
        }

        return Math.min(start0, start1);
    }
}

// Complexity Analysis

// Given n as the length of s,

// Time complexity: O(n)

// We iterate over each character of s once, performing O(1) work at each
// iteration.

// Space complexity: O(1)

// We aren't using any extra space other than a few integers.