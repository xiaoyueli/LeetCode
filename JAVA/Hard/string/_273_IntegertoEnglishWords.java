package string;

/**
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
 * 
 * For example,
 * 123 -> "One Hundred Twenty Three"
 * 12345 -> "Twelve Thousand Three Hundred Forty Five"
 * 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * 
 * Hint:
 * Did you see a pattern in dividing the number into chunk of words? For example, 123 and 123000.
 * Group the number by thousands (3 digits). 
 * You can write a helper function that takes a number less than 1000 and convert just that chunk to words.
 * There are many edge cases. What are some good test cases? Does your code work with input such as 0? Or 1000010? 
 * (middle chunk is zero and should not be printed out)
 * 
 * 思路，把数字按段（3位为一段）处理
 *
 */

public class _273_IntegertoEnglishWords {

    public String numberToWords(int num) {
        
        if (num == 0) return "Zero";
        
        StringBuilder sb = new StringBuilder();
        
        int cnt = 0;
        while (num != 0) {
            int chunk = num % 1000;
            num /= 1000;
            if (chunk != 0) sb.insert(0, convert(chunk, cnt));
            cnt++;
        }
        
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
        
    }
    
    private String convert(int num, int pos) {
        String[] carry = new String[]{"", "Thousand", "Million", "Billion"};
        String[] nums = new String[]{"Zero", "One", "Two", "Three","Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty",
            "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        
        
        StringBuilder sb = new StringBuilder();
        int hundred = num / 100;
        if (hundred != 0) sb.append(nums[hundred] + " Hundred ");
        num %= 100;
        if (num != 0 && num < 20) {
            sb.append(nums[num] + " ");
        }
        else if (num >= 20) {
        
            int tens = num / 10;
            sb.append(nums[18 + tens] + " ");
            num %= 10;
            if (num != 0) sb.append(nums[num] + " ");
        }
        if (pos != 0) sb.append(carry[pos] + " ");
        
        return sb.toString();
        
    }

}
