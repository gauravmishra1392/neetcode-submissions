// ([])
//]()[]
// ([])
// ((
//))


class Solution {

    
    public boolean isValid(String s) {
    Map<Character,Character> map = new HashMap();
    map.put(')','(');
    map.put('}','{');
    map.put(']','[');
        Stack<Character> st = new Stack();
        for(int i = 0; i < s.length(); i++){
           char currentChar = s.charAt(i);

           if(!map.containsKey(currentChar)){
                st.push(currentChar);
           }else{
             if(st.isEmpty()){
                return false;
             }
             if(st.peek() == map.get(currentChar)){
                st.pop();
             }else{
                return false;
             }
           }

        }

        if(st.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
