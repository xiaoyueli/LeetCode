package bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author xiaoyue
 * 
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 * Note: The input string may contain letters other than the parentheses ( and ).
 * 
 * Examples:
 * "()())()" -> ["()()()", "(())()"]
 * "(a)())()" -> ["(a)()()", "(a())()"]
 * ")(" -> [""]
 * 
 * 思路，BFS，将整个字符串加入Q，验证是否合法，合法就加入LIST, 用boolean标记为已经找到，只出队列验证剩余的string是否合法。
 * 否则loop,逐个删除一个当前字符串括号，用一个hashset检查队列里是否已经存在该字符串。不存在入队列。
 * 
 * DFS: 计算需要删除的左括号和右括号数量，记录当前字符串，和当前char的位置，当当前char为括号的时候减去该括号，removeNum--, 或者notMatch++/--, 
 * 当前字符串 + 该括号，notmatch记录当前字符串括号是否匹配。当当前char的位置==字符串长度时候检查，removeNUM和notmatch若为0，加入当前字符串。
 *
 */

public class _301_RemoveInvalidParentheses {
    
    // dfs
    public List<String> removeInvalidParentheses(String s) {
        
        List<String> res = new ArrayList<String>();
        HashSet<String> set = new HashSet<String>();
        
        int moveLeft = 0;
        int moveRight = 0;
        char[] seq = s.toCharArray();

        for (int i = 0; i < seq.length; i++) {
            if (seq[i] == '(') moveLeft++;
            else if (seq[i] == ')') {
                if (moveLeft > 0) moveLeft--;
                else moveRight++;
            }
        }
        
        dfs(set, seq, moveLeft, moveRight, 0, 0, "");
        for (String str: set) res.add(str);
        
        return res;
        
    }
    
    private void dfs(HashSet<String> set, char[] seq, int moveLeft, int moveRight, int notMatch, int pos, String cur) {
        if (moveLeft < 0 || moveRight < 0 || notMatch < 0) return;
        if (pos == seq.length) {
            if (moveLeft == 0 && moveRight == 0 && notMatch == 0) set.add(cur);
            return;
        }
        
        if (seq[pos] == '(') {
            dfs(set, seq, moveLeft - 1, moveRight, notMatch, pos + 1, cur);
            dfs(set, seq, moveLeft, moveRight, notMatch + 1, pos + 1, cur + seq[pos]);
        }
        else if (seq[pos] == ')') {
            dfs(set, seq, moveLeft, moveRight - 1, notMatch, pos + 1, cur);
            dfs(set, seq, moveLeft, moveRight, notMatch - 1, pos + 1, cur + seq[pos]);
        }
        else dfs(set, seq, moveLeft, moveRight, notMatch, pos + 1, cur + seq[pos]);
    }
    
    // bfs
    public List<String> removeInvalidParentheses2(String s) {
        
        List<String> res = new ArrayList<String>();
        Queue<String> que = new LinkedList<String>();
        HashSet<String> set = new HashSet<String>();
        
        que.offer(s);
        boolean found = false;
        
        while (!que.isEmpty()) {
            String cur = que.poll();
            

            if (isValid(cur)) {
                res.add(cur);
                found = true;
            }
            else if (!found){
                int len = cur.length();
                for (int i = 0; i < len; i++) {
                    if (cur.charAt(i) == '(' || cur.charAt(i) == ')') {
                        String sub = cur.substring(0, i) + cur.substring(i + 1, len);
                        if (!set.contains(sub)) {
                            que.offer(sub);
                            set.add(sub);
                        }
                    }

                }
            }

        }
        
        return res;
        
    }
    
    private boolean isValid(String s) {
        
        char[] seq = s.toCharArray();
        int len = seq.length;
        int offset = 0;
        
        for (int i = 0; i < len; i++) {
            if (seq[i] == '(') offset++;
            else if (seq[i] == ')') offset--;
            if (offset < 0) return false;
        }
        
        return offset == 0;
    }

}
