import java.util.PriorityQueue;
import java.util.Scanner;

// Node class representing each character and its frequency
class Node implements Comparable<Node> {
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
        this.left = this.right = null;
    }

    // Compare based on frequency (for priority queue)
    public int compareTo(Node n) {
        return this.freq - n.freq;
    }
}

public class HuffmanCoding {

    // Recursive function to print Huffman codes from root
    static void printCodes(Node root, String code) {
        if (root == null)
            return;

        // If leaf node, print character and its code
        if (root.left == null && root.right == null) {
            System.out.println(root.ch + " : " + code);
            return;
        }

        // Traverse left and right
        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    // Build Huffman Tree using Greedy method
    static void buildHuffmanTree(char[] chars, int[] freq, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // Step 1: Create leaf nodes and add to priority queue
        for (int i = 0; i < n; i++) {
            pq.add(new Node(chars[i], freq[i]));
        }

        // Step 2: Combine two smallest nodes until one tree remains
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();

            Node newNode = new Node('-', left.freq + right.freq);
            newNode.left = left;
            newNode.right = right;

            pq.add(newNode);
        }

        // Step 3: Print the Huffman Codes by traversing the tree
        Node root = pq.peek();
        System.out.println("\nHuffman Codes for the given characters are:");
        printCodes(root, "");
    }

    // Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();

        char[] chars = new char[n];
        int[] freq = new int[n];

        System.out.println("Enter characters and their frequencies:");
        for (int i = 0; i < n; i++) {
            System.out.print("Character " + (i + 1) + ": ");
            chars[i] = sc.next().charAt(0);
            System.out.print("Frequency of " + chars[i] + ": ");
            freq[i] = sc.nextInt();
        }

        buildHuffmanTree(chars, freq, n);

        sc.close();
    }
}