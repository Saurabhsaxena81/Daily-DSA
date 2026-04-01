class Solution {
    public int countStrings(int n) {
        if (n == 1) return 2;

        int prev0 = 1, prev1 = 1;
        int curr0 = 0, curr1 = 0;

        for (int i = 2; i <= n; i++) {
            curr0 = prev0 + prev1;
            curr1 = prev0;

            prev0 = curr0;
            prev1 = curr1;
        }

        return prev0 + prev1;
    }
}