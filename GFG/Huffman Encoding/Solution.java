class Solution {

    class Node {
        char ch;
        int freq;
        Node left, right;

        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public ArrayList<String> huffmanCodes(String S, int f[]) {

        int N = S.length(); // FIX: calculate N here

        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> a.freq - b.freq
        );

        // Create nodes
        for (int i = 0; i < N; i++) {
            pq.add(new Node(S.charAt(i), f[i]));
        }

        // Build Huffman Tree
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();

            Node newNode = new Node('$', left.freq + right.freq);
            newNode.left = left;
            newNode.right = right;

            pq.add(newNode);
        }

        Node root = pq.poll();

        ArrayList<String> result = new ArrayList<>();
        generateCodes(root, "", result);

        return result;
    }

    void generateCodes(Node root, String code, ArrayList<String> res) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            res.add(code);
            return;
        }

        generateCodes(root.left, code + "0", res);
        generateCodes(root.right, code + "1", res);
    }
}