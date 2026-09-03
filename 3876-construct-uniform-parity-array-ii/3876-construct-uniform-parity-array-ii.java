class Solution {
    public boolean uniformArray(int[] nums1) {
        int minOdd = Integer.MAX_VALUE;
        int minEven = Integer.MAX_VALUE;

        for (int a : nums1) {
            if (a % 2 == 0) {
                minEven = Math.min(minEven, a);
            } else {
                minOdd = Math.min(minOdd, a);
            }
        }

        if (minOdd == Integer.MAX_VALUE) {
            return true;
        }

        return minOdd < minEven;
    }
}