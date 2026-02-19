class Solution {
    public ArrayList<Integer> missingRange(int[] arr, int low, int high) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr)
            set.add(i);
        for (int i = low; i <= high; ++i) {
            if (!set.contains(i))
                ans.add(i);
        }
        return ans;
    }
}

/**
 * Complexity Analysis
 * Time Complexity: O(N), where N is the length of s. Every loop is through O(N)
 * items with O(1) work inside the for-block.
 * 
 * Space Complexity: O(N), the space used by groups.
 */