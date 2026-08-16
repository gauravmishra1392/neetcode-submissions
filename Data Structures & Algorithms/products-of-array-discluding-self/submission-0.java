class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int zeroCount = 0;
        int multiple = 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                zeroCount++;   
            }
            if(zeroCount > 1){
                break;
            }
            if(nums[i] != 0){
                 multiple*=nums[i];  
            }
           
        }

     List<Integer> list = new ArrayList();   
 
         for(int i=0;i<nums.length;i++){
            if(zeroCount>1){
            list.add(0);
            }else if(zeroCount == 1){
                if(nums[i] == 0){
                    list.add(multiple);
                }else{
                    list.add(0);
                }
            }else{
            list.add(multiple/nums[i]);
            }
        }
     

     return list.stream().mapToInt(Integer::intValue).toArray();

    }
}  
