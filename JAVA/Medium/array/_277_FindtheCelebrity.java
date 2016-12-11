package array;

/**
 * 
 * @author xiaoyue
 * Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. 
 * The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.
 * 
 * Now you want to find out who the celebrity is or verify that there is not one. 
 * The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. 
 * You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
 * 
 * You are given a helper function bool knows(a, b) which tells you whether A knows B. 
 * Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.
 * 
 * Note: There will be exactly one celebrity if he/she is in the party. 
 * Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return -1.
 * 
 * 思路：
 * 第一遍遍历，如果candidate 知道i，i 更新candidate为i，这一步确保candidate前面的人一定认识别人，candidate一定不认识他后面的人。
 * 
 * 然后第二遍再验证一次
 * 
 * 也可以用Q来做，loop.如果que中元素认识别人就移出que.
 * 最后再验证是否大家都认识que中剩下的元素
 * 
 * 
 */

/* The knows API is defined in the parent class Relation.
boolean knows(int a, int b); */

public class _277_FindtheCelebrity {
    
    public int findCelebrity(int n) {
        
        int candidate = 0;
        for(int i = 1; i < n; i++){
            if(knows(candidate, i))
                candidate = i;
        }
        for(int i = 0; i < n; i++){
            if(i != candidate && (knows(candidate, i) || !knows(i, candidate))) return -1;
        }
        return candidate;
        
    }

}
