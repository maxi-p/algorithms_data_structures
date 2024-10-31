class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int res = -1;
        int [] diff = new int[len];
        int gasSum = 0;
        int costSum = 0;
        for (int i=0; i<len; i++){
            diff[i] = gas[i] - cost[i];
            gasSum += gas[i];
            costSum += cost[i];
        }
        if (gasSum < costSum){
            return -1;
        }
        for (int i=0; i<len; i++){
            int tank = 0;
            for (int j=0; j<len; j++){
                int adjustedIndex = (i+j)%len;
                tank = tank + diff[adjustedIndex];
                if (tank < 0 || (tank == 0 && gas[adjustedIndex] == 0 && j != len-1)){
                    break;
                }
                if (j == len-1){
                    res = i;
                }
            }
        }

        return res;
    }
}
