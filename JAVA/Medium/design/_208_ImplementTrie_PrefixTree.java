package design;


/**
 * Implement a trie with insert, search, and startsWith methods.
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 *
 *  trie,字典查找树
 *  根节点不存字符，其他每一个结点都只存一个字符
 *  从根节点到某一个结点中间经过的字符组合起来组成完整的词语
 *  
 *  
 */

class TrieNode {
    // Initialize your data structure here.
    char val;
    boolean isWord;
    TrieNode[] next; // 也可以用hashmap
    
    public TrieNode() {
        val = ' ';
        isWord = false;
        next = new TrieNode[26];
        
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
        TrieNode cur = root;
        
        for (int i = 0; i < seq.length; i++) {
            int idx = seq[i] - 'a';
            if (cur.next[idx] == null) {
                cur.next[idx] = new TrieNode();
                cur.next[idx].val = seq[i];
            }
            
            
            if (i == seq.length - 1) cur.next[idx].isWord = true;
            else cur = cur.next[idx];
        }
        
        
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        
        char[] seq = word.toCharArray();
        TrieNode cur = root;
        
        for (int i = 0; i < seq.length; i++) {
            int idx = seq[i] - 'a';
            if (cur.next[idx] == null || cur.next[idx].val != seq[i]) return false;
            if (i == seq.length - 1 && cur.next[idx].isWord) return true;
            cur = cur.next[idx];
        }
        
        return false;
        
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        
        char[] seq = prefix.toCharArray();
        TrieNode cur = root;
        
        for (int i = 0; i < seq.length; i++) {
            int idx = seq[i] - 'a';
            if (cur.next[idx] == null || cur.next[idx].val != seq[i]) return false;
            cur = cur.next[idx];
        }
        
        return true;
        
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
