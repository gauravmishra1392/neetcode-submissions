class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[] = new int[26];

        for(int i =0 ;i <tasks.length ;i++){
            freq[tasks[i] - 'A']++;
        }
        int max = -1;
        for(int i = 0; i < 26 ;i++){
            max = Math.max(max,freq[i]);
        }

        int maxCount = 0;

        for(int i = 0 ;i< 26;i++){
            if(freq[i] == max){
                maxCount++;
            }
        }
      return Math.max(tasks.length, (max-1)*(n+1) + maxCount);
    }
}
