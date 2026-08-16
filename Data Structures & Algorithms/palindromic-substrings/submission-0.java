class Solution {
    public int countSubstrings(String s) {
        int sol = 0;
        int max = 0;
        for(int i=0;i<s.length();i++){
          int even = expandAroundCorner(i,i+1,s);
          
          int odd = expandAroundCorner(i,i,s);
          sol = sol+even+odd;
        }
        return sol;
    }

    int expandAroundCorner(int left,int right,String s){
        int c=0;
        while(left>=0 && right<s.length()
         && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
            c++;
        }
        return c;
    }
}
