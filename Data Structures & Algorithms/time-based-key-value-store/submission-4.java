class TimeMap {
    
    Map<String,Map<Integer,String>> map;
   
    public TimeMap() {
        map = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.get(key) != null){
            Map<Integer,String> timeMap = map.get(key);
            timeMap.put(timestamp,value);
            map.put(key,timeMap);
        }else{
            Map<Integer,String> timeMap = new TreeMap();
            timeMap.put(timestamp,value);
            map.put(key,timeMap);
        }
    }
    
    public String get(String key, int timestamp) {
        Map<Integer,String> valueMap = map.get(key);
        if(valueMap == null){
            return "";
        }
        int[] valArray = valueMap.keySet()
        .stream()
        .mapToInt(Integer::intValue)
        .toArray();

        int left = 0;
        int right = valArray.length - 1;
        int answer  = -1;
        // 1 2 3 4 5
        // 10
        while(left<=right){
            int mid = (left+right)/2;
            if(valArray[mid] <= timestamp){
                left = mid+1;
                answer = mid;
            }else{
                right = mid-1;
            }
        }
        if(answer == -1){
            return "";
        }
        return valueMap.get(valArray[answer]);
    }
}
