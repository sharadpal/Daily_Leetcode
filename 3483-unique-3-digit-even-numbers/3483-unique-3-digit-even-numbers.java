class Solution {
    public int totalNumbers(int[] digits) {
        int freq[]= new int[10];
        for(int digit: digits){
            freq[digit]++;
        }
        int count=0;
        for(int i=100;i<=999;i++){
            if(i%2!=0) continue;

            int n=i;
            int a=n%10;
            n/=10;
            int b=n%10;
            n/=10;
            int c=n%10;

            int []copies= new int[10];
            copies[a]++;
            copies[b]++;
            copies[c]++;

            boolean possible=true;
            for(int j=0;j<=9;j++){
                if(copies[j]>freq[j]){
                    possible=false;
                    break;
                }
            }
            if(possible) count++;
        }
        return count;
    }
}