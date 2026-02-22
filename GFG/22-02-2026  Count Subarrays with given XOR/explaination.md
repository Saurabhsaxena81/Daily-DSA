# Time Complexity

Average Case: $O(n)$
Worst Case: $O(n^2)$

Explanation:You have a single for loop that iterates through the array exactly $n$ times.Inside the loop, you are performing basic bitwise operations (^) and interacting with a HashMap (getOrDefault and put).On average, HashMap insertions and lookups take $O(1)$ time. Because you do this $n$ times, the average time complexity is $O(n)$.Note on the worst case: In the rare event of severe hash collisions inside the Java HashMap, those $O(1)$ operations can degrade to $O(n)$, which would make the overall worst-case time complexity $O(n^2)$. However, in standard algorithmic analysis for this pattern, it is accepted as $O(n)$.

# Space Complexity

- Overall Space Complexity: $O(n)$
  Explanation:You are using an auxiliary HashMap to store the frequencies of the prefixxor values.In the worst-case scenario, every prefix XOR value generated in the loop is unique. If this happens, your HashMap will store $n + 1$ entries (the $n$ prefixes plus the initial (0L, 1L) entry).Since the size of the HashMap scales linearly with the size of the input array, the space complexity is $O(n)$.
