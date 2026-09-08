class Solution {
    public int countCommas(int n) {
        int ans=0;
        if(n<1000) return 0;
        int num = n-1000+1;
        ans = num;
        return ans;
    }
}