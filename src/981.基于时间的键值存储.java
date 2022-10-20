import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=981 lang=java
 *
 * [981] 基于时间的键值存储
 */

// @lc code=start
class TimeMap {
    class Node {
        String k, v; 
        int t;
        Node (String _k, String _v, int _t) {
            k = _k; v = _v; t = _t;
        }
    }

    private Map<String, List<Node>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Node> list = timeMap.getOrDefault(key, new ArrayList<>());
        list.add(new Node(key, value, timestamp));
        timeMap.putIfAbsent(key, list);
    }
    
    public String get(String key, int timestamp) {
        List<TimeMap.Node> list = timeMap.get(key);
        if (list == null || list.get(0).t > timestamp) {
            return "";
        }

        int i = 0;
        int j = list.size();
        while (i<j) {
            int mid = i + (j-i)/2;
            Node midNode = list.get(mid);
            if (midNode.t == timestamp) {
                return midNode.v;
            }

            if (midNode.t > timestamp) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return list.get(i-1).v;
        // return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
// @lc code=end

