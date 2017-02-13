package facebook;

/**
 * 
 * @author xiaoyue
 * 
 * Given two pre-order traversal arrays of two binary search tree respectively, find first pair of non-matching leaves. 
 * Follow Up: If they are general binary trees instead of BSTs, could you solve it? give out your reason.
 *
 */

public class _Non_matching_leaves {
    
    public int[] solve(int[] t1, int[] t2) {
        
        return helper(t1, 0, t1.length - 1, t2, 0, t2.length - 1);
        
    }
    
    private int[] helper(int[] t1, int sta1, int end1, int[] t2, int sta2, int end2) {
        if (sta1 == end1 && sta2 == end2 ) {
            if (t1[sta1] == t2[sta2]) return null;
            else return new int[]{t1[sta1], t2[sta2]};
        }
        
        int idx1 = getFirstPartEnd(t1, sta1);
        int idx2 = getFirstPartEnd(t2, sta2);
        
        int[] left = helper(t1, sta1 + 1, idx1, t2, sta2 + 1, idx2);
        if (left != null) return left;
        return helper(t1, idx1 + 1, end1, t2, idx2 + 1, end2);
        
    }
    
    private int getFirstPartEnd(int[] nums, int sta) {
        int idx = sta;
        while (nums[idx + 1] < sta) idx++;
        return idx;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
