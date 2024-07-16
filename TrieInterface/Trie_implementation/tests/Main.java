// Main.java
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<String> or = new ArrayList<>();
        or.add("cat");
        or.add("bat");
        or.add("rat");
        
        List<String> roots = or;//Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";

        Solution solution = new Solution();
        String replacedSentence = solution.replaceWords(roots, sentence);

        System.out.println("Original Sentence: " + sentence);
        System.out.println("Replaced Sentence: " + replacedSentence);

        Trie mytrie = new Trie();
        mytrie.insert("let");

        System.out.println(mytrie.search("let"));
    }
}