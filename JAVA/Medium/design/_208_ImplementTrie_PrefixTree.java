package design;

import java.util.HashMap;

/**
 * Implement a trie with insert, search, and startsWith methods.
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 *
 *  trie,字典查找树
 *  根节点不存字符，其他每一个结点都只存一个字符
 *  从根节点到某一个结点中间经过的字符组合起来组成完整的词语
 */

class TrieNode {
    // Initialize your data structure here.
    char val;
    boolean isWord;
    HashMap<Character, TrieNode> children;
    
    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
    }
    public TrieNode(char c) {
        val = c;
        isWord = false;
        children = new HashMap<Character, TrieNode>();
    }
}

public class _208_ImplementTrie_PrefixTree {
    private TrieNode root;

    public _208_ImplementTrie_PrefixTree() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        char[] seq = word.toCharArray();
        int len =seq.length;
        TrieNode cur = root;
        for (int idx = 0; idx < len; idx++) {
            HashMap<Character, TrieNode> son = cur.children;
            char c = seq[idx];
            if (!son.containsKey(c)) son.put(c, new TrieNode(c));
            cur = son.get(c);
        }
        cur.isWord = true;
        
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        char[] seq = word.toCharArray();
        int len = seq.length;
        TrieNode cur = root;
        for (int idx = 0; idx < len; idx++) {
            HashMap<Character, TrieNode> son = cur.children;
            char c = seq[idx];
            if (!son.containsKey(c)) return false;
            cur = son.get(c);
        }
        return cur.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        char[] seq = prefix.toCharArray();
        int len = seq.length;
        TrieNode cur = root;
        for (int idx = 0; idx < len; idx++) {
            HashMap<Character, TrieNode> son = cur.children;
            char c = seq[idx];
            if (!son.containsKey(c)) return false;
            cur = son.get(c);
        }
        
        return true;
        
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
