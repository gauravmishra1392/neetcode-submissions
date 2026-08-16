class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap();
        for(String str:strs){
            char stringChar[] = str.toCharArray();
            Arrays.sort(stringChar);
            String newStr = String.valueOf(stringChar);
            List<String> list = map.computeIfAbsent(newStr,key-> new ArrayList<String>());
            list.add(str);
            map.put(newStr,list);
        }
        //List<List<String>> finalList = new ArrayList<>();

        // for(String str:map.keySet()){
        //     List<String> lst = map.get(str);
        //     finalList.add(lst);
        // }
        return new ArrayList(map.values());
    }
}
