class Solution {
    public boolean canShip(int[] weights, int days, int targetSum) {
        int sum = 0, index = 0, requiredDays = 1;
        for (int weight : weights) {
            if (weight > targetSum)
                return false;
            if (sum + weight > targetSum) {
                requiredDays++;
                sum = weight;
            } else {
                sum += weight;
            }
            if (requiredDays > days)
                return false;
        }
        return true;
    }

    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        for (int weight: weights) sum += weight;
        int low = 1, high = sum, result = sum;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canShip(weights, days, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
}