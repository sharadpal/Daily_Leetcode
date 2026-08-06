class Solution {
    public int smallestNumber(int n, int t) {
        int temp=n;
        int product=1;
        boolean pal=true;
        while(pal!=false){
            while(temp>0){
                int digit=temp%10;
                product*=digit;
                temp/=10;
            }
            if(product%t==0){
                pal=false;
                return n;
            }
            else temp=n+1;
            n=temp;
            product=1;
        }
        return -1;
    }
}