// Complexity Analysis
// Time Complexity: O(N) where N is the length of the string s. We iterate through the string exactly once. The bitwise operations and array lookups take O(1) time.
// Space Complexity: O(2^k).
//  We create a boolean array of size 2 ^ k
//  . In the worst-case scenario (k=20), this array takes roughly 1 MB of memory, which is well within standard limits and vastly more efficient than storing hundreds of thousands of individual String objects in a HashSet.
class Solution {
    public boolean hasAllCodes(String s, int k) {
        // Total number of unique binary codes of length k is 2^k
        int need = 1 << k;

        // Boolean array to track which codes we have seen
        boolean[] seen = new boolean[need];
        int count = 0;
        int hash = 0;

        // A mask to keep the rolling hash exactly k bits long
        int allOnes = need - 1;

        for (int i = 0; i < s.length(); i++) {
            // Shift hash left by 1, apply mask to remove the oldest bit,
            // and add the new bit from the string
            hash = ((hash << 1) & allOnes) | (s.charAt(i) - '0');

            // Wait until our rolling window has gathered exactly k bits
            if (i >= k - 1) {
                // If we haven't seen this binary code before, mark it and increment count
                if (!seen[hash]) {
                    seen[hash] = true;
                    count++;

                    // If we found all required codes, we can exit early
                    if (count == need) {
                        return true;
                    }
                }
            }
        }

        // If we finished the string and haven't found all combinations
        return false;
    }
}