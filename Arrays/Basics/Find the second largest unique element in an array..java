 //Implementation 1: Basic Iterative (Efficient, O(n))

public class Main {
    public static int findSecondLargest(int[] arr) {
        int max = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > max) {
                second = max;
                max = num;
            } else if (num > second && num != max) {
                second = num;
            }
        }

        return (second == Integer.MIN_VALUE) ? -1 : second;
    }
}

// Implementation 2: Sort and Pick (Simple but O(n log n))

import java.util.Arrays;

public class Main {
    public static int findSecondLargest(int[] arr) {
        Arrays.sort(arr);  // ascending sort
        int max = arr[arr.length - 1];

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] != max) {
                return arr[i];
            }
        }
        return -1; // No second largest
    }
}

// Implementation 3: Using TreeSet (Unique & Sorted)

import java.util.TreeSet;

public class Main {
    public static int findSecondLargest(int[] arr) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : arr) {
            set.add(num);
        }

        if (set.size() < 2) return -1;

        set.remove(set.last()); // Remove largest
        return set.last();      // Now second largest
    }
}

//Implementation 4: Using PriorityQueue (Max-Heap)

import java.util.*;

public class Main {
    public static int findSecondLargest(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {
            if (seen.add(num)) {
                pq.offer(num);
            }
        }

        if (pq.size() < 2) return -1;
        pq.poll(); // Remove largest
        return pq.poll(); // Second largest
    }
}

// Implementation 5: Brute Force (for understanding only)

public class Main {
    public static int findSecondLargest(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > max) max = num;
        }

        int second = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > second && num < max) {
                second = num;
            }
        }

        return (second == Integer.MIN_VALUE) ? -1 : second;
    }
}
