class Solution {
    public int minimumCost(int[] cost) {
        int ans=0;
        int token=0;
        Arrays.sort(cost);

        for(int i=cost.length-1;i>=0;i--){
            if(token==2) token=0;
            else{
                ans+=cost[i];
                token++;
            }
        }
        return ans;
    }
}