class Solution {
    public void rotate(int[][] matrix) {
      //  int arr[][] = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=i+1;j<matrix.length;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i] =temp;
                System.out.print(matrix[i][j] +" ");
            }
            System.out.println();
        }
       int n =matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
             
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1]= temp;
            }
        }

    }
}

// 1 2 3
// 4 5 6
// 7 8 9