class TimeMap {

    Map<String, String>[] keyValueStore;

    public TimeMap() {
        keyValueStore = new Map[1001];
        for (int i = 1; i < 1001; i++) {
            keyValueStore[i] = new HashMap<>();
        }
    }
    
    public void set(String key, String value, int timestamp) {
        HashMap<String, String> keyValuePair = new HashMap<>();
        keyValuePair.put(key, value);
        keyValueStore[timestamp] = keyValuePair;
    }
    
    public String get(String key, int timestamp) {
        if (timestamp > 1000) timestamp = 1000;
        String result = "";
        while (timestamp > 0) {
            if (keyValueStore[timestamp] != null && keyValueStore[timestamp].containsKey(key)) {
                result = keyValueStore[timestamp].get(key);
                break;
            }
            timestamp--;
        }
        return result;
    }
}
