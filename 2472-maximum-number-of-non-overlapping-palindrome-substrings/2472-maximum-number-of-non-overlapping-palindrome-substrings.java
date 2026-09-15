class Solution {
    public int maxPalindromes(String s, int k) {
        
        int n = s.length(), lastEnd = 0, count = 0;
        for (int i = 0; i < 2 * n; i++) {
            int left = i / 2;
            int right = left + i % 2;

            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 >= k) {
                    int end = right + 1;
                    if (left >= lastEnd) {
                        lastEnd = end;
                        count++;
                    } else {
                        lastEnd = Math.min(lastEnd, end);
                    }

                    break;
                }
                left--;
                right++;
            }
        }
        return count;
    }
}