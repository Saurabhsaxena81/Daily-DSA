class Solution {

    public ArrayList<String> generateIp(String s) {

        ArrayList<String> res = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();

        track(0, s, sb, res, 0, 0);
        return res;
    }

    private void track(
            int i, String s, StringBuilder sb, ArrayList<String> res,
            int cur, int dots) {

        if (dots > 3)
            return;
        if (i == s.length()) {
            String add = new String(sb);
            if (!check(add))
                return;
            res.add(add);
            return;
        }

        cur = cur * 10 + (s.charAt(i) - '0');
        if (cur <= 255) {
            sb.append(s.charAt(i));
            sb.append('.');
            // put dot
            track(i + 1, s, sb, res, 0, dots + 1);
            sb.deleteCharAt(sb.length() - 1);
            // don't put
            track(i + 1, s, sb, res, cur, dots);
            // backtrack
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private boolean check(String add) {

        String[] arr = add.split("\\.");
        if (arr.length != 4)
            return false;

        if ((arr[0].charAt(0) == '0' && arr[0].length() != 1) ||
                (arr[1].charAt(0) == '0' && arr[1].length() != 1) ||
                (arr[2].charAt(0) == '0' && arr[2].length() != 1) ||
                (arr[3].charAt(0) == '0' && arr[3].length() != 1))
            return false;

        return true;
    }
}