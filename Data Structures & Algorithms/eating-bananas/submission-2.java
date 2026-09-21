class Solution {
    public int minEatingSpeed(int[] piles, int h) {
     int l = 0;
     int r = Arrays.stream(piles).max().getAsInt();
    double sum = 0;
    int mid = 0;
     while(l<=r){
        mid = (r+l)/2;
        sum = 0;
        for(int i =0 ; i< piles.length ; i++){
            sum = sum + Math.ceil(((double)piles[i]/mid));
        }
        
        if(sum > h){
            l = mid + 1;
        }else{
            r = mid - 1;
        }

     }
    
    return l;

    }
}
