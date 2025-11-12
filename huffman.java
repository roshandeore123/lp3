import java.util.PriorityQueue;

public class HuffmanExample {

    // static nested class for nodes
    static class HuffmanNode implements Comparable<HuffmanNode> {
        int freq;
        String symbol;
        HuffmanNode left, right;

        HuffmanNode(int freq, String symbol) {
            this.freq = freq;
            this.symbol = symbol;
        }

        HuffmanNode(int freq, String symbol, HuffmanNode left, HuffmanNode right) {
            this.freq = freq;
            this.symbol = symbol;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(HuffmanNode other) {
            return Integer.compare(this.freq, other.freq);
        }

        boolean isLeaf() {
            return left == null && right == null;
        }
    }

    // Recursively traverse the tree and print codes
    private static void printCodes(HuffmanNode node, String code) {
        if (node == null) return;

        if (node.isLeaf()) {
            // If only one symbol exists, ensure at least one bit
            System.out.println(node.symbol + " -> " + (code.isEmpty() ? "0" : code));
            return;
        }

        printCodes(node.left, code + "0");
        printCodes(node.right, code + "1");
    }

    public static void main(String[] args) {
        // characters and their frequencies (same as your Python example)
        String[] chars = {"a", "b", "c", "d", "e", "f"};
        int[] freq =     {  5,   9,  12,  13,  16,  45};

        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();
        for (int i = 0; i < chars.length; i++) {
            pq.add(new HuffmanNode(freq[i], chars[i]));
        }

        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();
            HuffmanNode parent = new HuffmanNode(left.freq + right.freq, left.symbol + right.symbol, left, right);
            pq.add(parent);
        }

        HuffmanNode root = pq.peek();
        printCodes(root, "");
    }
}
