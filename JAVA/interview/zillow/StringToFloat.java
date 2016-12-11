package zillow;

/**
 * 
 * @author xiaoyue
 * 第一题是把一个string变成float，string表示形式为 
 * 
 * "-5"    => -5.0 
 * "3/4"  => 0.75 
 * "1 3/4"  => 1.75 
 *
 */

public class StringToFloat {
    
    public double solve(String str) {

        String[] nums = str.split(" ");
        char[] seq = nums[0].toCharArray();
        
        int sta = 0;
        boolean isNeg = false;
        if (seq[0] == '-') {
            isNeg = true;
            sta = 1;
        }
        else if (seq[1] == '+') sta = 1;
        
        double num1 = getNum(seq, sta);
        if (nums.length == 2) {
            double num2 = getNum(nums[1].toCharArray(), 0);
            if (isNeg) return -num1 - num2;
            else return num1 + num2;
        }
        
        if (isNeg) return -num1;

        return num1;
    }
    
    private double getNum(char[] seq, int pos) {
        
        double res = 0;
        double temp = 0;
        boolean isDecimal = false;
        for (int i = pos; i < seq.length; i++) {
            char cur = seq[i];
            if (cur == '/') {
                res = temp;
                temp = 0;
                isDecimal = true;
            }
            else temp = temp * 10 + (cur - '0');
        }
        
        if (isDecimal) return res / temp;
        else return temp;
        
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        StringToFloat test = new StringToFloat();
        
        System.out.println(test.solve("-9 3/4"));
    }

}
