// OUZODYXAZV     XYZ
// 

class Solution {
    public String minWindow(String s, String t) {

       int pattern[] = new int[128];
       int freq = 0;
       int left = 0;
       int index = 0;
       int minValue = Integer.MAX_VALUE;

       for(int i=0; i<t.length(); i++){
         
          pattern[t.charAt(i)]++;
          freq++;
       }

       for(int right = 0; right < s.length(); right++){

        if(pattern[s.charAt(right)]>0){
           freq--;
        }
        pattern[s.charAt(right)]--;
        while(freq==0){

            if(right-left+1 < minValue){
               minValue = right - left +1;
               index = left;
            }
         
            if(pattern[s.charAt(left)]==0){
                freq++;
            }
            pattern[s.charAt(left)]++;
            left++;
        }

          
       }
      return  minValue == Integer.MAX_VALUE ? "" : s.substring(index, index + minValue);

    }
}
