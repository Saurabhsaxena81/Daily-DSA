class Solution {
    public int minPartitions(String n) {
        int maxDigit = 0;
        
        // Loop through each character in the string
        for (int i = 0; i < n.length(); i++) {
            // Convert the character to its integer value
            int currentDigit = n.charAt(i) - '0';
            
            // Update the maximum digit found so far
            if (currentDigit > maxDigit) {
                maxDigit = currentDigit;
            }
            
            // Optimization: We can't go higher than 9, so break early if we find it
            if (maxDigit == 9) {
                break;
            }
        }
        
        return maxDigit;
    }
}