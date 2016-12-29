package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * @author xiaoyue
 * 
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. 
 * Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A), 
 * write a program to output the skyline formed by these buildings collectively (Figure B).
 * 
 * The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], 
 * where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. 
 * It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. 
 * You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

    For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
    
    The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. 
    A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends, 
    is merely used to mark the termination of the skyline, and always has zero height. 
    Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.
    
    For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
    
    Notes:
    
    The number of buildings in any input list is guaranteed to be in the range [0, 10000].
    The input list is already sorted in ascending order by the left x position Li.
    The output list must be sorted by the x position.
    There must be no consecutive horizontal lines of equal height in the output skyline. 
    For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; 
    the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]
 * 
 * 思路：
 * critical point 是每个长方形的左上点和右下点。
 * 用height的负数区别是左上点还是右下点
 * 遍历所有长方形，将该两点加入list int[]{x, height}；
 * 将该List按x 排序
 * 然后用一个最大堆存当前span内的height。 即遇到y大于0的，将height加入heap, 小于0时移除
 * 
 * 当遇到height > 0的点，检查是否大于heap 的peek
 * 当遇到height < 0的点，如果如果是height是peek, 则critical point的 height是0 或heap中次大的元素
 * 并且将该height从堆中删除
 * 
 * 
 */
public class _218_TheSkylineProblem {
    
    public List<int[]> getSkyline(int[][] buildings) {
        
        List<int[]> map = new ArrayList<int[]>();
        
        for (int[] build: buildings) {
            map.add(new int[]{build[0], build[2]});
            map.add(new int[]{build[1], -build[2]});
        }
        
        Collections.sort(map, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) return b[1] - a[1];
                return a[0] - b[0];
            }
        });
        
        PriorityQueue<Integer> heights = new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        
        List<int[]> res = new ArrayList<int[]>();
        
        int prex = -1;
        for (int[] build: map) {
            int x = build[0];
            int y = build[1];
            if (x == prex && y > 0) {
                heights.offer(Math.abs(y));
                continue;
            }
            if (y > 0) {
                if (heights.isEmpty()) res.add(new int[]{x, y});
                else if (y > heights.peek()) res.add(new int[]{x, y});
                heights.offer(y);
            }
            else {
                y = -y;
                if (y == heights.peek()) {
                    heights.poll();
                    if (heights.isEmpty()) res.add(new int[]{x, 0});
                    else if (y > heights.peek()) res.add(new int[]{x, heights.peek()});
                }
                else heights.remove(y);
            }
            
            prex = x;
        }
        
        return res;
        
    }

}
