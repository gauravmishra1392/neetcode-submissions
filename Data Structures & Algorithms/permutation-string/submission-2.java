class Solution {
    public boolean checkInclusion(String s1, String s2) {
    
    if(s1 == null || s2 == null ||
    s1.length() > s2.length()){
        return false;
    }
     int s1Count[] = new int[26];
     int s2Count[] = new int[26];
     
     int left =0;

      for(int i=0;i<s1.length();i++){
            s1Count[s1.charAt(i)-'a']++;
      }

      
      for(int right=0;right< s2.length();right++){
            s2Count[s2.charAt(right)-'a']++;
            if(right-left+1>s1.length()){
                s2Count[s2.charAt(left)-'a']--;
                left++;
            }
           if(right-left+1 == s1.length()){
                if (compare(s1Count, s2Count)) {
                    return true; 
                }
           }
      }
    return false;
    }


    boolean compare(int[] s1Count, int[] s2Count){
        for(int i=0;i<26;i++){
            if(s1Count[i]!=s2Count[i]){
                return false;
            }
        }
        return true;
    }
}
