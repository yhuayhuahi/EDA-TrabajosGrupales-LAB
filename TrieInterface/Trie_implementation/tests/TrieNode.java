import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TrieNode.java
public class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;
    String word;

    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
        word = null;
    }
}