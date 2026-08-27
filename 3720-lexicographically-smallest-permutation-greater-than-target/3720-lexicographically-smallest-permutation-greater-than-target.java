class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        char[] ans = new char[n];

        for (int i = 0; i < n; i++) {
            int t = target.charAt(i) - 'a';

            // We can continue matching target
            if (freq[t] > 0) {
                ans[i] = target.charAt(i);
                freq[t]--;
            } else {
                // Cannot match target[i].
                // First try making THIS position greater.
                String res = makeGreater(ans, i, freq, target);
                
                if (!res.isEmpty()) {
                    return res;
                }

                // If impossible, backtrack to previous positions.
                for (int j = i - 1; j >= 0; j--) {
                    freq[ans[j] - 'a']++;

                    res = makeGreater(ans, j, freq, target);

                    if (!res.isEmpty()) {
                        return res;
                    }
                }

                return "";
            }
        }

        // Entire target was matched exactly.
        // Need a strictly greater permutation.
        for (int i = n - 1; i >= 0; i--) {
            freq[ans[i] - 'a']++;

            String res = makeGreater(ans, i, freq, target);

            if (!res.isEmpty()) {
                return res;
            }
        }

        return "";
    }

    private String makeGreater(char[] ans, int pos,
                               int[] freq, String target) {

        int t = target.charAt(pos) - 'a';

        // Find the smallest available character > target[pos]
        for (int c = t + 1; c < 26; c++) {

            if (freq[c] > 0) {
                ans[pos] = (char) ('a' + c);
                freq[c]--;

                // Remaining characters should be sorted
                // to make the result lexicographically smallest.
                int idx = pos + 1;

                for (int ch = 0; ch < 26; ch++) {
                    while (freq[ch] > 0) {
                        ans[idx++] = (char) ('a' + ch);
                        freq[ch]--;
                    }
                }

                return new String(ans);
            }
        }

        return "";
    }
}