class Solution {
    public String longestPalindrome(String s) {
        String sol = "";
        int max = 0;
        for(int i=0;i<s.length();i++){
          String even = expandAroundCorner(i,i+1,s);
            if(even.length()>max){
                max= even.length();
                sol=even;
            }
          String odd = expandAroundCorner(i,i,s);
            if(odd.length()>max){
                max= odd.length();
                sol=odd;
            }
        }
        return sol;
    }

    String expandAroundCorner(int left,int right,String s){
        while(left>=0 && right<s.length()
         && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }
}
