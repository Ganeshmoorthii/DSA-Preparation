// 1. Brute Force (Triple Loop)
int longestSubarrayBrute(int[] a, int k) {
    int n = a.length, maxLen = 0;
    for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
            int sum = 0;
            for (int x = i; x <= j; x++) {
                sum += a[x];
            }
            if (sum == k) maxLen = Math.max(maxLen, j - i + 1);
        }
    }
    return maxLen;
}

// 2. Prefix Sum (Double Loop)
int longestSubarrayPrefix(int[] a, int k) {
    int n = a.length, maxLen = 0;
    int[] prefix = new int[n + 1];
    for (int i = 0; i < n; i++) prefix[i + 1] = prefix[i] + a[i];
    
    for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
            if (prefix[j + 1] - prefix[i] == k)
                maxLen = Math.max(maxLen, j - i + 1);
        }
    }
    return maxLen;
}

// 3. HashMap + Prefix Sum (Optimal for All Integers)
import java.util.*;

int longestSubarrayHash(int[] a, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int sum = 0, maxLen = 0;
    for (int i = 0; i < a.length; i++) {
        sum += a[i];
        if (sum == k) maxLen = i + 1;
        if (!map.containsKey(sum)) map.put(sum, i);
        if (map.containsKey(sum - k)) {
            maxLen = Math.max(maxLen, i - map.get(sum - k));
        }
    }
    return maxLen;
}

// 4. Sliding Window (For Positive Numbers Only)
int longestSubarraySliding(int[] a, int k) {
    int left = 0, sum = 0, maxLen = 0;
    for (int right = 0; right < a.length; right++) {
        sum += a[right];
        while (sum > k && left <= right) {
            sum -= a[left++];
        }
        if (sum == k) maxLen = Math.max(maxLen, right - left + 1);
    }
    return maxLen;
}

// 5. Binary Search + Prefix Sum (Works with Sorted Prefix)
import java.util.*;

int longestSubarrayBinarySearch(int[] a, int k) {
    int n = a.length, maxLen = 0;
    long[] prefix = new long[n + 1];
    for (int i = 0; i < n; i++) prefix[i + 1] = prefix[i] + a[i];
    
    TreeMap<Long, Integer> map = new TreeMap<>();
    for (int i = 0; i <= n; i++) {
        long need = prefix[i] - k;
        if (map.containsKey(need)) {
            maxLen = Math.max(maxLen, i - map.get(need));
        }
        map.putIfAbsent(prefix[i], i);
    }
    return maxLen;
}
