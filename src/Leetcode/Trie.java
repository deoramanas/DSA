package Leetcode;

public class Trie {
    private static TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.contains(word.charAt(i))) {
                node.put(word.charAt(i));
            }
            node = node.get(word.charAt(i));
        }

        node.setFlag();
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.contains(word.charAt(i))) {
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return node.isFlag();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!node.contains(prefix.charAt(i))) {
                return false;
            }
            node = node.get(prefix.charAt(i));

        }
        return true;
    }
}

class TrieNode {
    TrieNode[] links = new TrieNode[26];
    boolean flag = false;

    public TrieNode() {
    }

    public boolean contains(char ch) {
        return links[ch - 'a'] != null;
    }

    public void put(char ch) {
        links[ch - 'a'] = new TrieNode();
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void setFlag() {
        flag = true;
    }

    public boolean isFlag() {
        return flag;
    }
}
