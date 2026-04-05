class Solution 
{
    HashMap<String,Integer> dp;
    int[] arr;
    int target;
    private int solve(int i,int sum)
    {
        int n=arr.length;
        
        if(i==n)
        {
            if(sum==target)return 1;
            return 0;
        }
        
        String key=i+"$"+sum;
        if(dp.containsKey(key))return dp.get(key);
        
        int ans=solve(i+1,sum+arr[i])+solve(i+1,sum-arr[i]);
        dp.put(key,ans);
        
        return ans;
    }
    public int totalWays(int[] arr, int target) {
        // code here
        dp=new HashMap<>();
        
        this.arr=arr;
        this.target=target;
        
        return solve(0,0);
    }
}