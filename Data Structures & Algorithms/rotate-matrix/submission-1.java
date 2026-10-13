/*

 1 2 3
 4 5 6
 7 8 9


7 8 9
4 5 6
1 2 3

00 01 02
10 11 12
20 21 22

7 4 1
8 5 2
9 6 3
*/

class Solution {
    public void rotate(int[][] matrix) {
          int n = matrix.length;
          for(int i=0;i<n/2;i++){
                int[] temp = matrix[i];
                matrix[i] = matrix[n-i-1];
                matrix[n-i-1] = temp;
          }

          for(int i=0 ; i<n;i++){
                for(int j = i;j<matrix[i].length;j++){
                     int temp = matrix[j][i];
                     matrix[j][i] = matrix[i][j];
                     matrix[i][j] = temp;
                }
          }

    }
}
