class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int row = 0;
        int col = colLength-1;

        while(row <= rowLength-1  &&  col>=0){
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col]< target){
                 row++;
            }else{
                 col--;
            }

        }
        return false;
    }
}
