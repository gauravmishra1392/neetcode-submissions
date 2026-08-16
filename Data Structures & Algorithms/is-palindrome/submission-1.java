class Solution {
    boolean isNonAlphaNumeric(char c){
        return !((c>='a' && c<='z') 
        || (c>='A' && c<='Z') || (c>='0' && c<='9') );
    }
    public boolean isPalindrome(String s) {
        int start=0;
        int end = s.length()-1;

        while(start<end){
            if(isNonAlphaNumeric(s.charAt(start))){
                start++;
            }
             if(isNonAlphaNumeric(s.charAt(end))){
                end--;
            }
            System.out.println((s.charAt(start)+"").toLowerCase() +" "+
                (s.charAt(end)+"").toLowerCase());

            if(!isNonAlphaNumeric(s.charAt(end)) && !isNonAlphaNumeric(s.charAt(start))){
                
            if((s.charAt(start)+"").toLowerCase().equals((s.charAt(end)+"").toLowerCase())){
                
                start++;
                end--;
            }else{
                return false;
            }
            }
             
        }
       return true;
    }
}
