class Solution {
    public String minWindow(String s, String t) {
    
        int counter = t.length();
        int freq[] = new int[128];
        int min = Integer.MAX_VALUE;
        int left =0;
        int start = 0;
        for(int i = 0 ; i< t.length() ; i++){
            freq[t.charAt(i)]++;
        }

        for(int right = 0;right < s.length() ; right++){
          
            if(freq[s.charAt(right)]>0){
                counter--;
            }

            freq[s.charAt(right)]--;
            while(counter  == 0){
              if(right - left < min){
                min = right-left+1;
                start = left;
              }  
              freq[s.charAt(left)]++;
              if(freq[s.charAt(left)]>0){
              counter++;
              }
              left++;
            }

        }

        return min == Integer.MAX_VALUE ? "":
        s.substring(start,start+min);
    }
}
