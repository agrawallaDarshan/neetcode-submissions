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
    public int solution(List<Job> jobs, int index, int nextAvailableSlot, HashMap<String, Integer> map) {
        // System.out.println("index = " + index + ", nextAvailableSlot = " + nextAvailableSlot);
        if (index == jobs.size())
            return 0;
        StringBuilder sb = new StringBuilder();
        String key = sb.append(index).append("-").append(nextAvailableSlot).toString();
        if (map.containsKey(key))
            return map.get(key);
        if (jobs.get(index).startTime >= nextAvailableSlot)
            map.put(key, Math.max(jobs.get(index).profit + solution(jobs, index + 1, jobs.get(index).endTime, map),
                    solution(jobs, index + 1, nextAvailableSlot, map)));
        else
            map.put(key, solution(jobs, index + 1, nextAvailableSlot, map));
        return map.get(key);
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < startTime.length; i++)
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        Collections.sort(jobs, (a, b) -> a.startTime - b.startTime);
        HashMap<String, Integer> map = new HashMap<>();
        return solution(jobs, 0, 0, map);
    }
}