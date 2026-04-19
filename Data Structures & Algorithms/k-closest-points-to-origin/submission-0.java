class Point {
    int xi, yi;

    Point(int xi, int yi) {
        this.xi = xi;
        this.yi = yi;
    }
}

class Solution {
    public double calulateDistanceFromOrigin(Point p) {
        return Math.sqrt(Math.pow(p.xi, 2) + Math.pow(p.yi, 2));
    }

    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        PriorityQueue<Point> pq = new PriorityQueue<>(
                (p1, p2) -> Double.compare(calulateDistanceFromOrigin(p2), calulateDistanceFromOrigin(p1)));
        int index = 0;
        while (index < k) {
            pq.add(new Point(points[index][0], points[index][1]));
            index++;
        }
        while (index < points.length) {
            Point point = new Point(points[index][0], points[index][1]);
            if (calulateDistanceFromOrigin(point) < calulateDistanceFromOrigin(pq.peek())) {
                pq.poll();
                pq.add(point);
            }
            index++;
        }
        index = 0;
        while (!pq.isEmpty()) {
            Point point = pq.poll();
            result[index][0] = point.xi;
            result[index][1] = point.yi;
            index++;
        }
        return result;
    }
}