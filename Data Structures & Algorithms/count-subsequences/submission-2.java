// (c)aa(at) 
// cat
// caaat

class Solution {
    public int numDistinct(String s, String t) {
        int dp[][] = new int[s.length()][t.length()];
        
        for(int i=0;i<s.length();i++){
            for(int j=0;j<t.length();j++){
                dp[i][j] = -1; 
            }
        }

        return dfs(s,t,0,0,dp);
    }

    int dfs(String s,String t,int slen,int tlen,int dp[][]){
        if(tlen == t.length()){
           return 1;
        }

        if(slen == s.length()){
           return 0;
        }
        if(dp[slen][tlen]!=-1){
            return dp[slen][tlen];
        }

        int count =0;
        if(s.charAt(slen) == t.charAt(tlen)){
           count += dfs(s,t,slen+1,tlen+1,dp);
        }
        
        count += dfs(s,t,slen+1,tlen,dp);
       return dp[slen][tlen] = count; 

    }
}
