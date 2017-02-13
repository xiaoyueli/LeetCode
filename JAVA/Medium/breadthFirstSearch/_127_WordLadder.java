package breadthFirstSearch;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), 
 * and a dictionary's word list, 
 * find the length of shortest transformation sequence from beginWord to endWord, 
 * such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the word list
 * 
 * For example,
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * 
 * #
 * BFS, 将匹配的单词从候选单词中删除
 * Dijkstra's algorithm
 *
 */

public class _127_WordLadder {
    
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        
        HashSet<String> begin = new HashSet<String>();
        begin.add(beginWord);
        int level = 1;
        
        while (!wordList.isEmpty() && !begin.isEmpty()) {

            HashSet<String> temp = new HashSet<String>(); 
            for (String cur: begin) {
                char[] seq = cur.toCharArray();
                
                for (char i = 'a'; i <= 'z'; i++) {
                    for (int j = 0; j < cur.length(); j++) {
                        if (seq[j] == i) continue;
                        
                        char old = seq[j];
                        seq[j] = i;
                        String word = new String(seq);
                        seq[j] = old;
                        
                        if (word.equals(endWord)) return level + 1;
                        if (wordList.contains(word)) {
                            temp.add(word);
                            wordList.remove(word);
                        }
                    }
                }
                
            }
            
            level++;
            begin = temp;
        }
        
        return 0;
    }

}
