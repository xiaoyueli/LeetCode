package bitManipulation;

/**
 * 
 * @author xiaoyue
 * 
 * Given an integer, write an algorithm to convert it to hexadecimal. 
 * For negative integer, two’s complement method is used.
 * 
 * Note:
 * 
 * All letters in hexadecimal (a-f) must be in lowercase.
 * The hexadecimal string must not contain extra leading 0s. 
 * If the number is zero, it is represented by a single zero character '0'; 
 * otherwise, the first character in the hexadecimal string will not be the zero character.
 * 
 * The given number is guaranteed to fit within the range of a 32-bit signed integer.
 * You must not use any method provided by the library which converts/formats the number to hex directly.
 * 
 * Example 1:
 * Input:26
 * Output:"1a"
 * 
 * Example 2:
 * Input:-1
 * Output:"ffffffff"
 * 
 * notice: 补码等于反码+1
 * 转换16进制等于将二进制数每4bit当做16进制的一位处理
 *
 */

public class _405_ConvertaNumbertoHexadecimal {
    
    public String toHex(int num) {
        
        char[] map = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        
        StringBuilder sb = new StringBuilder();
        for (int cnt = 0; cnt < 8; cnt++) {
            sb.insert(0, map[num & 15]);
            num >>= 4;
            if(num == 0) break;
        }
        
        return sb.toString();
        
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(16 & 15);
    }

}
