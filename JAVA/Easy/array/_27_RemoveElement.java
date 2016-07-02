package array;

/**
 * Given an array and a value, remove all instances of that value 
 * in place and return the new length.
 * Do not allocate extra space for another array, you must do this 
 * in place with constant memory.
 * The order of elements can be changed. It doesn't matter what 
 * you leave beyond the new length.
 * 
 * Example:
 * Given input array nums = [3,2,2,3], val = 3
 * 
 * Your function should return length = 2, with the first two elements of nums being 2.
 */
public class _27_RemoveElement {
	
	
	public int removeElement(int[] nums, int val){
        int front = 0;
		int rear = nums.length - 1;
		
		while(front <= rear){
		    
			if(nums[front] == val){
				nums[front] = nums[rear--];
			}
			else{
				front ++;
			}
			
		}
		
		return rear + 1;
	}
	
	public void printArray(int[] array){
		System.out.print("[ ");
		for(int idx = 0; idx < array.length; idx ++){
			System.out.print(array[idx] + " ");
		}
		System.out.println("]");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		_27_RemoveElement test = new _27_RemoveElement();
		int length = 20;
		int[] array = new int[length];
		for(int idx = 0; idx < length; idx ++){
			array[idx] = (int)(Math.random() * 10);
		}
		int re_num = array[(int)(Math.random() * length)];
		
		System.out.println("Array:");
		test.printArray(array);
		System.out.println("Number be removed : " + re_num);		
		System.out.println("Old: " + length + "  New: " + test.removeElement(array, re_num));

	}

}
