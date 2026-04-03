class Solution {
    static ArrayList<Integer> diagView(int mat[][]) {
        // code here
        int n = mat.length;
        ArrayList<Integer> ans = new ArrayList<>();

        // total diagonals = 2*n - 1
        for (int i = 0; i < 2 * n - 1; i++) {
            int row = (i < n) ? 0 : i - n + 1;
            int col = (i < n) ? i : n - 1;

            while (row < n && col >= 0) {
                ans.add(mat[row][col]);
                row++;
                col--;
            }
        }

        return ans;
    }
}
