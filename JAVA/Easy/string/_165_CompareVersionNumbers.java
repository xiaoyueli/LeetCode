package string;

/**
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, 
 * otherwise return 0.
 * 
 * You may assume that the version strings are non-empty and 
 * contain only digits and the . character.
 * 
 * The . character does not represent a decimal point and 
 * is used to separate number sequences.
 * 
 * For instance, 2.5 is not "two and a half" or "half way to version three", 
 * it is the fifth second-level revision of the second first-level revision.
 * 
 * Here is an example of version numbers ordering:
 * 
 * 0.1 < 1.1 < 1.2 < 13.37
 *
 */

public class _165_CompareVersionNumbers {
    
    public int compareVersion(String version1, String version2) {
        
        String[] one = version1.split("\\.");
        String[] two = version2.split("\\.");
        
        int idx1 = 0;
        int idx2 = 0;
        int len1 = one.length;
        int len2 = two.length;
        
        while (idx1 < len1 && idx2 < len2) {
            int val1 = Integer.parseInt(one[idx1++]);
            int val2 = Integer.parseInt(two[idx2++]);
            if (val1 > val2) return 1;
            else if (val1 < val2) return -1;
        }
        
        while (idx1 < len1) {
            int val = Integer.parseInt(one[idx1++]);
            if (val != 0) return 1;
        }
        while (idx2 < len2) {
            int val = Integer.parseInt(two[idx2++]);
            if (val != 0) return -1;
        }
        return 0;
    }
    
    public static void main(String[] args) {
//        _165_CompareVersionNumbers test = new _165_CompareVersionNumbers();
//        test.compareVersion("1.0", "1");
        
        System.out.println("0".split("\\.").length);
    }

}
