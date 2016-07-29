package math;

/**
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 */

public class _12_IntegertoRoman {
    
    public String intToRoman(int num) {
        
        int[] nums = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        
        for (int idx = 0; idx < nums.length; idx++) {
            int val = nums[idx];
            String roman = romans[idx];
            while (num >= val) {
                num -=val;
                sb.append(roman);
            }
            if (num == 0) break; 
        }
        
        return sb.toString();
        
    }
    

}
