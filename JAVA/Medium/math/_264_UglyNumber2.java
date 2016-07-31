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
 * 建一个N的数组记录uglyNum
 * 下一个uglyNum必然是之前某一个uglyNum 乘以2,3,5所得 然后取最小值
 * 这里的某一个uglyNum则从1开始追踪
 * 建立三个idx 分别每次在各自追踪的uglyNum上乘以2,3,5
 * 获取这三个值得最小值后，将与最小值相等的下标+1
 * 因为有公倍数的存在，每一轮可能有不止一个数和MIn相等
 * 直到求出第N个uglyNum;
 * 
 */

public class _264_UglyNumber2 {
    
    public int nthUglyNumber(int n) {
        
        int[] uglyNum = new int[n];
        uglyNum[0] = 1;
        
        int idx2 = 0;
        int idx3 = 0;
        int idx5 = 0;
        
        int idx = 1;
        
        while (idx < n) {
            int next2 = uglyNum[idx2] * 2;
            int next3 = uglyNum[idx3] * 3;
            int next5 = uglyNum[idx5] * 5;
            
            int min = minOf(next2, next3, next5);
            
            // 与Min 值相等的uglyNum的下标都需要更新
            // 排除2,3,5 公倍数重复计算的情况
            if (min == next2) idx2++; 
            if (min == next3) idx3++;
            if (min == next5) idx5++;
            
            uglyNum[idx++] = min;
        }
        
        return uglyNum[n - 1];
        
    }
    
    public int minOf(int a, int b, int c) {
        int min = a;
        if (a > b) min = b;  // a < b ? a : b;
        if (min > c) min = c;
        return min;
    }
    
    public int nthUglyNumber2(int n) {
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
        test.nthUglyNumber(7);
        
        
    }
}
