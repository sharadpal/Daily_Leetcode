class Solution {
    public int longestSubsequence(int[] nums) {
        if(nums.length==0) return 0;
        int count=0;
        int xor=0;
        for(int i=0;i<nums.length;i++){
            xor^=nums[i];
            if(nums[i]==0) count++;
        }
        if(xor!=0) return nums.length;
        else{
            if(count==nums.length) return 0;
            return nums.length-1;
        }
    }
}