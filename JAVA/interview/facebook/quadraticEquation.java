package facebook;

/**
 * 
 * @author xiaoyue
 * 
 * 一个一元二次方表达式，y = ax^2 + bx + c， a, b, c都提供，还提一个排好升序的array作为x输入，问怎么输出一个也是升序的y结果。后来也是面试官提示，根据这个函数的图像，找到顶点，然后从顶点向两边找结果，
 * 
 * 
    谢谢楼主分享！
    
    第二题的思路是这样的吗？
    
    1、要根据顶点坐标公式(-b/2a, (4ac-b^2)/4a)求出顶点(m, n)
    2、看a是正数还是负数，负数的话，图像倒置，用x Array中小于m的点，根据公式算出y并输出，如果是正数的话，图像正置，用x Array中大于m的点根据公式算出y并输出
 *
 */

public class quadraticEquation {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
