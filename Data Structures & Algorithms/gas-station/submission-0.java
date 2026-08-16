public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0, currTank = 0, startStation = 0;

        for (int i = 0; i < gas.length; i++) {
            int gain = gas[i] - cost[i];
            totalTank += gain;
            currTank += gain;

            // If tank is negative, cannot start from current startStation
            if (currTank < 0) {
                startStation = i + 1;
                currTank = 0;
            }
        }

        return totalTank >= 0 ? startStation : -1;
    }
}
