public int hIndex{
       int n = citations.length;
        
         1. Sort in descending order
        Arrays.sort(citations);               ascending
         reverse logic by iterating from end
        
        int h = 0;
         i from n-1 down to 0, count = number of papers considered = n - i
        for (int i = n - 1; i = 0; i--) {
            int papersCount = n - i;          so far kitne papers liye
            if (citations[i] = papersCount) {
                h = papersCount;             H itna ho sakta hai
            } else {
                break;                       aage wale chhote honge, to fail hi karenge
            }
        }
        return h;
    }

// Here is the optimized O(N) solution using the Counting Sort (Bucket Sort) approach.
public int hIndex(int[] citations) {
    int n = citations.length;
    int[] buckets = new int[n + 1];
    
    // 1. Distribute citations into buckets
    for (int c : citations) {
        if (c >= n) {
            buckets[n]++;
        } else {
            buckets[c]++;
        }
    }
    
    // 2. Iterate backwards to find the H-Index
    int papersCount = 0;
    for (int i = n; i >= 0; i--) {
        papersCount += buckets[i]; // Accumulate papers with at least 'i' citations
        if (papersCount >= i) {
            return i;              // We found the H-Index!
        }
    }
    
    return 0;
}