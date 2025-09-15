// 1. Sorting + Greedy (Most Popular)
import java.util.*;

class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int ans = arr[n - 1] - arr[0];
        int small = arr[0] + k;
        int big = arr[n - 1] - k;
        
        if (small > big) {
            int temp = small;
            small = big;
            big = temp;
        }

        for (int i = 1; i < n - 1; i++) {
            int subtract = arr[i] - k;
            int add = arr[i] + k;

            if (subtract >= small || add <= big) continue;

            if (big - subtract <= add - small) {
                small = subtract;
            } else {
                big = add;
            }
        }

        return Math.min(ans, big - small);
    }
}

// 2. Brute Force (Check All Combinations)
class Solution {
    int ans = Integer.MAX_VALUE;

    public int getMinDiff(int[] arr, int n, int k) {
        dfs(arr, n, k, 0);
        return ans;
    }

    private void dfs(int[] arr, int n, int k, int idx) {
        if (idx == n) {
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            for (int h : arr) {
                max = Math.max(max, h);
                min = Math.min(min, h);
            }
            ans = Math.min(ans, max - min);
            return;
        }
        int orig = arr[idx];
        arr[idx] = orig + k;
        dfs(arr, n, k, idx + 1);
        arr[idx] = orig - k;
        dfs(arr, n, k, idx + 1);
        arr[idx] = orig; // backtrack
    }
}

// 3. Priority Queue Approach
import java.util.*;

class Solution {
    public int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int h : arr) pq.add(h);

        int minDiff = arr[n - 1] - arr[0];

        for (int i = 0; i < n; i++) {
            int[] modified = arr.clone();
            modified[i] += k;
            modified[0] += k;
            Arrays.sort(modified);
            minDiff = Math.min(minDiff, modified[n - 1] - modified[0]);
        }
        return minDiff;
    }
}

// 4. Two-Pointer Sliding Window Trick
class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int ans = arr[n-1] - arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] - k < 0) continue;
            int min = Math.min(arr[0] + k, arr[i] - k);
            int max = Math.max(arr[i-1] + k, arr[n-1] - k);
            ans = Math.min(ans, max - min);
        }
        return ans;
    }
}

// 5. Binary Search + Check
import java.util.*;

class Solution {
    public int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int lo = 0, hi = arr[n-1] - arr[0], ans = hi;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (canAchieve(arr, n, k, mid)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    private boolean canAchieve(int[] arr, int n, int k, int diff) {
        int min = arr[0] + k, max = arr[0] + k;
        for (int i = 1; i < n; i++) {
            int low = arr[i] - k, high = arr[i] + k;
            if (high < min || low > max) return false;
            min = Math.max(min, low);
            max = Math.min(max, high);
        }
        return max - min <= diff;
    }
}

