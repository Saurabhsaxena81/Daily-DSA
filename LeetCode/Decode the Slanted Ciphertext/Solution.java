class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();
        // Base case: if the string is empty, return it directly
        if (n == 0) {
            return "";
        }
        
        int cols = n / rows;
        StringBuilder originalText = new StringBuilder();
        
        // Iterate through each starting column of the first row
        for (int c = 0; c < cols; c++) {
            // Traverse down the diagonal
            for (int r = 0; r < rows; r++) {
                int currCol = c + r;
                
                // If the diagonal goes out of the right bound, stop this diagonal
                if (currCol >= cols) {
                    break;
                }
                
                // Map the 2D position (r, currCol) to the 1D encoded string index
                int index = r * cols + currCol;
                originalText.append(encodedText.charAt(index));
            }
        }
        
        // Remove trailing spaces added during the matrix padding process
        while (originalText.length() > 0 && originalText.charAt(originalText.length() - 1) == ' ') {
            originalText.deleteCharAt(originalText.length() - 1);
        }
        
        return originalText.toString();
    }
}