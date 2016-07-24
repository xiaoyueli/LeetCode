package math;

/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * Each rectangle is defined by its bottom left corner and top right corner 
 * as shown in the figure.
 * 
 * Assume that the total area is never beyond the maximum possible value of int.
 */

public class _223_RectangleArea {
    
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        
        int rec1 = (C - A) * (D - B);
        int rec2 = (G - E) * (H - F);
        int area = rec1 + rec2;
        if (C <= E || A >= G || B >= H || F >= D) return area;
        
        int height = 0;
        if (B >= F && D >= H) height = H - B;
        else if (H >= D && F >= B) height = D - F;
        else if (D >= H && F >= B) height = H - F;
        else height = D - B;
        
        int width = 0;
        if (A <= E && C <= G) width = C - E;
        else if (A >= E && C >= G) width = G - A;
        else if (A >= E && C <= G) width = C - A;
        else width = G - E;
        
        int covered = width * height;
        
        area -= covered;
        
        return area;
        
    }
}
