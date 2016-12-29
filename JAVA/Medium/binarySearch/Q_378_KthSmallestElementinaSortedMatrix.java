package binarySearch;

/**
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, 
 * find the kth smallest element in the matrix.
 * 
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * 
 * Example:
 * matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
    ],
    k = 8,
    
    return 13.
    
    Note: 
    You may assume k is always valid, 1 ≤ k ≤ n2.
 
 *  不会二分法
 *
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q_378_KthSmallestElementinaSortedMatrix {
    
    public int kthSmallest(int[][] matrix, int k) {
        
        Comparator<Integer> myCom = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (a > b) return -1;
                if (a < b) return 1;
                return 0;
            }
        };
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, myCom);
        
        int width = matrix[0].length;
        int height = matrix.length;
        
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                int val = matrix[row][col];
                if (maxHeap.size() < k) maxHeap.offer(val);
                else if (val < maxHeap.peek()) {
                    maxHeap.poll();
                    maxHeap.offer(val);
                }
                else break;
            }
        }
        
        return maxHeap.peek();
        
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
