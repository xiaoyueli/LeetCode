package math;

/**
 * There is a list of sorted integers from 1 to n. 
 * Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.
 * 
 * Repeat the previous step again, but this time from right to left, 
 * remove the right most number and every other number from the remaining numbers.
 * 
 * We keep repeating the steps again, alternating left to right and right to left, until a single number remains.
 * Find the last number that remains starting with a list of length n.
 * 
 * Example:
 * Input:
 * n = 9,
 * 1 2 3 4 5 6 7 8 9
 * 2 4 6 8
 * 2 6
 * 6
 * 
 * Output:
 * 6
 * 
 * @author xiaoyue
 * 
 * 思路：
 * 规律：每次都减少一半的元素
 * 用remains来记录本轮剩下的元素
 * 每次只需要关注头元素的值，当remains为1时，此时的头元素就是剩下的元素
 * 
 * 更新头元素的规律
 * 1，从前往后删除时需要更新
 * 2，当从后往前删除时，总共元素为奇数时需要更新
 * 更新的原则通过观察可以看出是以2的倍数扩大的，初始值为1，因为为每隔一个删除后一个元素。
 *
 */

public class _390_EliminationGame {
    
    public int lastRemaining(int n) {
        
        int scale = 1;
        int remains = n;
        boolean front = true;
        int head = 1;
        
        while (remains > 1) {
            
            if (front || remains % 2 == 1) {
                head += scale;
            }
            
            remains /= 2;
            scale *= 2;
            front = !front;
        }
             
        return head;      
    }
    
    
    
    // 变化的规律
    public int lastRemaining2(int n) {
        
        int sta = 1;
        int end = n;
        int scale = 2;
        boolean increase = true;
        int res = 0;
        while (res < n) {
            
            if (increase) {
                int oriSta = sta;
                while (sta <= end) {
                    res++;
                    if (res == n) return sta;
                    sta += scale;

                }
                sta -= scale;
                if (sta == end) sta -= scale / 2;
                else sta += scale / 2;
                
                end = oriSta + scale / 2;
                
                scale *= 2;
                
                increase = false;
            }
            else {
                
                int oriSta = sta;
                while (sta >= end) {
                    res++;
                    if (res == n) return sta;
                    sta -= scale;
                }
                sta += scale;
                if (sta == end) sta += scale / 2;
                else sta -= scale / 2;
                
                end = oriSta - scale / 2;
                
                scale *= 2;
                               
                increase = true;             
            }
        }
        
        return res;
        
    }
    
    

}
