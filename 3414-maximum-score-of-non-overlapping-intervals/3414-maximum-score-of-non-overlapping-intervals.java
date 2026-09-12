import java.util.*;

class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        
        int[][] a = new int[n][4];
        for (int i = 0; i < n; i++) {
            List<Integer> list = intervals.get(i);
            a[i] = new int[]{list.get(0), list.get(1), list.get(2), i};
        }
        Arrays.sort(a, (x, y) -> Integer.compare(x[0], y[0]));

        long[][] dpW = new long[n + 1][5];
        int[][][] dpId = new int[n + 1][5][];
        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) dpId[i][k] = new int[0];
        }

        for (int i = n - 1; i >= 0; i--) {
            int l = i + 1, r = n;
            while (l < r) {
                int mid = (l + r) / 2;
                if (a[mid][0] > a[i][1]) r = mid;
                else l = mid + 1;
            }
            int nxt = l;
            for (int k = 1; k <= 4; k++) {
                dpW[i][k] = dpW[i + 1][k];
                dpId[i][k] = dpId[i + 1][k];
 
                long pW = a[i][2] + dpW[nxt][k - 1];
                int[] prev = dpId[nxt][k - 1];
                int[] pId = Arrays.copyOf(prev, prev.length + 1);
                pId[prev.length] = a[i][3];
                Arrays.sort(pId);
                if (pW > dpW[i][k] || (pW == dpW[i][k] && Arrays.compare(pId, dpId[i][k]) < 0)) {
                    dpW[i][k] = pW;
                    dpId[i][k] = pId;
                }
            }
        }
        return dpId[0][4];
    }
}