package binarySearch;

/**
 * You are a product manager and currently leading a team to develop a new product. 
 * Unfortunately, the latest version of your product fails the quality check. 
 * Since each version is developed based on the previous version, 
 * all the versions after a bad version are also bad.
 * 
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, 
 * which causes all the following ones to be bad.
 * 
 * You are given an API bool isBadVersion(version) which will return whether version is bad. 
 * Implement a function to find the first bad version. 
 * You should minimize the number of calls to the API.
 *
 *  注意求mid 用差值，mid = low + (high - low)/ 2，
 *  否则直接相加，high很大时，之后求Mid可能溢出
 
 * The isBadVersion API is defined in the parent class VersionControl.
 *    boolean isBadVersion(int version); 
 */

public class _278_FirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        
        int left = 1;
        int right = n;
        
        while (left <= right) {
            int mid = left + (right - left)/ 2;
            if (isBadVersion(mid)) right = mid - 1;
            else left = mid + 1;
        }
        
        
        return left;
    }
}
