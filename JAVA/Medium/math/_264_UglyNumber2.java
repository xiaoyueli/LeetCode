package math;

import java.util.PriorityQueue;

/**
 * Write a program to find the n-th ugly number.
 * 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
 * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * 
 * Note that 1 is typically treated as an ugly number.
 *
 */

public class _264_UglyNumber2 {
    
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> minQ = new PriorityQueue<Long>();
        
        int cnt = 1;
        long min = 1;
        minQ.add(2l);
        minQ.add(3l);
        minQ.add(5l);

        int[] uglyfactor = new int[] {2, 3, 5};
        while (true) {
            
            if (cnt == n) return (int)min;
            min = minQ.remove();
            
            cnt++;
            // System.out.println(cnt + " " + min);
            for (int i: uglyfactor) {
                if (min % 3 == 0 && i < 3) continue;
                if (min % 5 == 0 && i < 5) continue;
                minQ.add(min * i);
                

            }

        }
        
    }
    
    public static void main(String[] args) {
        _264_UglyNumber2 test = new _264_UglyNumber2();
        test.nthUglyNumber(11);
    }
}
