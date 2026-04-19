class Solution {
    public int maximumCoins(List<Integer> balloons) {
        if (balloons.size() == 1)
            return balloons.get(0);
        if (balloons.size() == 2)
            return balloons.get(0) * balloons.get(1) + Math.max(balloons.get(0), balloons.get(1));
        int maximumCoinsEarned = -1;
        for (int i = 0; i < balloons.size(); i++) {
            int coins = balloons.get(i);
            if (i + 1 < balloons.size())
                coins *= balloons.get(i + 1);
            if (i - 1 >= 0)
                coins *= balloons.get(i - 1);
            List<Integer> remainingBalloons = new ArrayList<>(balloons);
            remainingBalloons.remove(i);
            maximumCoinsEarned = Math.max(maximumCoinsEarned, coins + maximumCoins(remainingBalloons));
        }
        return maximumCoinsEarned;
    }

    public int maxCoins(int[] nums) {
        List<Integer> balloons = new ArrayList<>();
        for (int num : nums)
            balloons.add(num);
        return maximumCoins(balloons);
    }
}