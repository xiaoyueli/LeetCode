package design;

/**
 * Design a data structure that supports the following two operations:
 * void addWord(word)
 * bool search(word)
 * 
 * search(word) can search a literal word or 
 * a regular expression string containing only letters a-z or ".". 
 * A . means it can represent any one letter.
 * 
 * For example:
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * 
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 *
 *  字典查找树
 *  数据结构用数组，hashmap超时
 */

public class _211_AddandSearchWord_Datastructuredesign {

    // Adds a word into the data structure.
    class Node {
        char c;
        Node[] sons = new Node[26];
        boolean isWord = false;
        public Node() {
        }
        
        public Node(char c) {
            this.c = c;
        }
    }
    
    Node root = new Node();
    
    public void addWord(String word) {

        Node cur = root;
        for (char c: word.toCharArray()) {
            Node[] sons = cur.sons;
            if (sons[c - 'a'] == null) sons[c - 'a'] = new Node(c);
            cur = sons[c - 'a'];
        }
        cur.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {

        
        return dfs(word.toCharArray(), 0, root);
        
    }
    
    public boolean dfs(char[] seq, int pos, Node cur) {
        if (pos == seq.length) return cur.isWord;
        char c = seq[pos];
        Node[] sons = cur.sons;
        if (c != '.' && sons[c - 'a'] == null) return false;
        else if (c != '.') return dfs(seq, pos + 1, sons[c - 'a']);
        else {
            for (Node n : sons) {
                if (n != null && dfs(seq, pos + 1, n)) return true;
            }
            return false;
        }

    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
