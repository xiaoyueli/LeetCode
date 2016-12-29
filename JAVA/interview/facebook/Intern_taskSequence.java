package facebook;

/**
 * 
 * @author xiaoyue
 * 
 * 做了一题加上follow up.
    输入一个task序列，比如A, B, C, A, B, C
    再输入一个整数， cooldown。 cooldown 代表每个task从开始执行到结束，要多少个step才会cooldown, 在这期间同一种task没法同时执行。
    输出是，给出一个序列以后，输出需要多少step才能完成这个序列。
    
    我用了hashmap去记录每个task最后一次出现的位置，并把执行过程全部放进一个array里面。最后输出array的长度。所以memory = O（N * cooldown）, Time complexity = O(N * cooldown) in worst case.
    Follow up就是如何优化空间复杂度,  去掉执行结果的array, 直接在过程中计算长度。 Memory = O(所有distinct task)
    然后就O了。
    
    没有Bug free, 自己找出一个小bug, 面试官找出一个小bug..1point3acres缃�
    
    ----------------
    面试后自己思考了下这题，. 鍥磋鎴戜滑@1point 3 acres
    如果cooldown不大的话（比如=3），感觉可以只要一个array记住前3步是在执行什么task就可以。这样memroy = O(cooldown)
    不过这个可以算是个trade off, 因为取决于task list和cooldown的大小关系（虽然一般来说肯定是tasklist.Length >> cooldown）。
 *
 */

public class Intern_taskSequence {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
