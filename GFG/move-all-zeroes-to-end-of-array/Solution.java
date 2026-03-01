class Solution {
    void pushZerosToEnd(int[] arr) {
        // code here
           int n = arr.length;
        int i = 0;
        int j = 0;
        
        while((i < n) && (j < n)){
            while(i < n && arr[i] != 0){ // finds first zero from the left 
                i++;
            }
            j = i;
            while(j < n && arr[j] == 0){ // after finding first zero finds next non-zero element
                j++;
            }
            if(i < n && j < n){ // swap them and assure their relative order
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
}