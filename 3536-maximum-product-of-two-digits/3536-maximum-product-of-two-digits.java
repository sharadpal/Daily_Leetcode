class Solution {
    public int maxProduct(int n) {
        
        int temp=n;
        int count=0;
        while(temp>0){
            count++;
            temp=temp/10;
        }
        int arr[]=new int[count];
        temp=n;
        int i=0;
        while(temp>0){
            int digit= temp%10;
            arr[i++]=digit;
            temp=temp/10;
        }
        Arrays.sort(arr);
        int ans= arr[arr.length-1]*arr[arr.length-2];
        return ans;
    }
}