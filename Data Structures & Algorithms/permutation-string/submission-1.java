class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int s1f[] = new int[26];

        int s2f[] = new int[26];

        for(int i = 0;i< s1.length();i++){
            s1f[s1.charAt(i)- 'a']++;
        }
        int left =0 ;
        for(int right=0;right<s2.length();right++){

            s2f[s2.charAt(right) - 'a']++;

            while(right-left+1 > s1.length()){
                 s2f[s2.charAt(left) - 'a']--;
                 left++;
            }
           
           if(isSame(s2f,s1f)){
                return true;
           }

        }
        return false;

    }

    boolean isSame(int[] s1f,int[] s2f){
        for(int i=0;i<26;i++){
            if(s1f[i] != s2f[i]){
                return false;
            }
        }
        return true;
    }
}
