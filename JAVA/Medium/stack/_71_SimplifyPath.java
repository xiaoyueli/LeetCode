package stack;

import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * 
 * Corner Cases:
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 * 
 * 思路：
 * 主要理解题意
 * 意思为遇到/.为当前目录
 * 遇到/..为返回上一层目录
 * 
 * 用栈则表示，遇到文件路径入栈，遇到/.什么也不做，遇到/.. 将栈顶路径出栈
 * 最后留在栈中的即为所求
 *
 */

public class _71_SimplifyPath {
    
    public String simplifyPath(String path) {
        
        String[] seq = path.split("/");
        Stack<String> stack = new Stack<String>();
        
        int len = seq.length;

        for (int idx = 0; idx < len; idx++) {
            String cur = seq[idx];
            if (cur.equals("") || cur.equals(".")) continue;
            if (cur.equals("..") && !stack.isEmpty()) stack.pop();
            else if (cur.equals("..") ) continue;
            else stack.push("/" + cur);
        }
        
        StringBuilder sb = new StringBuilder();
        for (String s: stack) {
            sb.append(s);
        }
        
        if (sb.length() == 0) return "/";
        return sb.toString();
        
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        _71_SimplifyPath test = new _71_SimplifyPath();
        test.simplifyPath("/abc/...");

    }

}
