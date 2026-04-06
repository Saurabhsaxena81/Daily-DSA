class Solution {
    static public class Node {
        int freq;
        int minIdx;
        Node left, right;

        public Node(int freq, int idx) {
            this.freq = freq;
            this.minIdx = idx;
            this.left = null;
            this.right = null;
        }
    }

    public ArrayList<String> huffmanCodes(String s, int f[]) {
        // Code here
        PriorityQueue<Node> pq = new PriorityQueue<Node>(
                (a, b) -> (a.freq != b.freq) ? a.freq - b.freq : a.minIdx - b.minIdx);
        for (int i = 0; i < s.length(); i++) {
            pq.add(new Node(f[i], i));
        }

        if (pq.size() == 1)
            return new ArrayList<String>(Arrays.asList("0"));

        while (pq.size() > 1) {
            Node left = pq.poll(), right = pq.poll();
            Node parent = new Node(left.freq + right.freq, Math.min(left.minIdx, right.minIdx));
            parent.left = left;
            parent.right = right;
            pq.add(parent);
        }

        ArrayList<String> res = new ArrayList<>();
        traverse(pq.poll(), "", res);
        return res;
    }

    void traverse(Node node, String code, ArrayList<String> strs) {
        if (node == null)
            return;

        if (node.left == null && node.right == null) {
            strs.add(code);
            return;
        }

        traverse(node.left, code + '0', strs);

        traverse(node.right, code + '1', strs);
    }
}