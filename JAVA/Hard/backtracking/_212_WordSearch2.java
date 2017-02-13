package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author xiaoyue
 * 
 * Given a 2D board and a list of words from the dictionary, find all words in the board.

    Each word must be constructed from letters of sequentially adjacent cell, 
    where "adjacent" cells are those horizontally or vertically neighboring. 
    The same letter cell may not be used more than once in a word.
    
    For example,
    Given words = ["oath","pea","eat","rain"] and board =
    
    [
      ['o','a','a','n'],
      ['e','t','a','e'],
      ['i','h','k','r'],
      ['i','f','l','v']
    ]
    Return ["eat","oath"].
    Note:
    You may assume that all inputs are consist of lowercase letters a-z.
 *
 */

public class _212_WordSearch2 {
    
    public List<String> findWords(char[][] board, String[] words) {
        
        List<String> res = new ArrayList<String>();
        TrieNode root = buildTrie(words);
        
        int height = board.length;
        int width = board[0].length;
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                helper(res, root, board, row, col);
            }
        }
        
        return res;
    }
    
    private void helper(List<String> res, TrieNode root, char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return;
        
        char old = board[row][col];
        if (old == '#') return;
        TrieNode node = root.sons[old - 'a'];
        if (node == null) return;
        
        board[row][col] = '#';
        
        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }
        
        helper(res, node, board, row + 1, col);
        helper(res, node, board, row - 1, col);
        helper(res, node, board, row, col + 1);
        helper(res, node, board, row, col - 1);
        board[row][col] = old;
    }
    
    private TrieNode buildTrie(String[] words) {
        
        TrieNode root = new TrieNode();
        
        for (String word: words) {
            char[] seq = word.toCharArray();
            TrieNode cur = root;
            for (int i = 0; i < seq.length; i++) {
                if (cur.sons[seq[i] - 'a'] == null) cur.sons[seq[i] - 'a'] = new TrieNode();
                cur = cur.sons[seq[i] - 'a'];
            }
            cur.word = word;
        }
        return root;
    }
    
    class TrieNode {
        TrieNode[] sons = new TrieNode[26];
        String word;
    }

}
