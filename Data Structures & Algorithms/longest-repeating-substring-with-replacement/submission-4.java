
// XYYXYYXX
// X YYXYYXX
// 
// 7 - 0 + 1 - 4

class Solution {
    public int characterReplacement(String s, int k) {
        int rep[] = new int[26] ;
        int left = 0 ;
        int max = -1;
        int maxLen = -1;
        for(int right=0;right<s.length();right++){

             rep[s.charAt(right)-'A']++;
             
             max = Math.max(max,rep[s.charAt(right)-'A']);

             if(right-left+1-max>k){
                rep[s.charAt(left)-'A']--;
                left++;
             }
             maxLen = Math.max(maxLen,right-left+1);
        }

     return maxLen;
    }
}
