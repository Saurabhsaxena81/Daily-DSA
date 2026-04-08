class Solution {
    void segregate0and1(int[] arr) {
        // code here
            int n = arr.length; 
        int s = 0, e = n-1;
        while(s < e){
            
            // avoid extra swapping if( arr[s]==(0 or 1)&& arr[e]==(0 or 1))
            // if(arr[s]==0 && arr[e]==1){     
            //     s++;
            //     e--;
            // }
            
            if(arr[s]==0)   s++;
            else if(arr[e]==1)  e--;
            else{
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }
        
    }
}
