class Solution {
    public int coinChange(int[] coins, int amount) {

     int arr[] = new int[amount+1];
     Arrays.fill(arr,Integer.MAX_VALUE);
     arr[0] = 0;
     for(int i=0;i<coins.length;i++){
        for(int j=0;j<=amount;j++){
            if(j-coins[i]>=0 && arr[j-coins[i]] != Integer.MAX_VALUE){
                arr[j] = Math.min(arr[j],arr[j-coins[i]]+1);
            } 
        }
     }

    for(int j=0;j<=amount;j++){
        System.out.println(arr[j]+" ");
    }
    return arr[amount] == Integer.MAX_VALUE ?-1:arr[amount];
    }
}
