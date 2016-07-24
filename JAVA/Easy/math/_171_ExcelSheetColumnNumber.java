package math;

/**
 * Related to question 168 Excel Sheet Column Title
 * Given a column title as appear in an Excel sheet, 
 * return its corresponding column number.
 * 
 * For example:
 *  A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
 *
 */

public class _171_ExcelSheetColumnNumber {
    
    public int titleToNumber(String s) {
        
        char[] title = s.toCharArray();
        
        int mul = 0;
        int sum = 0;
        for (int idx = title.length - 1; idx >= 0; idx--) {
            int val = title[idx] - 'A' + 1;
            sum += val * Math.pow(26, mul);
            mul++;
        }
        
        return sum;
        
    }
}
