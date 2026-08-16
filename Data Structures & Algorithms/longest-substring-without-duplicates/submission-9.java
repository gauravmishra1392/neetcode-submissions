class Solution {
    public int lengthOfLongestSubstring(String s) {
     if(s.length() == 0){
        return 0;
     }   
     int start = 0;
     int end = s.length()-1;
     int len = -1;
        Map<Character,Integer> map = new HashMap();
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i)) != null && map.get(s.charAt(i))>=start){
                start = map.get(s.charAt(i))+1;
            }
            len = Math.max(len,i-start+1);
            System.out.println(len+" "+ start+" "+i);
            map.put(s.charAt(i),i);
        }
        return len;
    }
}
