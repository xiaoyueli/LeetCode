package array;

/**
 * Given n non-negative integers a1, a2, ..., an, 
 * where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, 
 * such that the container contains the most water.
 * 
 * Note: You may not slant the container.
 * 
 * 从两边往中间逼近，每次替换较低的边界
 *
 */

public class _11_ContainerWithMostWater {
    int[] height;
    public int maxArea(int[] height) {
        this.height = height;
        
        int left = 0;
        int right = height.length - 1;
        int maxAre = area(left, right);
        while (left < right) {
            if (height[left] < height[right]) left++;
            else right--;
            maxAre = Math.max(maxAre, area(left, right));
        }
        
        return maxAre;
    }
    
    public int area(int p1, int p2) {
        
        if (p1 >= p2) return 0;
        return (p2 - p1) * Math.min(height[p1], height[p2]);
    }
}
