// Solution 1: Using XOR (Most Optimal)
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;  // XORing all numbers
        }
        return res;
    }
}

//  Solution 2: Using HashSet
import java.util.HashSet;

class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) set.remove(num);
            else set.add(num);
        }
        // The only remaining element is the single number
        return set.iterator().next();
    }
}

// Solution 3: Using HashMap (for learning)
import java.util.HashMap;

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1) return key;
        }
        return -1; // Should never happen
    }
}

