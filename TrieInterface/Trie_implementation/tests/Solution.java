import java.util.List;

// Solution.java
public class Solution {
    public String replaceWords(List<String> roots, String sentence) {
        Trie trie = new Trie();

        // Insert all the roots into the Trie
        for (String root : roots) {
            trie.insert(root);
        }

        StringBuilder ans = new StringBuilder();

        // Replace words in the sentence using the roots from the Trie
        for (String word : sentence.split("\\s+")) {
            if (ans.length() > 0) {
                ans.append(" ");
            }
            ans.append(trie.findRoot(word));
        }
        return ans.toString();
    }
}