class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        ArrayList<int[]> position1 = new ArrayList<>();
        ArrayList<int[]> position2 = new ArrayList<>();

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(img1[i][j] == 1) {
                    position1.add(new int[]{i,j});
                }
                if(img2[i][j] == 1) {
                    position2.add(new int[]{i,j});
                }
            }
        }

        int res = 0;
        HashMap<String,Integer> map = new HashMap<>();
        for(int []p1 : position1) {
            for(int []p2 : position2) {
                int r = p2[0]-p1[0];
                int c = p2[1]-p1[1];

                String d = r+","+c;
                map.put(d,map.getOrDefault(d,0)+1);

                res = Math.max(res,map.get(d));
            }
        }
        return res;
    }
}