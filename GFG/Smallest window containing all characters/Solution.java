class Solution {
    public static String minWindow(String s, String p) {
        if (s == null || p == null) return "";
        int n = s.length(), m = p.length();
        if (m > n) return "";

        int[] need = new int[128];
        for (int i = 0; i < m; i++) need[p.charAt(i)]++;

        int have = 0;              
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;

        for (int right = 0; right < n; right++) {
            char rc = s.charAt(right);
       
            need[rc]--;
            
            if (need[rc] >= 0) have++;

            while (have == m) {
                int windowLen = right - left + 1;
                if (windowLen < minLen) {
                    minLen = windowLen;
                    minLeft = left;
                }

                char lc = s.charAt(left++);
             
                need[lc]++;
               
                if (need[lc] > 0) have--;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}