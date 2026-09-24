class Solution {
    public String minWindow(String s, String t) {
    int pattern[] =new int[128];
        
    int freq = t.length();
    int left = 0;
    int min = Integer.MAX_VALUE;
    int start = 0;

    for(int i=0 ; i<t.length();i++){
            pattern[t.charAt(i)]++;
    }

       for(int right = 0 ; right < s.length() ; right++){

           if(pattern[s.charAt(right)] > 0){
               freq--;
           }

            pattern[s.charAt(right)]--;
            
            while(freq == 0){
               
                if(right - left + 1 < min){
                    min   = right - left + 1;
                    start = left;
                }

                if(pattern[s.charAt(left)] == 0){
                    freq++;
                }
                pattern[s.charAt(left)]++;
                left++;
            }
       }
       System.out.println(start +" "+ start+min);
      return min == Integer.MAX_VALUE ?  "" : s.substring(start, start+min);
    }
}
