/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
     public int countAllPaths(Node root, int k) {

      int[]cnt={0};

     Map<Integer,Integer>mpp=new HashMap<>();

     mpp.put(0,1);

      solve(root,k,mpp,0,cnt);

      return cnt[0];

    }

    private void solve(Node root,int k,Map<Integer,Integer>mpp,int sum,int[]cnt){

        if(root==null) return;

        sum+=root.data;

        if(mpp.containsKey(sum-k))

        cnt[0]+=mpp.get(sum-k);

        mpp.put(sum,mpp.getOrDefault(sum,0)+1);

        solve(root.left,k,mpp,sum,cnt);

        solve(root.right,k,mpp,sum,cnt);

        mpp.put(sum,mpp.get(sum)-1);
    }
}