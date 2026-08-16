
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Use TreeMap to store lists of points by their distance
        TreeMap<Double, List<int[]>> map = new TreeMap<>();
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());

        // Process each point
        for (int[] point : points) {
            double dist = Math.sqrt(point[0] * point[0] + point[1] * point[1]);
            pq.add(dist);
            map.computeIfAbsent(dist, val -> new ArrayList<>()).add(point);

            // Keep only the k closest distances
            if (pq.size() > k) {
                double farthest = pq.poll();
                map.remove(farthest); // Remove the farthest distance
            }
        }

        // Collect k closest points
        List<int[]> resultList = new ArrayList<>();
        for (double key : map.keySet()) {
            for (int[] p : map.get(key)) {
                if (resultList.size() < k) {
                    resultList.add(p);
                }
            }
        }

        // Convert to int[][] array
        return resultList.toArray(new int[k][2]);
    }
}
