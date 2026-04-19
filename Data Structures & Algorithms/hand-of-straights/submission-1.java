class Solution {
    public void removeElement(HashMap<Integer, Integer> map, PriorityQueue<Integer> pq, int element) {
        int count = map.get(element);
        if (count == 1) {
            map.remove(element);
        } else {
            map.put(element, count - 1);
        }
        pq.remove(element);
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        for (int num : hand) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            pq.add(num);
        }
        int totalGroups = hand.length / groupSize;
        while (totalGroups-- > 0) {
            int min = pq.peek();
            removeElement(map, pq, min);
            for (int i = 1; i < groupSize; i++) {
                if (map.getOrDefault(min + i, 0) == 0)
                    return false;
                removeElement(map, pq, min + i);
            }
        }
        return true;
    }
}