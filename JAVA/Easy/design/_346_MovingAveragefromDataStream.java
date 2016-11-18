package design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author xiaoyue
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 * 
 * For example,
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 * 
 * 题意，求窗口size以内所有数的平均值
 * next的参数是新加入的数字
 * 如果加入的数字大于Window的数量，移除最早加入的数字再求平均值
 *
 */

public class _346_MovingAveragefromDataStream {
    
    /** Initialize your data structure here. */
    private Queue<Integer> que;
    int size;
    int sum;
    
    public _346_MovingAveragefromDataStream(int size) {
        que = new LinkedList<Integer>();
        this.size = size;
        sum = 0;
    }
    
    public double next(int val) {
        
        que.offer(val);
        if (que.size() <= size) sum += val;
        else sum = sum - que.poll() + val;
        
        return sum * 1.0 / que.size();
    }

}


/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
