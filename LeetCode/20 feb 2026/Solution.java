import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String makeLargestSpecial(String s) {
        // Base case for empty string
        if (s == null || s.length() == 0) {
            return "";
        }

        int count = 0;
        int i = 0; // Marks the start of a special substring
        List<String> substrings = new ArrayList<>();

        // Step 1: Split the string into irreducible special substrings
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '1') {
                count++;
            } else {
                count--;
            }

            // When count reaches 0, we've found a complete special substring
            if (count == 0) {
                // Step 2: Recursively sort the inside of the special substring
                // We strip the outer '1' (at index i) and '0' (at index j)
                String inner = s.substring(i + 1, j);
                String processed = "1" + makeLargestSpecial(inner) + "0";

                substrings.add(processed);
                i = j + 1; // Move the start pointer for the next substring
            }
        }

        // Step 3: Sort the substrings in descending lexicographical order
        Collections.sort(substrings, Collections.reverseOrder());

        // Join them back together
        return String.join("", substrings);
    }
}

// //Complexity Analysis
// Time Complexity: O(N^2logN) where N is the length of the string. In the worst
// case, we are creating substrings and sorting them at each recursive level.
// Because the maximum string length is only 50, this will execute in a fraction
// of a millisecond.

// Space Complexity: O(N) to store the recursive call stack and the substring
// lists at each level.