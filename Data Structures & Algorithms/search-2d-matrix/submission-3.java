class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int r = matrix.length;
        int c = matrix[0].length;

        int row = 0 ;
        int col = c-1 ;

        while(row < r && col >=0){
            if(matrix[row][col] < target){
                row++;
            }else if(matrix[row][col] > target){
                col--;
            }else{
                return true;
            }
        }
        return false;
    }
}
