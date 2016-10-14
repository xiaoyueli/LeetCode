package greedy;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). 
 * You begin the journey with an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * 
 * Note:
 * The solution is guaranteed to be unique.
 * 
 * @author xiaoyue
 * 
 * 思路：two pointer
 * 用当前station的油量减去当前的cost，则表示能否从当前station 开去下一站
 * 如果>=0，则往前下一站
 * 否则追溯之前的station去加油. 直到总油量再次大于0，再开往下一站
 *
 */

public class _134_GasStation {
    
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int front = 0;
        int back = gas.length - 1;
        int sum = gas[back] - cost[back]; // sum 初始化为back的值，则表示，如果sum大于0则可以从back开回来，back也即为track起始station
        
        while (front < back) {
            if (sum >= 0) {
                sum += gas[front] - cost[front];
                front++;
            }
            else {
                back--;
                sum += gas[back] - cost[back];
            }
        }
        
        if (sum >= 0) return back;
        return -1;
    }

}
