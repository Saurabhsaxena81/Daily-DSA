class Solution {
    public int countIncreasing(int[] arr) {
        // code here
        int ans=0;
        int count=1;
        
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1]){
                 count++;
            }
            else{
                if(count>=2){
                    ans=ans+(count*(count-1))/2;
                }
                count=1;
            }
        }
        
        if(count>=2){
            ans=ans+(count*(count-1))/2;
        }
        
        return ans;
    }
}

