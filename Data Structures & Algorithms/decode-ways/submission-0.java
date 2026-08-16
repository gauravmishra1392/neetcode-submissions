class Solution {
    public int numDecodings(String s) {
         if (s == null || s.isEmpty()) return 0;
        Map<Integer,Integer> memo = new HashMap<>();
       return decode(s,memo,0);
    }

    // 1 2 3
    // 1 
public int decode(String s,Map<Integer,Integer> memo,int index){
    if(s.length() == index){
        return 1;
    }
    if(s.charAt(index) == '0'){
        return 0;
    }
    if(memo.get(index)!=null){
        return memo.get(index);
    }
    int singleDigit = decode(s,memo,index+1);
    int twoDigit =0;
    if (index < s.length() - 1) {
    int integer = Integer.parseInt(s.substring(index,index+2));
 
    if(integer>=10 && integer<=26){
     twoDigit = decode(s,memo,index+2);
    }
    }
    memo.put(index,(singleDigit+twoDigit));
    return singleDigit+twoDigit;
}
}
