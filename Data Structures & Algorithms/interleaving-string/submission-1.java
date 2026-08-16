// aa bbbb aa

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int s1Length = s1.length();
        int s2Length = s2.length();
        int s3Length = s3.length();
        if (s1.length() + s2.length() != s3.length()) return false;

        Boolean memo[][] = new Boolean[s1Length+1][s2Length+1];
       return dfs(s1,s2,s3,0,0,s3Length,0,memo);
    }

    boolean dfs(String s1,String s2,String s3,int s1l
    ,int s2l,int s3l,int k,Boolean memo[][]){

        if (s1l == s1.length() && s2l == s2.length()) {
             return true;
        }
        if(memo[s1l][s2l] !=null){
            return memo[s1l][s2l];
        }
        boolean s1Check = false;
        boolean s2Check = false;
        if(s1l < s1.length() && s1.charAt(s1l) == s3.charAt(k)){
           s1Check = dfs(s1,s2,s3,s1l+1,s2l,s3l,k+1,memo);
        }

        if(!s1Check && s2l < s2.length() && s2.charAt(s2l) == s3.charAt(k)){
           s2Check = dfs(s1,s2,s3,s1l,s2l+1,s3l,k+1,memo);
        }
        memo[s1l][s2l] =  (s1Check || s2Check);
        return memo[s1l][s2l];
    }
}
