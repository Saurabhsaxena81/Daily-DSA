class Solution {
    public String findLargest(int[] arr) {
        // code here
        List<String> res = new ArrayList<>();

        for (int a : arr) {
            res.add(a + "");
        }

        res.sort((a, b) -> (b + a).compareTo(a + b));

        // check for whether first string is 0 or not.

        if (res.get(0).equals("0"))
            return "0";

        StringBuilder ans = new StringBuilder();

        for (String r : res)
            ans.append(r);

        return ans.toString();
    }
}

/**
 * 
 */
