class Solution {
    // odd number turns are for Alice
    public int maxStonesAliceCanTake(int[] piles, int start, int end, int turn, HashMap<String, Integer> map) {
        StringBuilder sb = new StringBuilder();
        String key = sb.append(start).append("-").append(end).append("-").append(turn).toString();
        if (map.containsKey(key))
            return map.get(key);
        int res = 0;
        if (end - start + 1 == 2)
            res = Math.max(piles[start], piles[end]);
        else if (turn % 2 == 1)
            res = Math.max(piles[start] + maxStonesAliceCanTake(piles, start + 1, end, turn + 1, map),
                    piles[end] + maxStonesAliceCanTake(piles, start, end - 1, turn + 1, map));
        else
            res = Math.max(maxStonesAliceCanTake(piles, start + 1, end, turn + 1, map),
                    maxStonesAliceCanTake(piles, start, end - 1, turn + 1, map));
        map.put(key, res);
        return res;
    }

    public boolean stoneGame(int[] piles) {
        int sum = 0;
        for (int pile : piles)
            sum += pile;
        HashMap<String, Integer> map = new HashMap<>();
        int aliceStone = maxStonesAliceCanTake(piles, 0, piles.length - 1, 1, map);
        return sum - aliceStone < aliceStone;
    }
}