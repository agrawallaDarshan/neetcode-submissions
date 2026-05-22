class Project {
    int profit;
    int capital;

    Project(int profit, int capital) {
        this.profit = profit;
        this.capital = capital;
    }
}

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Project> pq1 = new PriorityQueue<>((a, b) -> {
            if (a.profit != b.profit)
                return b.profit - a.profit;
            return a.capital - b.capital;
        });
        Queue<Project> projects = new LinkedList<>();
        // Initially add all of them in pq1
        for (int i = 0; i < profits.length; i++)
            pq1.add(new Project(profits[i], capital[i]));
        while (!pq1.isEmpty() && k > 0) {
            Project project = pq1.poll();
            if (project.capital <= w) {
                w += project.profit;
                k--;
                while (!projects.isEmpty())
                    pq1.add(projects.poll());
            } else {
                projects.add(project);
            }
        }
        return w;
    }
}

// k=4
// w=2
// profit=[2,3,1,5,3]
// capital=[4,4,2,3,3]
