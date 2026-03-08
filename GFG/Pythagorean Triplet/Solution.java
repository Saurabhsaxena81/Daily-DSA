// Pythagorean Triplet
class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        // code here
           Set<Integer> set = new HashSet<>();

         // You can also take an additional array with length max(array_elements)+1     
        for(int i: arr)
          set.add(i*i);
        
        for(int i=0; i<arr.length-1;  i++){
           for(int j=i+1; j<arr.length; j++)
           
              if(set.contains(arr[i]*arr[i] + arr[j]*arr[j]))
                return true;
        }
        
        return false;
    }
}