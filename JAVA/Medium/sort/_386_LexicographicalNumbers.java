package sort;

/**
 * Given an integer n, return 1 - n in lexicographical order.
 * 
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 * Please optimize your algorithm to use less time and space. 
 * The input size may be as large as 5,000,000.
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class _386_LexicographicalNumbers {	
	
    public List<Integer> lexicalOrder(int n) {
        
        List<Integer> res = new ArrayList<Integer>();
        
        helper(res, 1, n);
        return res;
    }
    
    private void helper(List<Integer> res, int cur, int n) {
        
        if (cur > n) return;
        if (res.size() == n) return;
        
        res.add(cur);
        if (cur * 10 <= n) helper(res, cur * 10, n);
        if ((cur + 1) % 10 != 0) helper(res, cur + 1, n);
    
    }	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_386_LexicographicalNumbers test = new _386_LexicographicalNumbers();
		test.lexicalOrder(50);
	}

}
