class Solution {
    public static int solve(Node root,int moves[]){
        if(root == null) return 0;
        
        int l = solve(root.left,moves);
        int r = solve(root.right,moves);
        int totalCan=(l+r+root.data)-1;
        moves[0] += Math.abs(l)+Math.abs(r);
        return totalCan;
        
    }
    public int distCandy(Node root) {
        // code here
        if(root == null || (root.left == null && root.right == null)) return 0;
        
        int moves[]={0};
        solve(root,moves);
        return moves[0];
    }
}