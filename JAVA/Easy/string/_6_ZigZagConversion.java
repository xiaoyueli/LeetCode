package string;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern
 *  on a given number of rows like this: 
 *  (you may want to display this pattern in a fixed font for better legibility)
 *  
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and 
 * make this conversion given a number of rows:
 * 
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * 
 * 寻找同一排的字母位置差值规律
 */

public class _6_ZigZagConversion {
    
    public String convert(String s, int numRows) {
        
        int len = s.length();
        char[] arr = s.toCharArray();
        char[] res = new char[len];
        if (numRows == 1) return s;
        
        int row = 1;
        int idx = 0;
        while (row <= numRows) {
            
            if (row == 1 || row == numRows) {
                for (int sta = row - 1; sta < len; sta += 2 * numRows - 2) {
                    res[idx++] = arr[sta];
                }
            }
            else {
                int skip = 0;
                int up = 2 * row - 2;
                int under = 2 * (numRows - row);
                boolean flag = true;
                for (int sta = row - 1; sta < len; sta += skip) {
                    res[idx++] = arr[sta];
                    if (flag) skip = under;
                    else skip = up;
                    flag = !flag;
                }
            }

            row++;
  
        }
        
        s = new String(res);
        return s;
    }
}
