class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character,Integer> map = new HashMap();
        for(int i=0;i<s.length();i++){
            map.computeIfAbsent(s.charAt(i),key->0);
            map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        }
        System.out.println(map);
        for(int i=0;i<t.length();i++){
            if(map.containsKey(t.charAt(i)) ){
                int val = map.get(t.charAt(i));
                val = val - 1 ;
                if(val ==0){
                    map.remove(t.charAt(i));
                }else{
                    map.put(t.charAt(i),val);
                }
            }else{
                return false;
            }
        }
        System.out.println(map);
        if(map.size()==0){
            return true;
        }else{
            return false;
        }
    }
}
