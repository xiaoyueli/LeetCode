package string;


public class _383_RansomNote {
	
    public boolean canConstruct(String ransomNote, String magazine) {
        
        char[] mag = magazine.toCharArray();
        char[] ran = ransomNote.toCharArray();
        
        int len = mag.length;
        int[] cntMag = new int[26];
        for (int idx = 0; idx < len; idx++) {
            cntMag[mag[idx] - 'a']++;
        }
        
        len = ran.length;
        for (int idx = 0; idx < len; idx++) {
            int val = ran[idx] - 'a';
            if (cntMag[val] == 0) return false;
            cntMag[val]--;
        }
     
        return true;
        
    }

}
