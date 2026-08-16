class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return list;

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Traverse from left to right
            for (int col = left; col <= right; col++) {
                list.add(matrix[top][col]);
            }
            top++;

            // Traverse from top to bottom
            for (int row = top; row <= bottom; row++) {
                list.add(matrix[row][right]);
            }
            right--;

            // Traverse from right to left, only if row bounds are valid
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    list.add(matrix[bottom][col]);
                }
                bottom--;
            }

            // Traverse from bottom to top, only if column bounds are valid
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    list.add(matrix[row][left]);
                }
                left++;
            }
        }

        return list;
    }
}
