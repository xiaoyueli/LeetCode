package tree;

public class _307_RangeSumQueryMutable {
    
    int[] segmentTree;
    int[] address;
    int orilen;
    public _307_RangeSumQueryMutable(int[] nums) {
        orilen = nums.length;
        if (orilen == 0) return;
        segmentTree = new int[orilen * 2 - 1];
        address = new int[orilen];
        
        buildTree(nums, segmentTree, 0, orilen - 1, 0);
        
//        for (int i : segmentTree) System.out.println(i);
//        System.out.println();

    }
    
    private int buildTree(int[] ori, int[] tree, int sta, int end, int idx) {
        
        if (sta > end || idx >= segmentTree.length) return 0;
        if (sta == end) {
            tree[idx] = ori[sta];
            address[sta] = idx;
            System.out.println(sta +" " + idx + " val: " + ori[sta]   );
            return ori[sta];
        }
        
        int mid = sta + (end - sta) / 2;
        int left = buildTree(ori, tree, sta, mid, 2 * idx + 1);
        int right = buildTree(ori, tree, mid + 1, end, 2 * idx + 2);
        
        tree[idx] = left + right;
//        System.out.println(idx + " " + tree[idx]);
        return tree[idx];
    }

    void update(int i, int val) {   
        
        int idx = address[i];
//        System.out.println(idx);

        int diff = val - segmentTree[idx];
        while (idx > 0) {
            segmentTree[idx] += diff;
            idx = (idx - 1) / 2;
        }
        segmentTree[idx] += diff;
        
    }
    

    public int sumRange(int i, int j) {
        
        
        
        return rangeHelper(segmentTree, i, j, 0, orilen - 1, 0);
        
    }
    
    private int rangeHelper(int[] segmentTree, int i, int j, int sta, int end, int idx) {
        
        if (sta > end || idx >= segmentTree.length) return 0;
        if (i <= sta && j >= end) return segmentTree[idx];
        if (sta == end) return 0;
        
        int mid = sta + (end - sta) / 2;
        return rangeHelper(segmentTree, i, j, sta, mid, idx * 2 + 1) +
                rangeHelper(segmentTree, i, j, mid + 1, end, idx * 2 + 2);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        int[] seq = new int[]{-28,-39,53,65,11,-56,-65,-39,-43,97};
        _307_RangeSumQueryMutable test = new _307_RangeSumQueryMutable(seq);
        
        
        
//        System.out.println(test.sumRange(5, 6));
        test.update(9, 27);
//        System.out.println(test.sumRange(0, 2));
//        test.update(1, -82);
//        test.update(3, -72);
//        test.update(5, 13);
//        test.update(4, -67);
        

    }

}
