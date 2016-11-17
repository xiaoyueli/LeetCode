package dynamicProgramming;

/**
 * 思路：
 * 记录最后一个单词第一次出现的col所在的行数，即当时的一共遍历了多少次数组，然后通过差值计算重复的部分。
 */

public class _418_SentenceScreenFitting {
    
    public int wordsTyping(String[] sentence, int rows, int cols) {
        
        int[][] map = new int[cols][2];
        for (int idx = 0; idx < cols; idx++) map[idx][0] = -1;
        
        int length = sentence.length;
        int idx = 0;
        int row = 0;
        int res = 0;
        int lenlw = sentence[length - 1].length(); // 最后一个单词的长度
        
        while (true) {
            
            for (int i = 0; i < length; i++) {

                int len = sentence[i].length();
                if (len > cols) return 0;
                if (idx + len > cols) {
                    idx = len + 1;
                    row++;
                    if (row >= rows) return res;
                }
                else idx += len + 1;        
            }
            res++;
            int collw = idx - lenlw - 1; // 最后一个单词出现的col位置
            
            if (map[collw][0] == -1) {
                // 最后一个单词在这个col没有出现过
                map[collw][0] = row;
                map[collw][1] = res;
            } 
            else {
                // 最后一个单词在这个位子出现过，即开始重复
                int repeatRow = map[collw][0]; // 上一次出现在第几行
                int differ = row - repeatRow; // 他们的差值
                int repeatNum = res - map[collw][1]; // 重复部分遍历了多少轮数组
                
                while (row + differ < rows) {
                    // 循环求累计值，也可以推导公式计算
                    row += differ;
                    res += repeatNum;
                }
            }
        }
    }

}
