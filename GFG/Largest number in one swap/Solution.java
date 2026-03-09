class Solution {
    public String largestSwap(String S) {
        // code here
        char s[] = S.toCharArray();
        int ind = s.length - 1;

        int pair[] = { -1, -1 };

        for (int i = s.length - 1; i >= 0; i--) {
            if (s[i] > s[ind]) {
                ind = i;
            } else if (s[i] < s[ind]) {
                pair[0] = i;
                pair[1] = ind;
            }
        }

        if (pair[0] == -1)
            return S;

        char c = s[pair[0]];
        s[pair[0]] = s[pair[1]];
        s[pair[1]] = c;

        return new String(s);
    }
}

/*
 * Overview of the LogicTo make a number as large as possible using exactly one
 * swap, you want to:Find a smaller digit on the left side.Swap it with the
 * largest possible digit on the right side.If there are multiple large digits
 * on the right, you want to use the one furthest to the right.This code
 * achieves this in a single, clever pass by iterating through the string from
 * right to left.Step-by-Step ExplanationInitialization:char s[] =
 * S.toCharArray();: Converts the input string into a character array so that
 * you can easily modify it (since strings in Java are immutable).int ind =
 * s.length - 1;: This variable tracks the index of the largest character seen
 * so far. It starts at the last index.int pair[] = {-1, -1};: This array will
 * store the indices of the two characters you eventually want to swap. pair[0]
 * will be the index of the smaller left digit, and pair[1] will be the index of
 * the larger right digit.The Right-to-Left Traversal:The for loop iterates from
 * the end of the array to the beginning (i = s.length - 1 down to 0).if(s[i] >
 * s[ind]): If the current character is strictly greater than the maximum
 * character seen so far, it updates ind = i. This means it has found a new
 * "largest digit" candidate to swap other smaller digits with.else if(s[i] <
 * s[ind]): If the current character is smaller than the maximum character seen
 * so far (s[ind]), it records a potential swap by updating pair[0] = i and
 * pair[1] = ind.Why iterate right-to-left? Because by moving backwards,
 * whenever you find a smaller digit (s[i]), you already know the index of the
 * largest digit to its right (ind). By continuing all the way to index 0, the
 * pair[0] gets continuously updated to the leftmost possible smaller digit,
 * which guarantees the maximum increase in the number's value when
 * swapped.Executing the Swap:if(pair[0] == -1) return S;: If the loop finishes
 * and pair[0] is still -1, it means no smaller digit was ever found to the left
 * of a larger digit. The digits are already sorted in descending order (e.g.,
 * "9876"), which is already the maximum possible value. It returns the original
 * string.If a valid pair is found, it uses a temporary variable c to swap
 * s[pair[0]] and s[pair[1]].Returning the Result:return new String(s);:
 * Converts the modified character array back into a string and returns it.Dry
 * Run ExampleLet's trace the code with S = "2736":s = ['2', '7', '3',
 * '6']Initial ind = 3 (character '6')pair = {-1, -1}Iteration 1 (i = 3): s[3]
 * ('6') is not > or < s[ind] ('6'). Nothing happens.Iteration 2 (i = 2): s[2]
 * ('3') < s[ind] ('6').Update pair = {2, 3}.Iteration 3 (i = 1): s[1] ('7') >
 * s[ind] ('6').Update ind = 1 (We found a new largest digit).Iteration 4 (i =
 * 0): s[0] ('2') < s[ind] ('7').Update pair = {0, 1}. (This overwrote the
 * previous pair, prioritizing the leftmost digit).Loop ends. It swaps indices 0
 * and 1 ('2' and '7').Result: "7236".Complexity AnalysisTime Complexity:
 * $O(N)$Where $N$ is the length of the string S. The algorithm only requires a
 * single pass through the character array (the for loop). The operations inside
 * the loop are all constant time $O(1)$ operations (comparisons and
 * assignments).Space Complexity: $O(N)$The algorithm creates a new character
 * array s[] of the same length as the input string to perform the swap, which
 * requires $O(N)$ auxiliary space.
 * 
 */