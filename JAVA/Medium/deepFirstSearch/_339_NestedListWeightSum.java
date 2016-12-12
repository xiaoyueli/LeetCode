package deepFirstSearch;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author xiaoyue
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

    Each element is either an integer, or a list -- whose elements may also be integers or other lists.
    
    Example 1:
    Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)
    
    Example 2:
    Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)
 * 
 * 思路：
 * 1.递归
 * 2.迭代用que bfs
 */

public class _339_NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {  
        
        int sum = 0;
        for (NestedInteger nl: nestedList) {
            Queue<NestedInteger> que = new LinkedList<NestedInteger>();
            que.offer(nl);
            int size = 1;
            int level = 1;
            while (!que.isEmpty()) {
                NestedInteger cur = que.poll();
                size--;
                if (cur.isInteger()) sum += cur.getInteger() * level;
                else {
                    for (NestedInteger sub : cur.getList()) que.offer(sub);
                }
                if (size == 0) {
                    size = que.size();
                    level++;
                }
            }

        }
        
        return sum;
        
        // return helper(nestedList, 1);
        
    }
    
    private int helper(List<NestedInteger> list, int level) {
        
        int sum = 0;
        for (NestedInteger nl: list) {
            if (nl.isInteger()) sum += nl.getInteger() * level;
            else sum += helper(nl.getList(), level + 1);
        }
        
        return sum;
    }
    
    // test case [1,[2,[9]],[3,[4,[5]]]];
    // level 1
    // 1  sum += 1
    // level 2
    // [2,[9]]
    // 2 sum += 2 * 2
    // 9 sum += 9 * 3;
    // level 2
    // [3, [4,[5]]]
    // 3 sum += 3 * 2;
    // 4 sum += 4 * 3;
    // 5 sum += 5 * 4;
    // sum = 70
    
}
