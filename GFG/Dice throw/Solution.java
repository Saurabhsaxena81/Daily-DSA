class Solution {
     
    static int fun(int n, int m, int x,int [][]dp){
          
          if(x==0 && n==0)return 1;
          if(x<0 || n<0)return 0;
          
          if(dp[n][x]!=-1)return dp[n][x];
          
          int count=0;
          for(int i=1;i<=m;i++){
               count+=fun(n-1,m,x-i,dp);
          }
          
          return dp[n][x]=count;
    }
    static int noOfWays(int m, int n, int x) {
          int [][]dp=new int[n+1][x+1];
          
          dp[0][0]=1;
          
          for(int i=1;i<=n;i++){
              for(int j=1;j<=x;j++){
                    for(int k=1;k<=m;k++){
                         if(j-k>=0){
                              dp[i][j]=dp[i][j]+dp[i-1][j-k];
                         }
                    }
              }
          }
          
          return dp[n][x];   
    }
};


