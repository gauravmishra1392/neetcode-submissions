class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int memo[][] = new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<=l1;i++){
            for(int j=0;j<=l2;j++){
                memo[i][j] = -1;
            }
        }
        return minDistanceRecur(word1,word2,0,0,memo);
        
    }

    int minDistanceRecur(String w1,String w2,int i,int j,int memo[][]){
        if(memo[i][j]!=-1){
            return memo[i][j];
        }

        if(i == w1.length()){
            return w2.length()-j;
        }

        if(j == w2.length()){
            return w1.length()-i;
        }

        if(w1.charAt(i) == w2.charAt(j)){
           return  memo[i][j] = minDistanceRecur(w1,w2,i+1,j+1,memo);
        }
        memo[i][j] = 1+  Math.min(minDistanceRecur(w1,w2,i+1,j,memo),
            Math.min(minDistanceRecur(w1,w2,i,j+1,memo),
            minDistanceRecur(w1,w2,i+1,j+1,memo)));
        
       return memo[i][j];
    }
}
