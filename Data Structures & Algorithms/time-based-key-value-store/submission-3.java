class TimeMap {

    Map<Integer, HashMap<String, String>> keyValueStore;
    Map<String, List<Integer>> timestampsTracker;

    public TimeMap() {
        keyValueStore = new HashMap<>();
        timestampsTracker = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        HashMap<String, String> keyValuePair = new HashMap<>();
        keyValuePair.put(key, value);
        keyValueStore.put(timestamp, keyValuePair);
        if (timestampsTracker.containsKey(key)) {
            timestampsTracker.get(key).add(timestamp);
        } else {
            List<Integer> timestamps = new ArrayList<>();
            timestamps.add(timestamp);
            timestampsTracker.put(key, timestamps);
        }
    }
    
    public String get(String key, int timestamp) {
        List<Integer> timestamps = timestampsTracker.get(key);
        int targetTimestamp = 0;
        int low = 0, high = timestamps != null ? timestamps.size() - 1 : -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (timestamps.get(mid) == timestamp) {
                targetTimestamp = timestamp;
                break;
            } else if (timestamps.get(mid) < timestamp) {
                targetTimestamp = timestamps.get(mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return targetTimestamp > 0 ? keyValueStore.get(targetTimestamp).get(key) : "";
    }
}
