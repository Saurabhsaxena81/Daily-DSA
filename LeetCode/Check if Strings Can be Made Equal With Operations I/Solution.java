
class Solution {
    public boolean canBeEqual(String s1, String s2) {
        // Check if the even indices (0 and 2) match, either directly or swapped
        boolean evenMatch = (s1.charAt(0) == s2.charAt(0) && s1.charAt(2) == s2.charAt(2)) ||
                (s1.charAt(0) == s2.charAt(2) && s1.charAt(2) == s2.charAt(0));

        // Check if the odd indices (1 and 3) match, either directly or swapped
        boolean oddMatch = (s1.charAt(1) == s2.charAt(1) && s1.charAt(3) == s2.charAt(3)) ||
                (s1.charAt(1) == s2.charAt(3) && s1.charAt(3) == s2.charAt(1));

        // Both pairs must be capable of matching
        return evenMatch && oddMatch;
    }
}