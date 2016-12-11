package dynamicProgramming;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 
 * @author xiaoyue
 * 
 * A frog is crossing a river. The river is divided into x units and at each unit there may or may not exist a stone. 
 * The frog can jump on a stone, but it must not jump into the water.
 * 
 * Given a list of stones' positions (in units) in sorted ascending order, 
 * determine if the frog is able to cross the river by landing on the last stone. 
 * Initially, the frog is on the first stone and assume the first jump must be 1 unit.
 * 
 * If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. 
 * Note that the frog can only jump in the forward direction.
 * 
 * Note:
 * 
 * The number of stones is ≥ 2 and is < 1,100.
 * Each stone's position will be a non-negative integer < 231.
 * The first stone's position is always 0.
 * Example 1:
 * 
 * [0,1,3,5,6,8,12,17]
 * 
 * There are a total of 8 stones.
 * The first stone at the 0th unit, second stone at the 1st unit,
 * third stone at the 3rd unit, and so on...
 * The last stone at the 17th unit.
 * 
 * Return true. The frog can jump to the last stone by jumping 
 * 1 unit to the 2nd stone, then 2 units to the 3rd stone, then 
 * 2 units to the 4th stone, then 3 units to the 6th stone, 
 * 4 units to the 7th stone, and 5 units to the 8th stone.
 * Example 2:
 * 
 * [0,1,2,3,4,8,9,11]
 * 
 * Return false. There is no way to jump to the last stone as 
 * the gap between the 5th and 6th stone is too large.
 * 
 * 题目：
 * 给一个数组，判断能否从第一个数到达最后一个数，初始步数为1，下一次能移动的步数为上一次步数-1，相等或+1
 * 
 * 思路，用hashmap, key存存在的石头，val存到达这个石头跳跃的步数
 * 遍历石头
 * 最后一个石头的set值大于0则为true
 *
 */

public class _403_FrogJump {

    public boolean canCross(int[] stones) {
        
        if (stones[0] + 1 != stones[1]) return false;
        
        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
        for (int stone: stones) map.put(stone, new HashSet<Integer>());
        
        map.get(stones[1]).add(1);
       
        
        for (int i = 1; i < stones.length; i++) {
            int stone = stones[i];
            HashSet<Integer> steps = map.get(stone);
            if (steps.size() > 0) {
                for (int step: steps) {
                    for (int j = step - 1; j <= step + 1; j++) {
                        if (stone + j <= stone) continue;
                        if (map.containsKey(stone + j)) {
                            map.get(stone + j).add(j);
                        }
                    }

                }
            }
        }
        
        return map.get(stones[stones.length - 1]).size() > 0;
        
    }
}
