package math;

/**
 * Given a positive integer, 
 * return its corresponding column title as appear in an Excel sheet.
 * 
 * For example:
 *  1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
    
 *  10进制转26进制
 */

public class _168_ExcelSheetColumnTitle {
    
    public String convertToTitle(int n) {
        
        StringBuilder sb = new StringBuilder();
        
        while (n > 0) {
            
            char val = (char)((n - 1) % 26 + 'A');
            sb.insert(0, val);
            
            n = (n - 1) / 26;
        }

        
        return sb.toString();
    }
}
