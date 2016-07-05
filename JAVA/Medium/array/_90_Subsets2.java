package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _90_Subsets2 {
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
           
           List<List<Integer>> res = new ArrayList<>();
           res.add(new ArrayList<Integer>());  // 加入空集
           
           Arrays.sort(nums);
           
           for (int idx = 0; idx < nums.length; idx++) {
               List<List<Integer>> list = new ArrayList<>();


               if (idx == 0 || nums[idx - 1] != nums[idx]) {
                   // 新加入的元素不同于前一个元素时，
                   // 同时加入原集合 和 原集合+新元素组成的新集合
                   for (List<Integer> l: res) {
                       list.add(l);
                       List<Integer> newList = new ArrayList<Integer>(l);
                       newList.add(nums[idx]);
                       list.add(newList);
                   }
               }
               else {
                   // 新加入的元素与前一个元素相同
                   for (List<Integer> l: res) {
                       if (l.contains(nums[idx])) {
                           // 如果原集合包含新的元素，在原集合中加入新元素
                           // 新生成的含重复元素的集合会依次比之前的集合多一个重复元素
                           
                           // 如果原集合是第一个包含新原元素的集合，即只含有一个新元素
                           // 同时加入原集合
                           if (l.size() > 1 && l.get(l.size() - 2) != nums[idx]) list.add(l);
                           List<Integer> newList = new ArrayList<Integer>(l);
                           newList.add(nums[idx]);
                           list.add(newList);           
                       }
                       else if (l.size() == 0){
                           list.add(l);
                           List<Integer> newList = new ArrayList<Integer>(l);
                           newList.add(nums[idx]);
                           list.add(newList);                          
                       }
                       else {
                           // 含有新元素的集合都是通过不含新元素的集合生成的
                           // 因此只添加原集合，不然会造成重复
                           list.add(l);
                       }
                   }
               }
               
               res = list;

           }
           return res;
       }
       
   }
