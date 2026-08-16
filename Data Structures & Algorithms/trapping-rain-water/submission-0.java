class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        leftMax[0] = height[0];
        for(int i=1;i<height.length;i++){
            leftMax[i]= Math.max(leftMax[i-1],height[i]);
        }

         rightMax[height.length-1] = height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
            rightMax[i]= Math.max(rightMax[i+1],height[i]);
        }
        int sum =0;
         for(int i=0;i<height.length;i++){
            System.out.print(leftMax[i]+" ");
         }
        System.out.println();
        for(int i=0;i<height.length;i++){
        System.out.print(rightMax[i]+" ");
        }
        System.out.println();
        for(int i=0;i<height.length;i++){
            sum = sum + Math.abs(height[i] - Math.min(leftMax[i],rightMax[i]));
            System.out.println(sum);
        }
        return sum;
    }
    // 0 2 0 3 1 0 1 3 2 1
    // 0 2 2 3 3 3 3 3 3 3
    // 3 3 3 3 3 3 3 3 2 1
}
