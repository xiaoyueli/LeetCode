package greedy;

/**
 * Suppose you have a random list of people standing in a queue. 
 * Each person is described by a pair of integers (h, k), 
 * where h is the height of the person and k is the number of people in front of this person 
 * who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
 * 
 * Note:
 * The number of people is less than 1,100.
 * 
 * Example
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * 
 * 思路;
 * 先按身高降序，再按K升序
 * 最后如果k<当前索引插入排序到数组中K的位置，否则continueß
 * 
 * 
 */

import java.util.Arrays;
import java.util.Comparator;


public class _406_QueueReconstructionbyHeight {
	
    public int[][] reconstructQueue(int[][] people) {
        
        int len = people.length;
        
        // 先按H将序，再按K升序
        Comparator<int[]> myComH = new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) return a[1] - b[1];
                else return b[0] - a[0];
            }
        };
        
        Arrays.sort(people, myComH);
        
        for (int idx = 0; idx < len; idx++) {
            int[] person = people[idx];
            int num = person[1];
            if (num >= idx ) continue;
            
            for (int cur = idx; cur > num; cur--) {
                people[cur] = people[cur - 1];
            }
            people[num] = person;
        }
        
        return people;
    }
    
    // 根据组数第二位排序
//    private void sortByK(int[][] people) {
//        
//        Comparator<int[]> myCom = new Comparator<int[]>() {
//            public int compare(int[] a, int[] b) {
//                if (a[1] > b[1]) return 1;
//                if (a[1] < b[1]) return -1;
//                return 0;
//            }
//        };
//        
//        int start = 0;
//        int len = people.length;
//        for (int idx = 1; idx < len; idx++) {
//            if (people[idx][0] == people[idx - 1][0]) continue;
//            Arrays.sort(people, start, idx, myCom);
//            start = idx;
//        }
//        
//        Arrays.sort(people, start, len, myCom);
//        
//    }
    
    // 自己写的quicksort
    // private void sortByHeightDes(int[][] people, int left, int right) {
        
    //     if (left >= right) return;
    //     int[] pivot = sort(people, left, right);
    //     sortByHeightDes(people, left, pivot[0]);
    //     sortByHeightDes(people, pivot[1], right);
    // }
    
    // private int[] sort(int[][] people, int left, int right) {
        
    //     int pivVal = people[left][0];
    //     int smaller = left + 1;
    //     int bigger = right;
    //     int pointer = smaller;
    //     while (pointer <= bigger) {
    //         int cur = people[pointer][0];
    //         if (cur > pivVal) {
    //             swap(people, smaller, pointer);
    //             smaller++;
    //             pointer++;
    //         }
    //         else if (cur < pivVal) {
    //             swap(people, bigger, pointer);
    //             bigger--;
    //         }
    //         else pointer++;
    //     }
        
    //     swap(people, left, smaller - 1);
    //     sortK(people, smaller - 1, bigger);
    //     return new int[]{smaller - 1, bigger + 1};
    // }
    
    // private void sortK(int[][] people, int left, int right) {
    	
    // 	for (int idx = left + 1; idx <= right; idx++) {
    // 		int temp = idx;
    // 		while (temp > left && people[temp][1] < people[temp - 1][1]) {
    // 				swap(people, temp, temp - 1);
    // 				temp--;
    // 			}
    // 		}
    	
    // }
    
    // private void swap(int[][] people, int a, int b) {
    //     if ( a == b) return;
    //     int[] temp = people[a];
    //     people[a] = people[b];
    //     people[b] = temp;
    // }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_406_QueueReconstructionbyHeight test = new _406_QueueReconstructionbyHeight();
		
		int[][] info = new int[][]{{8, 2},{4,2},{4,5}, {2,0}, {7,2}, {1,4}, {9,1}, {3,1}, {9,0},{1,0}};
//		test.reconstructQueue(info);

	}
//	
//	Input:
//	[[8,2],[4,2],[4,5],[2,0],[7,2],[1,4],[9,1],[3,1],[9,0],[1,0]]
	
	//  [[9,0],[7,0],[1,9],[3,0],[2,7],[5,3],[6,0],[3,4],[6,2],[5,2]]
//		[[7,2],[6,0],[9,0],[6,1],[4,5],[2,0],[0,6],[8,1],[4,2],[5,3]]
//		Output:
//		[[2,0],[6,0],[6,1],[4,2],[8,1],[5,3],[0,6],[4,5],[7,2],[9,0]]

}
