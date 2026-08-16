/*

ab

eidbaooo

*/
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int cFreq[] = new int[26];
        int sFreq[] = new int[26];

        for(int i=0; i<s1.length(); i++){
            cFreq[s1.charAt(i)-'a']++;
        }
    int start =0;
        for(int right=0; right<s2.length(); right++){

            sFreq[s2.charAt(right)-'a']++;

            while(right - start + 1 > s1.length()){
            
                sFreq[s2.charAt(start)-'a']--;
                start++;
            }
            if(isSame(sFreq,cFreq)){
                return true;
            }
        }
        return false;
    }

    boolean isSame(int sFreq[],int cFreq[]){
      for(int i=0 ;i< 26 ;i++){
            if(sFreq[i] != cFreq[i]){
                return false;
            }
      }
      return true;
    }
    
}