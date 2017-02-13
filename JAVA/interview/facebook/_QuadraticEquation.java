package facebook;

/**
 * 
 * @author xiaoyue
 * 
 * 一个一元二次方表达式，y = ax^2 + bx + c， a, b, c都提供，还提一个排好升序的array作为x输入，问怎么输出一个也是升序的y结果。
 * 后来也是面试官提示，根据这个函数的图像，找到顶点，然后从顶点向两边找结果，
 * 
 * 
    谢谢楼主分享！
    
    第二题的思路是这样的吗？
    
    1、要根据顶点坐标公式(-b/2a, (4ac-b^2)/4a)求出顶点(m, n)
    2、看a是正数还是负数，负数的话，图像倒置，用x Array中小于m的点，根据公式算出y并输出，如果是正数的话，图像正置，用x Array中大于m的点根据公式算出y并输出
 *
 */

public class _QuadraticEquation {
    
    public int[] solve(int[] nums, int a, int b, int c) {
        double pivot = - b * 1.0 / (2 * a);
        int len = nums.length;
        int[] res = new int[len];
        if (a < 0) {
            if (nums[len - 1] <= pivot) calculateOneWay(nums, res, a, b, c, 0);
            else if (nums[0] >= pivot) calculateOneWay(nums, res, a, b, c, len - 1);
            else calculateTwoPointer(nums, res, a, b, c, 0);
        }
        else {
            if (nums[len - 1] <= pivot) calculateOneWay(nums, res, a, b, c, len - 1);
            else if (nums[0] >= pivot) calculateOneWay(nums, res, a, b, c, 0);
            else calculateTwoPointer(nums, res, a, b, c, len - 1);
        }
        
        return res;
    }
    
    private void calculateOneWay(int[] nums, int[] res, int a, int b, int c, int pos) {
        
        int idx = pos;
        for (int i = 0; i < nums.length; i++) {
            int val = getRes(nums[i], a, b, c);
            if (pos == 0) res[idx++] = val;
            else res[idx--] = val;
        }
    }
    
    private void calculateTwoPointer(int[] nums, int[] res, int a, int b, int c, int pos) {
        int left = 0;
        int right = nums.length - 1;
        int idx = pos;
        while (left <= right) {
            int lval = getRes(nums[left], a, b, c);
            int rval = getRes(nums[right], a, b, c);
            if (lval < rval) {
                if (pos == 0) res[idx++] = lval;
                else res[idx--] = lval;
                left++;
            }
            else {
                if (pos == 0) res[idx++] = rval;
                else res[idx--] = rval;
                right--;
            }
        }
    }
    
    private int getRes(int num, int a, int b, int c) {
        return a * num * num + b * num + c;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        _QuadraticEquation test = new _QuadraticEquation();
        int[] nums = new int[]{-3, -1, 0, 2, 5, 6, 7};
        
        int[] res = test.solve(nums, -1, 4, 3);
        
        for (int i: res) System.out.print(i + " ");

    }

}
