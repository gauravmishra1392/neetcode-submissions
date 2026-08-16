class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] weights = new int[n];
        Arrays.fill(weights, Integer.MAX_VALUE);
        weights[src] = 0;

        for (int i = 0; i <= k; i++) {

            int[] temp = Arrays.copyOf(weights, n);  // FIX

            for (int j = 0; j < flights.length; j++) {
                int start = flights[j][0];
                int end = flights[j][1];
                int cost = flights[j][2];

                if (weights[start] == Integer.MAX_VALUE) continue; // prevent overflow

                int newWeight = weights[start] + cost;

                if (newWeight < temp[end]) {  // FIX: use temp, NOT weights
                    temp[end] = newWeight;
                }
            }

            weights = temp; // move to next iteration
        }

        return weights[dst] == Integer.MAX_VALUE ? -1 : weights[dst]; // FIX: return -1 if unreachable
    }
}
