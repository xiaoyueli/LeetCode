package design;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author xiaoyue
 * 
 * 
 * 汉诺塔移盘子
 * 思路:
 * 递归算法,逆向思维
 * 每次考虑移动第n个盘子时，需要把它上面的第n-1个盘子移到其他地方去
 * 然后再移动第n个盘子到目标塔
 * 再把n-1个盘子从other移动到目标塔
 * 
 * 当n == 1时，可以直接移动盘子
 * 
 * 根绝传入的塔号计算other 的塔号
 * 
 * 
 *
 */

public class MoveDisks {
    
    List<Stack<Integer>> towers;
    int disks;
    public MoveDisks(int numOfDisks) {
        
        towers = new ArrayList<Stack<Integer>>();
        disks = numOfDisks;
        
        for (int idx = 0; idx < numOfDisks; idx++) towers.add(new Stack<Integer>());
        
        Stack<Integer> tower1 = towers.get(0);
        while (numOfDisks > 0) {
            tower1.push(numOfDisks--);
        }
        
    }
    
    public void moveFromTo(int t1, int t2) {
        
        Stack<Integer> from = towers.get(t1- 1); 
        
        if (from.isEmpty()) return;
        
        int size = from.size();
 
        moveHelper(size, t1, t2);
        
    }
    
    private void moveHelper(int num, int from, int to) {
        
        Stack<Integer> tFrom = towers.get(from - 1);
        Stack<Integer> tTo = towers.get(to - 1);
        if (num == 1) {
            tTo.push(tFrom.pop());
            return;
        }
        
        int other = 6 - from - to;
        moveHelper(num - 1, from, other);
        tTo.push(tFrom.pop());
        moveHelper(num - 1, other, to);
    }
    
    public void print(int num) {
        Stack<Integer> tower = towers.get(num - 1);
        
        if (tower.isEmpty()) System.out.println("-1");
        else {
            for (int i: tower) System.out.print(i + " ");
            System.out.println();
        }

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        MoveDisks test = new MoveDisks(10);
        test.print(1);
        test.print(2);
        test.print(3);
        test.moveFromTo(1, 3);
        test.print(1);
        test.print(2);
        test.print(3);
        

    }

}
