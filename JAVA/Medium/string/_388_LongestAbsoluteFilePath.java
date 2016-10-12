package string;

import java.util.Stack;

/**
 * Suppose we abstract our file system by a string in the following manner:
 * The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:
 * dir
    subdir1
    subdir2
        file.ext
        
   The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.
   The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:
   
   dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
            
   The directory dir contains two sub-directories subdir1 and subdir2. 
   subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1. 
   subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.
   
   We are interested in finding the longest (number of characters) absolute path to a file within our file system. 
   For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", 
   and its length is 32 (not including the double quotes).
   
   Given a string representing the file system in the above format, 
   return the length of the longest absolute path to file in the abstracted file system. 
   If there is no file in the system, return 0.
   
   Note:
   The name of a file contains at least a . and an extension.
   The name of a directory or sub-directory will not contain a ..
   Time complexity required: O(n) where n is the size of the input string.
   
   Notice that a/aa/aaa/file1.txt is not the longest file path, if there is another path aaaaaaaaaaaaaaaaaaaaa/sth.png.
   
   
 * @author xiaoyue
 * 
 * 思路， 
 * 
 * 1：用数组
 * 只计算长度，用数组更快
 * 如果需要找到具体路径的字符串用stack
 * 
 * 每一个数组元素存的都是当前路径的长度
 * 找上一层路径长度时只需要返回相应下标的值即可
 * 
 * 2：用栈
 * 用栈记录文件深度
 * 栈里面存的总是当前单一路径
 * 遇到同层的，栈顶元素弹出，再入栈当前元素
 * 遇到文件时，计算路径长度，并更新最大长度
 * 
 *
 */

public class _388_LongestAbsoluteFilePath {
    
    public int lengthLongestPath(String input) {
        
        String[] seq = input.split("\n");
        int len = seq.length;
        int[] pathLen = new int[len];
        
        int max = 0;
        
        for (String s: seq) {
            int level = s.lastIndexOf("\t") + 1;  // 计算深度
            
            int lastLen = 0;
            if (level > 0) lastLen = pathLen[level - 1]; // 返回上一层路径长度
            
            int curlen = s.length() - level + 1 + lastLen; // 当前字符长度 + 上一层字符串长度 和'/'
            
            if (s.contains(".")) {
                
                if (curlen - 1 > max) max = curlen - 1;     //  如果是字符串就更新最大长度
            }
            
            pathLen[level] = curlen; // 存储当前路径长度

        }

        return max;

    }
    

    public int lengthLongestPath2(String input) {
        
        Stack<String> stack = new Stack<String>();
        String[] seq = input.split("\n");
        // String res = "";
        
        int max = 0;
        
        for (String s: seq) {
            
            // count the degree of the current string
            int level = getLevel(s);
            
            // if the current string at the same degree of the string of the peek of stack
            // pop the peek string from stack
            while (stack.size() > level) {
                stack.pop();
            }
            
            // remove all the "\t" from the current string
            String pureStr = s.replaceAll("\t", "");
            
            
            // check the current string if it is a file
            if (pureStr.contains(".")) {
                
                // get the path of the file
                StringBuilder sb = new StringBuilder();
                for (String str: stack) {
                    sb.append(str + "/");
                }
                sb.append(pureStr);
                
                // update the max length of the path of a file
                if (sb.length() > max) {
                    max = sb.length();
                    // res = sb.toString();
                }
                
            }
            
            // push the current string into stack
            stack.push(pureStr);
            
        }
        
        // System.out.println(res);
        return max;

    }
    
    private int getLevel(String str) {
        
        String copy = str.replaceAll("\t", "");
        return str.length() - copy.length();
    }
    
    public static void main(String[] args) {
        String str = "dir\n        file.txt";
        
        _388_LongestAbsoluteFilePath test = new _388_LongestAbsoluteFilePath();
        test.lengthLongestPath(str);

    }

}
