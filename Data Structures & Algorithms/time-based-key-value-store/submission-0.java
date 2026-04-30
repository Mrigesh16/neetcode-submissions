class TimeMap {

    Map<String, List<Pair<Integer, String>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair<>(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        List<Pair<Integer, String>> list = map.get(key);

        int left = 0, right = list.size() - 1;
        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid).getKey() <= timestamp) {
                result = list.get(mid).getValue(); // candidate
                left = mid + 1; // go right
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}