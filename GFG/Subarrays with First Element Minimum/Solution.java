class Solution {
    public int countSubarrays(int[] arr) {
        // code here
         int n = arr.length;
        int totalCount = 0;
        Stack<Integer> stack = new Stack<>();
        int[] nextSmaller = new int[n];
        
        for (int i = 0; i < n; i++) nextSmaller[i] = n;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                nextSmaller[stack.pop()] = i;
            }
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            totalCount += (nextSmaller[i] - i);
        }

        return totalCount;
    }
}
