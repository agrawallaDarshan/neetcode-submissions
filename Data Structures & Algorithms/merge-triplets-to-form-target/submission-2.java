class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        // [[2,5,3],[2,3,4],[1,2,5],[5,2,3]]
        // [[2,5,3],[1,2,5],[5,2,3]]
        int maxx = 0, maxy = 0, maxz = 0;
        for (int[] triplet: triplets) {
            if (triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]) {
                maxx = Math.max(maxx, triplet[0]);
                maxy = Math.max(maxy, triplet[1]);
                maxz = Math.max(maxz, triplet[2]);
            }
            if (maxx == target[0] && maxy == target[1] && maxz == target[2]) return true;
        }
        return false;
    }
}