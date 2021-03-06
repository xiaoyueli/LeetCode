package design;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Given a nested list of integers, implement an iterator to flatten it.
 * 
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * Example 1:
 * Given the list [[1,1],2,[1,1]],
 * 
 * By calling next repeatedly until hasNext returns false, 
 * the order of elements returned by next should be: [1,1,2,1,1].
 * 
 * Example 2:
 * Given the list [1,[4,[6]]],
 * 
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
 * 
 * @author xiaoyue
 *	
 * 思路：
 * iterator 的要点：
 * 构造器初始化全局变量： 通常为一个容器存放数据
 * hasNext 判断该容器是否还有有效数据，
 * next 返回当前有效数据，并将其从容器中删除
 * 
 */

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 */
interface NestedInteger {
	
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
 	public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
 	public Integer getInteger();

     // @return the nested list that this NestedInteger holds, if it holds a nested list
     // Return null if this NestedInteger holds a single integer
     public List<NestedInteger> getList();
 }

public class _341_FlattenNestedListIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack;
    public _341_FlattenNestedListIterator(List<NestedInteger> nestedList) {
        stack = new Stack<NestedInteger>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {

        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            NestedInteger cur = stack.pop();
            List<NestedInteger> ls = cur.getList();
            for (int i = ls.size() - 1; i >= 0; i--) {
                stack.push(ls.get(i));
            }
        }
        
        
        return !stack.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
