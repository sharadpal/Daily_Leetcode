class Solution {
    public int distinctSubseqII(String s) {
        final long mod = 1000000007L;
        
        long dp = 1;
        long[] l_digit = new long[26];
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            long oldDp = dp;
            dp = (2 * dp - l_digit[index] + mod) % mod;
            l_digit[index] = oldDp;
        }
        
        return (int)((dp - 1 + mod) % mod);
    }
}