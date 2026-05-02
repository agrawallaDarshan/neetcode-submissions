class Room {
    int id;
    long nextAvailableTime;

    Room(int index, long end) {
        id = index;
        nextAvailableTime = end;
    }
}

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] result = new int[n];
        PriorityQueue<Room> rooms = new PriorityQueue<>((a, b) -> Integer.compare(a.id, b.id));
        PriorityQueue<Room> occupied = new PriorityQueue<>((a, b) -> {
            if (a.nextAvailableTime != b.nextAvailableTime)
                return Long.compare(a.nextAvailableTime, b.nextAvailableTime);
            return Integer.compare(a.id, b.id);
        });

        for (int i = 0; i < n; i++)
            rooms.add(new Room(i, 0));

        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        for (int[] meeting : meetings) {
            long startTime = meeting[0];
            long endTime = meeting[1];

            while (!occupied.isEmpty() && occupied.peek().nextAvailableTime <= startTime)
                rooms.add(occupied.poll());

            if (!rooms.isEmpty()) {
                Room booked = rooms.poll();
                booked.nextAvailableTime = endTime;
                occupied.add(booked);
                result[booked.id]++;
            } else {
                Room pullOccupiedRoomWithDelay = occupied.poll();
                long delay = pullOccupiedRoomWithDelay.nextAvailableTime - startTime;
                pullOccupiedRoomWithDelay.nextAvailableTime = endTime + delay;
                occupied.add(pullOccupiedRoomWithDelay);
                result[pullOccupiedRoomWithDelay.id]++;
            }
        }
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (result[i] > result[ans])
                ans = i;

        }
        return ans;
    }
}