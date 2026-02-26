public class Solution {

    public int numSteps(String s) {
        int N = s.length();

        int operations = 0;
        int carry = 0;
        for (int i = N - 1; i > 0; i--) {
            int digit = Character.getNumericValue(s.charAt(i)) + carry;

            if (digit % 2 == 1) {
                operations += 2;
                carry = 1;
            } else {
                operations++;
            }
        }

        return operations + carry;
    }
}

/*
Complexity Analysis
Here, N is the size of the string s.

Time complexity: O(N).

We are iterating over each character of the string only once and hence the time complexity is equal to O(N).

Space complexity: O(1)

No extra space is required other than the few variables operations and carry. Hence the time complexity is constant.
 */