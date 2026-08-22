class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0;
        int product=1;
        int temp=n;
        while(temp>0){
            int digit=temp%10;
            sum+=digit;
            product*=digit;
            temp=temp/10;
        }
        int res=sum+product;
        if(n%res==0) return true;
        return false;
    }
}