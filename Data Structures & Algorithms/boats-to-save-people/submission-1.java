class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        if (n < 2)
            return 1;
        boolean[] visited = new boolean[n];
        int left = 0, ans = 0;
        while (left < n) {
            if (visited[left]) {
                left++;
                continue;
            }
            if (people[left] >= limit) {
                ans += n - left;
                break;
            }
            int right = n - 1;
            while (right > left) {
                if (visited[right]) {
                    right--;
                    continue;
                }
                if (people[left] + people[right] > limit)
                    right--;
                else
                    break;
            }
            if (right > left) {
                visited[left] = true;
                visited[right] = true;
            } else {
                visited[left] = true;
            }
            ans++;
            left++;
        }
        return ans;
    }
}