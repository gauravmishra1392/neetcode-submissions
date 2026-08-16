/*
0 1 4 7
1 2 2 1




10
5
3
3


*/

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
      double[][] car = new double[position.length][2];
      int N = position.length;
        for(int i=0;i<N;i++){
            car[i]= 
            new double[]{(double)position[i]
            ,(double)(target-position[i])/speed[i]};
        }
        
        Arrays.sort(car,(double []a, double []b) ->  
            Double.compare(a[0],b[0]));
        double cur = 0;
        int count = 0;
        for(int i=N-1 ; i>=0 ;i-- ){
            if(car[i][1] > cur){
                cur = car[i][1];
                count++;
            }
        }
        return count;
    }
}
