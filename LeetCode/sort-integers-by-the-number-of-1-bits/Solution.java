// sort-integers-by-the-number-of-1-bits

class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Comparator<Integer> comparator = new CustomComparator();
        Arrays.sort(nums, comparator);
        return Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
    }
}

class CustomComparator implements Comparator<Integer> {
    private int findWeight(int num) {
        int mask = 1;
        int weight = 0;

        while (num > 0) {
            if ((num & mask) > 0) {
                weight++;
                num ^= mask;
            }

            mask <<= 1;
        }

        return weight;
    }

    @Override
    public int compare(Integer a, Integer b) {
        if (findWeight(a) == findWeight(b)) {
            return a - b;
        }

        return findWeight(a) - findWeight(b);
    }
}

/*
 * Complexity Analysis
 * 
 * Given n as the length of arr,
 * 
 * Time complexity: O(n⋅logn)
 * 
 * Finding the hamming weight of a number is dependent on the size of a number,
 * but as we are dealing with integers that have a fixed size (31 bits), we can
 * consider it as an O(1) operation. Sorting arr costs O(n⋅logn).
 * 
 * Space Complexity: O(logn) or O(n)
 * 
 * The space complexity of the sorting algorithm depends on the implementation
 * of each programming language:
 * 
 * In Java, Arrays.sort() for primitives is implemented using a variant of the
 * Quick Sort algorithm, which has a space complexity of O(logn)
 * In C++, the sort() function provided by STL uses a hybrid of Quick Sort, Heap
 * Sort and Insertion Sort, with a worst case space complexity of O(logn)
 * In Python, the sort() function is implemented using the Timsort algorithm,
 * which has a worst-case space complexity of O(n)
 */