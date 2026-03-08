class Solution {
    Set<String> set;
    int n;
    public String findDifferentBinaryString(String[] nums) {
        n = nums.length;
        set = new HashSet<>();
        for(String s:nums)
            set.add(s);
        return sol(0, "");

    }
    private String sol(int idx , String temp){
        if(temp.length() == n){
            if(set.contains(temp) == false){
                return temp;
            }
        }
        if(idx < n){
            String left= sol(idx+1, temp +'0');
            if(left!= null){
                return left;
            }
            String right = sol(idx+1  , temp+'1');
            if(right!= null){
                return right;
            }
        }
        return null;
    }
}