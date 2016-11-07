package math;

/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * Each rectangle is defined by its bottom left corner and top right corner 
 * as shown in the figure.
 * 
 * Assume that the total area is never beyond the maximum possible value of int.
 * 
 * 思路：
 * 计算相交的矩形的两个顶点
 */

public class _223_RectangleArea {
    
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);
        
        if (H <= B ||F >= D || E >= C || G <= A) return area1 + area2;
        
        int tx = 0, ty = 0, bx = 0, by = 0;
        
        if (D >= H) ty = H;
        else ty = D;
        
        if (G >= C) tx = C;
        else tx = G;
        
        if (A <= E) bx = E;
        else bx = A;
        
        if (F <= B) by = B;
        else by = F;
        
        int inter = (tx - bx) * (ty - by);
        
        return area1 + area2 - inter;
        
    }
}
