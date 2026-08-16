class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int start = 0;
        int end = Arrays.stream(piles).max().getAsInt(); 
        while(start<=end){
            int mid =  (end+start)/2;
            System.out.println(mid);
            int sum =0;
            for(int i= 0;i<piles.length;i++){
                sum += Math.ceil((double)piles[i]/mid);
            }  
           
            if(sum>h){
               
                start = mid + 1;
            }else{
                 end =  mid - 1;
            }

        }
        return start;
    }
}