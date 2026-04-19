class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Find the row number
        int low = 0, high = matrix.length - 1, row = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[mid][0] == target)
                return true;
            if (target > matrix[mid][0]) {
                low = mid + 1;
                row = mid;
            } else {
                high = mid - 1;
                row = mid - 1;
            }
        }
        if (row == -1)
            return false;
        low = 0;
        high = matrix[0].length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[row][mid] == target)
                return true;
            if (target > matrix[row][mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }
}

