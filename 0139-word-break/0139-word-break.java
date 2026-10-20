import java.util.*;

class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    TrieNode root;

    public void insert(String word) {
        TrieNode curr = root;

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }

            curr = curr.children[idx];
        }

        curr.isEnd = true;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        root = new TrieNode();

        for (String word : wordDict) {
            insert(word);
        }

        Boolean[] dp = new Boolean[s.length()];

        return search(s, 0, dp);
    }

    public boolean search(String s, int start, Boolean[] dp) {
        if (start == s.length()) {
            return true;
        }

        if (dp[start] != null) {
            return dp[start];
        }

        TrieNode curr = root;

        for (int i = start; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                break;
            }

            curr = curr.children[idx];

            if (curr.isEnd && search(s, i + 1, dp)) {
                return dp[start] = true;
            }
        }

        return dp[start] = false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna