// 1 5 10
// 12
// 10 1 1
// 12 - 1, 12 - 1
/*
1 5 10 , 12

*/
class Solution {
    
    public int coinChange(int[] coins, int amount) {
        
        int amounts[] = new int[amount + 1];
        Arrays.fill(amounts, amount+1);
        amounts[0] = 0;
        for(int i = 1 ; i<=amount; i++){
            for(int coin : coins){
              if(i - coin >= 0){
               amounts[i] = Math.min(amounts[i],
               1 + amounts[i - coin]); 
              }
            }
        }

        return amounts[amount] == amount+1?-1:amounts[amount];
    }

}
