// "XYYX"
// XYYX
// AAABABB 
// AAABABB -> k=1

class Solution {
    public int characterReplacement(String s, int k) {
        Set<Character> set = new HashSet();

        for(int i=0;i<s.length();i++){
            set.add(s.charAt(i));
        }
    int maxLen = Integer.MIN_VALUE;
        for(Character c: set){
            int count = 0;
            int start = 0;
            for(int end = 0 ; end< s.length() ; end++){
                if(c.equals(s.charAt(end))){
                    count++;
                }
                while(!isValid(start,end,count,k)){
                    if(c.equals(s.charAt(start))){
                        count--; 
                    }
                    start++;
                }
                maxLen = Math.max(maxLen,end+1-start);
            }
        }
        return maxLen;  
    }

    boolean isValid(int start, int end, int count, int k){
        return (end-start+1-count<=k);
    }
}
