// Trie.java
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the trie
    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            current.children.putIfAbsent(c, new TrieNode());
            current = current.children.get(c);
        }
        current.isEndOfWord = true;
        current.word = word;
    }

    // Search for a word in the trie
    public boolean search(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            current = current.children.get(c);
            if (current == null) {
                return false;
            }
        }
        return current.isEndOfWord;
    }

    // Check if any words in the trie start with the given prefix
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            current = current.children.get(c);
            if (current == null) {
                return false;
            }
        }
        return true;
    }

    // Find the shortest root for a given word
    public String findRoot(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (current.children.get(c) == null || current.word != null) {
                break;
            }
            current = current.children.get(c);
        }
        return current.word != null ? current.word : word;
    }
}