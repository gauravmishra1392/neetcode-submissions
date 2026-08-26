class Solution {
    int dp[][] ;
    public int numDistinct(String s, String t) {

        int n = t.length();
        int m = s.length();

        int arr[][] = new int[m+1][n+1];
        
        for(int i=0;i<=m;i++){
            arr[i][0] = 1;
        }

        for(int i=1 ;i <=m ;i++){
            for(int j=1;j<=n;j++){
                arr[i][j] = arr[i-1][j];
                if(s.charAt(i-1) == t.charAt(j-1)){
                    arr[i][j] += arr[i-1][j-1];
                }
            }
        }  
        return arr[m][n];
    }
}
