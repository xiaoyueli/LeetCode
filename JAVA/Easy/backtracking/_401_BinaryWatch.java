package backtracking;

/**
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), 
 * and the 6 LEDs on the bottom represent the minutes (0-59).
 * 
 * Each LED represents a zero or one, with the least significant bit on the right.
 * 
 * For example, the above binary watch reads "3:25".
 * Given a non-negative integer n which represents the number of LEDs that are currently on, 
 * return all possible times the watch could represent.
 * 
 * Example:
 * Input: n = 1
 * Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 * 
 * Note:
 * The order of output does not matter.
 * The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
 * The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".
 * 
 * 思路：
 * 组合问题： 在10个数里选N个数的组合（组合问题不关心顺序，不能有重复的subsets）
 * 找出所有组合后再来删选符合要求的组合
 * 将小时设置为前4个数，分钟设为后6个数
 * 
 */

import java.util.ArrayList;
import java.util.List;


public class _401_BinaryWatch {
	
    public List<String> readBinaryWatch(int num) {
        
        int[] combin = new int[num];
        
        int[] binaryWatch = new int[]{1, 2, 4, 8, 1, 2, 4, 8, 16, 32};
        
        List<String> res = new ArrayList<String>();
        
        bwHelper(combin, binaryWatch, 0, 0, num, res);
        
        return res;
        
    }
    
    private void bwHelper(int[] com, int[] seq, int cur, int index, int len, List<String> res) {
        if (cur >= len) {
            add(com, seq, res, len);
            return;
        }
        
        if (index >= seq.length) return;
        
        com[cur] = index;
        bwHelper(com, seq, cur + 1, index + 1, len, res);
        bwHelper(com, seq, cur, index + 1, len, res);
        
    }

    private void add(int[] com, int[] seq, List<String> res, int len) {
        
        int house = 0, minute = 0;
        for (int idx = 0; idx < len; idx++) {
            if (com[idx] < 4) house += seq[com[idx]];
            else minute += seq[com[idx]];
        }
        
        if (house <= 11 && minute <= 59) {
            StringBuilder sb = new StringBuilder();
            sb.append(house + ":");
            if (minute <= 9) sb.append("0" + minute);
            else sb.append(minute);
            res.add(sb.toString());
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_401_BinaryWatch test = new _401_BinaryWatch();
		test.readBinaryWatch(2);

	}

}
