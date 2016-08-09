package breadthFirstSearch;

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
 * 单词匹配方法：A-Z替换每一位，新单词在候选列表中存在就加入Q，并从原列表删除
 *
 */

public class _127_WordLadder {
    
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        
    Queue<String> que = new LinkedList<String>();
    
    que.offer(beginWord);
    int level = 1;
    int size = 1;
    while (!que.isEmpty()) {
        
        String cur = que.poll();
        size--;
        int len = cur.length();
        for (int change = 0; change < len; change++) {
            for (char c = 'a'; c < 'z'; c++) {
                char[] str = cur.toCharArray();
                if (str[change] == c) continue;
                str[change] = c;
                String s = new String(str);
                if (wordList.contains(s)) {
                    if (s.equals(endWord)) return level + 1;
                    que.offer(s);
                    wordList.remove(s);
                }

            }
        }
        if (size == 0) {
            level++;
            size = que.size();
        }
    }
    
    return 0;
    }

}
