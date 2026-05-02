class Room {
    int id, nextAvailableTime;

    Room(int index, int end) {
        id = index;
        nextAvailableTime = end;
    }
}

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] result = new int[n];
        PriorityQueue<Room> rooms = new PriorityQueue<>((a, b) -> {
            if (a.nextAvailableTime != b.nextAvailableTime)
                return a.nextAvailableTime - b.nextAvailableTime;
            return a.id - b.id;
        });
        PriorityQueue<Room> occupied = new PriorityQueue<>((a, b) -> {
            if (a.nextAvailableTime != b.nextAvailableTime)
                return a.nextAvailableTime - b.nextAvailableTime;
            return a.id - b.id;
        });
        for (int i = 0; i < n; i++)
            rooms.add(new Room(i, 0));
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        for (int[] meeting : meetings) {
            int startTime = meeting[0], endTime = meeting[1];
            while (!occupied.isEmpty() && occupied.peek().nextAvailableTime <= startTime) {
                Room released = occupied.poll();
                released.nextAvailableTime = 0;
                rooms.add(released);
            }
            if (!rooms.isEmpty()) {
                Room booked = rooms.poll();
                booked.nextAvailableTime = endTime;
                occupied.add(booked);
                result[booked.id]++;
            } else {
                Room pullOccupiedRoomWithDelay = occupied.poll();
                int delay = pullOccupiedRoomWithDelay.nextAvailableTime - startTime;
                pullOccupiedRoomWithDelay.nextAvailableTime = endTime + delay;
                occupied.add(pullOccupiedRoomWithDelay);
                result[pullOccupiedRoomWithDelay.id]++;
            }
        }
        int ans = 0;
        for (int i = 1; i < n; i++)
            if (result[i] > result[ans])
                ans = i;
        return ans;
    }
}