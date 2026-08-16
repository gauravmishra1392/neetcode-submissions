
// aaabbaaaaaa 
// aaabbaaaaa
// 4
class Solution {
    public int characterReplacement(String s, int k) {
        int rep[] = new int[26];
        int left = 0;
        int len = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for(int right = 0 ; right<s.length();right++){
            rep[s.charAt(right)-'A']++;
            max = Math.max(max,rep[s.charAt(right)-'A']);
            while(right-left+1-max > k){
                rep[s.charAt(left)-'A']--;
                left++;
            }
            len = Math.max(len,right-left+1);
        }

        return len;
    }
}
