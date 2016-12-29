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
    
    class TreeNode {
        
        char val;
        TreeNode[] sons;
        boolean isWord;
        
        public TreeNode(char val) {
            this.val = val;
            sons = new TreeNode[26];
        }
        
        public TreeNode getSon(char val) {
            return sons[val - 'a'];
        }
        
        public void addSon(char val) {
            sons[val - 'a'] = new TreeNode(val);
        }
        
        public void setWord(boolean val) {
            isWord = val;
        }
        
        public boolean isWord() {
            return isWord;
        }
        
        public TreeNode[] getSons() {
            return sons;
        }
        
    }
    

    private TreeNode root;
    
    public _211_AddandSearchWord_Datastructuredesign() {
        root = new TreeNode(' ');
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        
        char[] seq = word.toCharArray();
        TreeNode cur = root;
        for (char val: seq) {
            if (cur.getSon(val) == null) cur.addSon(val);
            cur = cur.getSon(val);
        }
        cur.setWord(true);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        
        return helper(root, word);
    }
    
    private boolean helper(TreeNode node, String word) {
        
        if (word.length() == 0) return node.isWord();
        
        if (word.charAt(0) == '.') {
            for (TreeNode son: node.getSons()) {
                if (son != null && helper(son, word.substring(1))) return true;
            }
            return false;
        }
        
        TreeNode son = node.getSon(word.charAt(0));
        if (son == null) return false;
        return helper(son, word.substring(1));
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
