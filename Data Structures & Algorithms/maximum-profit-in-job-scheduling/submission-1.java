class Job {
    int startTime;
    int endTime;
    int profit;

    Job(int startTime, int endTime, int profit) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.profit = profit;
    }
}

class Solution {
    public int nextEligibleJob(List<Job> jobs, int start, int target) {
        int end = jobs.size() - 1, result = jobs.size();
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (jobs.get(mid).startTime >= target) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    public int solution(List<Job> jobs, int index, int[] dp) {
        if (index == jobs.size())
            return 0;
        if (dp[index] > 0)
            return dp[index];
        dp[index] = Math.max(
                jobs.get(index).profit + solution(jobs, nextEligibleJob(jobs, index, jobs.get(index).endTime), dp),
                solution(jobs, index + 1, dp));
        return dp[index];
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < startTime.length; i++)
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        Collections.sort(jobs, (a, b) -> a.startTime - b.startTime);
        int[] dp = new int[startTime.length];
        return solution(jobs, 0, dp);
    }
}