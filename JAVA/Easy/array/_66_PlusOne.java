package array;

public class _66_PlusOne {
    
    public int[] plusOne(int[] digits) {
        for (int idx = digits.length - 1; idx >= 0; idx--) {
            if (digits[idx] + 1 == 10 && idx == 0) {
                digits = new int[digits.length + 1];
                digits[0] = 1;
                for (int next = 1; next < digits.length; next++) digits[next] = 0;
                break;
            }
            else if (digits[idx] + 1 == 10 && idx != 0) digits[idx] = 0;
            else if (digits[idx] + 1 < 10) {
                digits[idx] += 1;
                break;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
