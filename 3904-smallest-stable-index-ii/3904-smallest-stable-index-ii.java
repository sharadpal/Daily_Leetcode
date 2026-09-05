class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n= nums.length;
        int minV[]=new int[n];
        minV[n-1]=nums[n-1];
        int maxV=nums[0];

        for(int i=n-2;i>=0;i--){
            minV[i]= Math.min(minV[i+1],nums[i]);
        }

        for(int i=0;i<n;i++){
            int curr=nums[i];
            maxV=Math.max(maxV,curr);
            
            if(maxV-minV[i]<=k) return i;
        }
        return -1;
    }
}