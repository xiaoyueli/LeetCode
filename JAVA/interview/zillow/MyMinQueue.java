package zillow;

public class MyMinQueue {
    
    int[] que;
    int size;
    public MyMinQueue() {
        que = new int[10];
        size = 0;
    }
    
    public void offer(int i) {
        
        if (size >= que.length) {
            que = resize(que, que.length * 2);
        }

        que[size] = i;
        bottomUp(que, size);
        size++;
    }
    
    public int poll() {
        if (size > 0) {
            int res = que[0];
            que[0] = que[--size];
            sink(que, size);
            if (que.length > 10 && size < que.length / 2) que = resize(que, que.length / 4 * 3);
            return res;
        }
        else return -1;
        
    }
    
    public int min() {
        if (size > 0) return que[0];
        else return -1;
    }
    
    public int[] resize(int[] nums, int len) {

        int[] copy = new int[len];
        
        for (int i = 0; i < size; i++) {
            copy[i] = nums[i];
        }
        
        return copy;
    }
    
    private void bottomUp(int[] nums, int pos) {
        int val = nums[pos];
        while (pos != 0) {
            int par = pos / 2;
            if (val < nums[par]) {
                nums[pos] = nums[par];
                pos = par;
            }
            else break;
        }
        nums[pos] = val;
    }
    
    private void sink(int[] nums, int len) {
        int pos = 0;
        int val = nums[pos];
        while (pos * 2 + 1 < len) {
            int son = pos * 2 + 1;
            if (son + 1 < len && nums[son + 1] < nums[son]) {
                son++;
            }
            if (val > nums[son]) {
                nums[pos] = nums[son];
                pos = son;
            }
            else break;
        }
        nums[pos] = val;
    }
    
    private boolean isEmpty() {
        return size == 0;
    }
    
    private void print() {
        for (int i = 0; i < size; i++) System.out.print(que[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        MyMinQueue test = new MyMinQueue();
//        test.offer(4);
//        test.offer(1);
//        test.offer(8);
//        test.offer(12);
//        test.offer(10);
//        test.offer(5);
//        test.offer(7);
//        test.offer(9);
//        test.offer(2);
//        test.offer(13);
//        test.offer(3);
//        test.offer(11);
//        test.offer(6);
//        
//
//        
//        while (!test.isEmpty()) System.out.print(test.poll() + " ");
        
        String str = "Zillow";
        
        int len = 1;
        while(true) {
            String sub = str.substring(0, len);
            if (sub.equals(str)) break;
            len++;
        }
        
        System.out.println(len);


    }

}
