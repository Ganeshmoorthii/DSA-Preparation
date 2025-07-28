// Solution 1: Traverse from Right (Efficient)
import java.util.*;

class Solution {
    public List<Integer> arrayLeaders(int[] arr) {
        List<Integer> leaders = new ArrayList<>();
        int n = arr.length;
        int maxRight = arr[n - 1];
        leaders.add(maxRight);  // last element is always a leader

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > maxRight) {
                maxRight = arr[i];
                leaders.add(maxRight);
            }
        }

        // Optional: reverse to maintain left-to-right order
        Collections.reverse(leaders);
        return leaders;
    }
}

// Solution 2. Brute Force (O(n²))
public List<Integer> leaders2(int[] arr) {
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
        boolean isLeader = true;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] > arr[i]) {
                isLeader = false;
                break;
            }
        }
        if (isLeader) result.add(arr[i]);
    }
    return result;
}

// Solution 3. Using Stack
public List<Integer> leaders3(int[] arr) {
    Stack<Integer> stack = new Stack<>();
    int max = arr[arr.length - 1];
    stack.push(max);

    for (int i = arr.length - 2; i >= 0; i--) {
        if (arr[i] > max) {
            max = arr[i];
            stack.push(max);
        }
    }

    List<Integer> result = new ArrayList<>();
    while (!stack.isEmpty()) result.add(stack.pop());
    return result;
}

// Solution  4. Using Recursion
public List<Integer> leaders4(int[] arr) {
    List<Integer> result = new ArrayList<>();
    helper(arr, arr.length - 1, Integer.MIN_VALUE, result);
    Collections.reverse(result);
    return result;
}

private void helper(int[] arr, int index, int maxRight, List<Integer> result) {
    if (index < 0) return;
    if (arr[index] > maxRight) {
        result.add(arr[index]);
        maxRight = arr[index];
    }
    helper(arr, index - 1, maxRight, result);
}

// Solution 5. Using Streams (Java 8+) — Not optimal, but modern
public List<Integer> leaders5(int[] arr) {
    List<Integer> result = new ArrayList<>();
    int n = arr.length;
    for (int i = 0; i < n; i++) {
        final int current = arr[i];
        boolean isLeader = IntStream.range(i + 1, n).allMatch(j -> arr[j] <= current);
        if (isLeader) result.add(current);
    }
    return result;
}
