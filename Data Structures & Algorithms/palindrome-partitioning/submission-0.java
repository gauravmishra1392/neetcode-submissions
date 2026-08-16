class Solution {
    public List<List<String>> partition(String s) {
     List<List<String>> list = new ArrayList();
     List<String> newList = new ArrayList();
        rec(s,s.length(),list,0,newList);
        return list;
    }

    private boolean isPalindrome(String sb){
        if (sb.length() <= 1) { // Fixed: Handle empty string as well
            return true;
        }
        int start = 0 ;
        int end = sb.length()-1;
        while(start<end){
            if(sb.charAt(start) == sb.charAt(end)){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }

public void rec(String s,int n,List<List<String>> list,int start,List<String> newList){
        if(start == n){
           list.add(new ArrayList(newList)); 
           return;
        }
        for(int i=start;i<s.length();i++){
            if(isPalindrome(s.substring(start,i+1))){
                newList.add(s.substring(start,i+1));
                rec(s,s.length(),list,i+1,newList);
                newList.remove(newList.size()-1);
            }
        }
    }
}