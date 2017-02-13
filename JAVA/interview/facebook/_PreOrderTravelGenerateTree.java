package facebook;

class TNode {
    int val;
    TNode left;
    TNode right;
    
    public TNode(int val) {
        this.val = val;
    }
}

public class _PreOrderTravelGenerateTree {
    
    public TNode solve(int[] seq) {
        
        return helper(seq, 0, seq.length - 1);
    }
    
    private TNode helper(int[] seq, int sta, int end) {
        if (sta > end) return null;
        
        TNode root = new TNode(seq[sta]);
        
        int idx = sta;
        while (seq[idx + 1] < seq[sta]) idx++;
        
        TNode left = helper(seq, sta + 1, idx);
        TNode right = helper(seq, idx + 1, end);
        
        root.left = left;
        root.right = right;
        return root;
        
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
