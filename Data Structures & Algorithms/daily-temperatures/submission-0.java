// 1  4  1  2  1  0  0

// 30 38 30 36 35 40 28
//28 40 35 36 30

// 
/*

28 40 35
*/
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int[] value = new int[temperatures.length];
        Stack<Integer> st = new Stack();
        for(int i = 0; i < temperatures.length ; i++){
            if(st.isEmpty() || temperatures[st.peek()] > temperatures[i]){
                st.push(i);
                System.out.println(st);
            }else{
                while(!st.isEmpty() && temperatures[st.peek()]< temperatures[i]){
                    int index = st.pop();
                    value[index] =  i-index;
                }
                st.push(i);
            }
        }
        System.out.println(st);
        while(st.isEmpty()){
            int index = st.pop();
            value[index] = 0;
        }
        return value;
    }
}
